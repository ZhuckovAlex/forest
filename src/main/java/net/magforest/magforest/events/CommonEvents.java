package net.magforest.magforest.events;

import net.magforest.magforest.entity.ModEntityTypes;
import net.magforest.magforest.entity.custom.MoonMothEntity;
import net.magforest.magforest.entity.villager.ModVillager;
import net.magforest.magforest.item.custom.ModSpawnEggItem;
import net.magforest.magforest.magforest;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = magforest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.MOON_MOTH.get(), MoonMothEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(()-> {
            ModVillager.fillTradeData();
            ModVillager.registerPOI();
        });
}

}