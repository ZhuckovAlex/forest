package net.magforest.magforest.world.gen;

import net.magforest.magforest.world.biome.MagicForest;
import net.magforest.magforest.world.structure.ModStructures;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModStructureGeneration {
    public static void generateStructures(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.WIZARD_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }


        if(event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.DESERT.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.PLAINS.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.SWAMP.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.DARK_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.BAMBOO_JUNGLE.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.MUSHROOM_FIELDS.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.BEACH.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.JUNGLE.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.FLOWER_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.BIRCH_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.TAIGA.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.ICE_SPIKES.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.SAVANNA.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.SAVANNA_PLATEAU.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.DESERT_LAKES.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.RIVER.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.FROZEN_RIVER.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.GIANT_SPRUCE_TAIGA.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.GIANT_SPRUCE_TAIGA_HILLS.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CRYSTAL_SAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }


        if(event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.DESERT.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.PLAINS.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.SWAMP.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.DARK_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.BAMBOO_JUNGLE.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.MUSHROOM_FIELDS.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.BEACH.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.JUNGLE.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.FLOWER_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.BIRCH_FOREST.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.TAIGA.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.SAVANNA.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.SAVANNA_PLATEAU.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.DESERT_LAKES.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.RIVER.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.FROZEN_RIVER.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.GIANT_SPRUCE_TAIGA.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(event.getName().equals(Biomes.GIANT_SPRUCE_TAIGA_HILLS.getLocation())) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ANCIENT_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }


    }
}
