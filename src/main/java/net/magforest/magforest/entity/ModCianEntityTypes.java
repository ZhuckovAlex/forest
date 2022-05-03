package net.magforest.magforest.entity;

import net.magforest.magforest.entity.custom.ModCianBoatEntity;
import net.magforest.magforest.magforest;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModCianEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, magforest.MOD_ID);

    public static final RegistryObject<EntityType<ModCianBoatEntity>> CIAN_BOAT =
            ENTITY_TYPES.register("cian_boat",
                    () -> EntityType.Builder.<ModCianBoatEntity>create(ModCianBoatEntity::new,
                                    EntityClassification.MISC).size(0.5f, 0.5f)
                            .build(new ResourceLocation(magforest.MOD_ID, "cian_boat").toString()));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
