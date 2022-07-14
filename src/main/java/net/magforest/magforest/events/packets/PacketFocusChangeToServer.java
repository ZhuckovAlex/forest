package net.magforest.magforest.events.packets;

import net.magforest.magforest.events.SimplePacketBase;
import net.magforest.magforest.item.ItemFocus;
import net.magforest.magforest.item.ItemWand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.Supplier;

public class PacketFocusChangeToServer extends SimplePacketBase {

    private int dim;
    private int playerid;
    private String focus;

    public PacketFocusChangeToServer(PlayerEntity player, String focus) {
        this.dim = player.getEntityWorld().getDimensionType().hashCode();
        this.playerid = player.getEntityId();
        this.focus = focus;
    }

    public PacketFocusChangeToServer(PacketBuffer buffer){
        this.dim = buffer.readInt();
        this.playerid = buffer.readInt();
        this.focus = buffer.readString();
    }


    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeInt(this.dim);
        buffer.writeInt(this.playerid);
        buffer.writeString(this.focus);
    }

    @Override
    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerWorld world = context.get().getSender().getServerWorld();
            if(world != null && (context.get().getSender() == null || context.get().getSender().getEntityId() == this.playerid)) {
                Entity player = world.getEntityByID(this.playerid);
                if(player != null && player instanceof PlayerEntity && ((PlayerEntity)player).getHeldItem(Hand.MAIN_HAND) != null && ((PlayerEntity)player).getHeldItem(Hand.MAIN_HAND).getItem() instanceof ItemWand && !((ItemWand)((PlayerEntity)player).getHeldItem(Hand.MAIN_HAND).getItem()).isSceptre(((PlayerEntity)player).getHeldItem(Hand.MAIN_HAND))) {
                    changeFocus(((PlayerEntity)player).getHeldItem(Hand.MAIN_HAND), world, (PlayerEntity)player, this.focus);
                }

                return;
            } else {
                return;
            }

        });
    }

    public static void changeFocus(ItemStack is, World w, PlayerEntity player, String focus) {
        ItemWand wand = (ItemWand)is.getItem();
        TreeMap<String, Integer> foci = new TreeMap();
        HashMap<Integer, Integer> pouches = new HashMap();

        ItemStack item = null;


        int newkey;



        for(newkey = 0; newkey < 36; ++newkey) {
            item = player.inventory.mainInventory.get(newkey);
            if(item != null && item.getItem() instanceof ItemFocus) {
                foci.put(((ItemFocus)item.getItem()).getSortingHelper(item), Integer.valueOf(newkey));
            }


        }

        if(!focus.equals("REMOVE") && foci.size() != 0) {
            if(foci != null && foci.size() > 0 && focus != null) {
                String var15 = focus;
                if(foci.get(focus) == null) {
                    var15 = (String)foci.higherKey(focus);
                }

                if(var15 == null || foci.get(var15) == null) {
                    var15 = (String)foci.firstKey();
                }

                if(((Integer)foci.get(var15)).intValue() < 1000 && ((Integer)foci.get(var15)).intValue() >= 0) {
                    item = player.inventory.mainInventory.get(((Integer)foci.get(var15)).intValue()).copy();
                }

                if(item == null) {
                    return;
                }

                if(((Integer)foci.get(var15)).intValue() < 1000 && ((Integer)foci.get(var15)).intValue() >= 0) {
                    player.inventory.setInventorySlotContents(((Integer)foci.get(var15)).intValue(), ItemStack.EMPTY);
                }

                if(wand.getFocus(is) != null && ( player.inventory.addItemStackToInventory((wand.getFocusItem(is)==null?ItemStack.EMPTY:wand.getFocusItem(is).copy())))) {
                    wand.setFocus(is, ItemStack.EMPTY);
                }

                if(wand.getFocus(is) == null) {
                    wand.setFocus(is, item);
                } else {
                    player.inventory.addItemStackToInventory(item);
                }
            }

        } else {
            if(wand.getFocus(is) != null && (player.inventory.addItemStackToInventory((wand.getFocusItem(is)==null?ItemStack.EMPTY:wand.getFocusItem(is).copy())))) {
                wand.setFocus(is, ItemStack.EMPTY);
            }

        }
    }
}
