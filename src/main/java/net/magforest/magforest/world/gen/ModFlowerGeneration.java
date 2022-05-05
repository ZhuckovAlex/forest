package net.magforest.magforest.world.gen;

import net.magforest.magforest.world.biome.MagicForest;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModFlowerGeneration {

    public static void generateFlower(final BiomeLoadingEvent event){

        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.THE_CALL_OF_THE_ANCESTORS_CONFIG);
            base.add(() -> ModConfiguredFeatures.HYACINTH_CONFIG);
            base.add(() -> ModConfiguredFeatures.THISTLE_CONFIG);
        }
        if(event.getName().equals(Biomes.DARK_FOREST.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.THE_CALL_OF_THE_ANCESTORS_CONFIG);
        }

    }

}
