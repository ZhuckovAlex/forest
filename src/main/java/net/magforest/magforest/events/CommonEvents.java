package net.magforest.magforest.events;

import net.magforest.magforest.entity.villager.ModVillager;
import net.magforest.magforest.magforest;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = magforest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(()-> {
            ModVillager.fillTradeData();
            ModVillager.registerPOI();
        });
}

}