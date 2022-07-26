package net.magforest.magforest.events;

import net.magforest.magforest.entity.ModEntityTypes;
import net.magforest.magforest.entity.custom.MoonMothEntity;
import net.magforest.magforest.entity.villager.ModVillager;
import net.magforest.magforest.item.custom.ModSpawnEggItem;
import net.magforest.magforest.magforest;
import net.magforest.magforest.particles.BeamParticleData;
import net.magforest.magforest.particles.BeamParticleType;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = magforest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    public static ParticleType<BeamParticleData> beamParticleType;

    @SubscribeEvent
    public static void onIParticleTypeRegistration(RegistryEvent.Register<ParticleType<?>> iParticleTypeRegisterEvent) {
        beamParticleType = new BeamParticleType();
        beamParticleType.setRegistryName(magforest.MOD_ID,"magforest_beam_particle_type_registry_name");
        iParticleTypeRegisterEvent.getRegistry().register(beamParticleType);
    }
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