package net.magforest.magforest.world.biome;

import net.magforest.magforest.magforest;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class MagicForest
{
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            magforest.MOD_ID);

    // Add more biomes here!
    static {
        createBiome("magic_forest", BiomeMaker::makeVoidBiome);
    }

    // (and also here!)
    public static RegistryKey<Biome> MAGIC_FOREST = registerBiome("magic_forest");

    public static RegistryKey<Biome> registerBiome(String biomeName) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(magforest.MOD_ID, biomeName));
    }

    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }


    public static void registerBiomes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(MAGIC_FOREST, 5));
    }
}