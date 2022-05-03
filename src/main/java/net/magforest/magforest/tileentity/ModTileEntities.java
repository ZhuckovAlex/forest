package net.magforest.magforest.tileentity;

import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.magforest;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, magforest.MOD_ID);

    public static RegistryObject<TileEntityType<LightMachineTile>> MOON_TEAR_LIGHTING_TILE =
            TILE_ENTITIES.register("moon_tear_lightning_rod_tile", () -> TileEntityType.Builder.create(
                    LightMachineTile::new, ModBlocks.MOON_TEAR_LIGHTING_ROD.get()).build(null));

    public static RegistryObject<TileEntityType<SolarConverterTile>> SOLAR_CONVERTER_TILE =
            TILE_ENTITIES.register("solar_converter_tile", () -> TileEntityType.Builder.create(
                    SolarConverterTile::new, ModBlocks.SOLAR_CONVERTER.get()).build(null));

    public static final RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITIES =
            TILE_ENTITIES.register("sign", () -> TileEntityType.Builder.create(ModSignTileEntity::new,
                    ModBlocks.CIAN_SIGN.get(),
                    ModBlocks.CIAN_WALL_SIGN.get(),
                    ModBlocks.DARK_BIRCH_SIGN.get(),
                    ModBlocks.DARK_BIRCH_WALL_SIGN.get()
            ).build(null));


    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}