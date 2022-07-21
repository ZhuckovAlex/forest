package net.magforest.magforest.entity;

import net.magforest.magforest.entity.custom.MoonMothEntity;
import net.magforest.magforest.entity.projectile.EntityAir;
import net.magforest.magforest.entity.projectile.EntityEmber;
import net.magforest.magforest.entity.projectile.EntityFrostShard;
import net.magforest.magforest.magforest;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, magforest.MOD_ID);

    public static final RegistryObject<EntityType<MoonMothEntity>> MOON_MOTH =
            ENTITY_TYPES.register("moon_moth",()-> EntityType.Builder.create(MoonMothEntity::new,
                            EntityClassification.AMBIENT).size(1f,1f)
                    .build(new ResourceLocation(magforest.MOD_ID, "moon_moth").toString()));
    public static final RegistryObject<EntityType<EntityEmber>> EMBER =
            ENTITY_TYPES.register("ember", () -> EntityType.Builder.create(EntityEmber::new,
                            EntityClassification.MISC).size(0.25F, 0.25F).trackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(magforest.MOD_ID, "ember").toString()));
    public static final RegistryObject<EntityType<EntityFrostShard>> FROST_SHARD =
            ENTITY_TYPES.register("frost_shard", () -> EntityType.Builder.create(EntityFrostShard::new,
                            EntityClassification.MISC).size(0.15F, 0.15F).trackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(magforest.MOD_ID, "frost_shard").toString()));
    public static final RegistryObject<EntityType<EntityAir>> AIR_BLOW =
            ENTITY_TYPES.register("air_blow", () -> EntityType.Builder.create(EntityAir::new,
                            EntityClassification.MISC).size(0.15F, 0.15F).trackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(magforest.MOD_ID, "air_blow").toString()));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
