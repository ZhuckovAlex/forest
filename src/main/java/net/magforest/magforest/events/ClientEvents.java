package net.magforest.magforest.events;

import net.magforest.magforest.events.packets.PacketFocusChangeToServer;
import net.magforest.magforest.item.ItemWand;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber( modid = magforest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class ClientEvents {

    public static KeyBinding keyF = new KeyBinding("Change Wand Focus", 89, "key.categories.misc");
    private static boolean keyPressedF = false;
    public static boolean radialActive = false;
    public static boolean radialLock = false;
    public static long lastPressF = 0L;
    public static REHWandHandler wandHandler;


    @SubscribeEvent
    public static void renderOverlay(RenderGameOverlayEvent event)
    {

           Minecraft mc = Minecraft.getInstance();
           long time = System.nanoTime() / 1000000L;
           if (wandHandler == null)
               wandHandler = new REHWandHandler();
          if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
                {
                  wandHandler.handleFociRadial(mc, time, event);
              }

     }
    @SubscribeEvent
    public static void ticker(TickEvent.PlayerTickEvent event) {
        if (event.side.isClient()) {
            if (event.phase == TickEvent.Phase.START)
            {
                if (keyF.isKeyDown()) {
                    if (Minecraft.getInstance().isGameFocused()) {
                        PlayerEntity player = event.player;
                        if (player != null) {
                            if (!ClientEvents.keyPressedF) {
                                ClientEvents.lastPressF = System.currentTimeMillis();
                                ClientEvents.radialLock = false;
                            }

                        if ((!ClientEvents.radialLock) && (player.getHeldItem(Hand.MAIN_HAND) != null) && ((player.getHeldItem(Hand.MAIN_HAND).getItem() instanceof ItemWand)) && (!((ItemWand) player.getHeldItem(Hand.MAIN_HAND).getItem()).isSceptre(player.getHeldItem(Hand.MAIN_HAND)))) {
                            if (player.isSneaking()) {
                                PacketHandler.PACKET_HANDLER.sendToServer(new PacketFocusChangeToServer(player, "REMOVE"));
                            } else {
                                ClientEvents.radialActive = true;
                            }
                        }
                        }
                    ClientEvents.keyPressedF = true;
                }
           } else {
                ClientEvents.radialActive = false;
           if (ClientEvents.keyPressedF) ClientEvents.lastPressF = System.currentTimeMillis();
                ClientEvents.keyPressedF = false;
           }
            }
        }
    }
}
