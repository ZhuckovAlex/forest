package net.magforest.magforest.world.gen;

import com.google.common.collect.ImmutableList;
import net.magforest.magforest.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CRIMSON =
            register("crimson", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(Blocks.CRIMSON_STEM.getDefaultState()),
                            new SimpleBlockStateProvider(Blocks.NETHER_WART_BLOCK.getDefaultState()),
                            new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                            new ForkyTrunkPlacer(5, 2, 2),
                            new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WARPED =
            register("warped", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(Blocks.WARPED_STEM.getDefaultState()),
                            new SimpleBlockStateProvider(Blocks.WARPED_WART_BLOCK.getDefaultState()),
                            new AcaciaFoliagePlacer(FeatureSpread.create(2),
                                    FeatureSpread.create(0)),
                            new ForkyTrunkPlacer(5, 2, 2),
                            new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));


    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BIG_CIAN =
            register("big_cian", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.CIAN_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.CIAN_LEAVES.get().getDefaultState()),
                            new DarkOakFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0)),
                            new DarkOakTrunkPlacer(6, 2, 1),
                            new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                      .setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CIAN =
            register("cian", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.CIAN_LOG.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.CIAN_LEAVES.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                            new StraightTrunkPlacer(4, 2, 1),
                            new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BEE_CIAN =
            register("bee_cian", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.CIAN_LOG.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.CIAN_LEAVES.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                            new StraightTrunkPlacer(5, 2, 6),
                            new TwoLayerFeature(1, 0, 1))).setIgnoreVines().setDecorators(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT)).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DARK_BIRCH =
            register("dark_birch", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.DARK_BIRCH_LOG.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.DARK_BIRCH_LEAVES.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                            new StraightTrunkPlacer(4, 2, 1),
                            new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> HYACINTH_CONFIG = Feature.FLOWER.withConfiguration((
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.HYACINTH.get().getDefaultState()),
                    SimpleBlockPlacer.PLACER)).tries(1).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(1);
    public static final ConfiguredFeature<?, ?> BLACK_TOADSTOOL_CONFIG = Feature.FLOWER.withConfiguration((
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BLACK_TOADSTOOL.get().getDefaultState()),
                            SimpleBlockPlacer.PLACER)).tries(1).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(2);
    public static final ConfiguredFeature<?, ?> THISTLE_CONFIG = Feature.FLOWER.withConfiguration((
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.THISTLE.get().getDefaultState()),
                            SimpleBlockPlacer.PLACER)).tries(1).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(30);
    public static final ConfiguredFeature<?, ?> ICY_YAWN_CONFIG = Feature.FLOWER.withConfiguration((
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.ICY_YAWN.get().getDefaultState()),
                            SimpleBlockPlacer.PLACER)).tries(1).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(2);
    public static final ConfiguredFeature<?, ?> SILVER_SAGE_CONFIG = Feature.FLOWER.withConfiguration((
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.SILVER_SAGE.get().getDefaultState()),
                            SimpleBlockPlacer.PLACER)).tries(1).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(1);


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
