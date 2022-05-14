package net.magforest.magforest.entity;

import net.magforest.magforest.entity.custom.MoonMothEntity;
import net.magforest.magforest.entity.model.MoonMothModel;
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


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
