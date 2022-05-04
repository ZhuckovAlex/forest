package net.magforest.magforest.world.gen;

import net.magforest.magforest.world.biome.MagicForest;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public abstract class ModTreeGeneration {

    public static void generateTrees(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if (event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModConfiguredFeatures.BIG_CIAN
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.05f, 2))));
        }
        if (event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModConfiguredFeatures.CIAN
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.2f, 4))));
        }
        if (event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModConfiguredFeatures.BEE_CIAN
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.4f, 4))));
        }
        if (event.getName().equals(MagicForest.MAGIC_FOREST.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>>base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.DARK_BIRCH
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0,0.05f, 1))));
        }
        if (event.getName().equals(Biomes.BIRCH_FOREST.getLocation())){
                List<Supplier<ConfiguredFeature<?, ?>>>base =
                        event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.DARK_BIRCH
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0,0.05f, 1))));
        }
        if (event.getName().equals(Biomes.BIRCH_FOREST_HILLS.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>>base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.DARK_BIRCH
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0,0.05f, 1))));
        }
        if (event.getName().equals(Biomes.TALL_BIRCH_FOREST.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>>base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.DARK_BIRCH
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0,0.05f, 1))));
        }
        if (event.getName().equals(Biomes.TALL_BIRCH_HILLS.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>>base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.DARK_BIRCH
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0,0.05f, 1))));
        }
        if (event.getName().equals(Biomes.SWAMP.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>>base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.DARK_BIRCH
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0,0.1f, 1))));
        }
        if (event.getName().equals(Biomes.SWAMP_HILLS.getLocation())){
            List<Supplier<ConfiguredFeature<?, ?>>>base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.DARK_BIRCH
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0,0.1f, 1))));
        }
    }
}
