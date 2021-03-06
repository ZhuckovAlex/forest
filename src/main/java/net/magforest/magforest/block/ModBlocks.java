package net.magforest.magforest.block;

import net.magforest.magforest.block.custom.*;

import net.magforest.magforest.block.custom.trees.CianTree;
import net.magforest.magforest.block.custom.trees.CrimsonTree;
import net.magforest.magforest.block.custom.trees.DarkBirchTree;
import net.magforest.magforest.block.custom.trees.WarpedTree;
import net.magforest.magforest.item.ModItemGroup;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.magforest.magforest.item.custom.util.ModSoundEvents;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


public class ModBlocks extends Blocks
{
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, magforest.MOD_ID);


    public static final RegistryObject<Block> CIAN_LOG = registerBlock("cian_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_WOOD = registerBlock("cian_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_CIAN_LOG = registerBlock("stripped_cian_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_CIAN_WOOD = registerBlock("stripped_cian_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_PLANKS = registerBlock("cian_planks",
            () -> new FlameBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_LEAVES = BLOCKS.register("cian_leaves",
            () -> new FlameLeaves(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)
                    .hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> CIAN_SAPLING = BLOCKS.register("cian_sapling",
            () -> new FlameSaplings(new CianTree(), AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> CIAN_STAIRS = registerBlock("cian_stairs",
            () -> new FlameStairsBlock(() -> CIAN_PLANKS.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_FENCE = registerBlock("cian_fence",
            () -> new FlameFenceBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_FENCE_GATE = registerBlock("cian_fence_gate",
            () -> new FlameGateFenceBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_SLAB = registerBlock("cian_slab",
            () -> new FlameSlabBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_BUTTON = registerBlock("cian_button",
            () -> new FlameButton(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)
                    .setLightLevel(value -> 6).doesNotBlockMovement()));
    public static final RegistryObject<Block> CIAN_PRESSURE_PLATE = registerBlock("cian_pressure_plate",
            () -> new FlamePressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CIAN_DOOR = registerBlock("cian_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CIAN_TRAPDOOR = registerBlock("cian_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> HYACINTH = BLOCKS.register("hyacinth",
            () -> new FlowerBlock(Effects.REGENERATION,80, AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT).setLightLevel(value -> 2)));
    public static final RegistryObject<Block> BLACK_TOADSTOOL = BLOCKS.register("black_toadstool",
            () -> new MushroomBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> SILVER_SAGE = BLOCKS.register("silver_sage",
            () -> new FlowerBlock(Effects.REGENERATION,80, AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> ICY_YAWN = BLOCKS.register("icy_yawn",
            () -> new FlowerBlock(Effects.SLOWNESS,80, AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> SLEEPY_LEAF = BLOCKS.register("sleepy_leaf",
            () -> new FlowerBlock(Effects.SLOWNESS,80, AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));

    public static final RegistryObject<Block> CIAN_SIGN = BLOCKS.register("cian_sign",
            () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1).sound(SoundType.WOOD), ModWoodTypes.CIAN));
    public static final RegistryObject<Block> CIAN_WALL_SIGN = BLOCKS.register("cian_wall_sign",
            () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1).sound(SoundType.WOOD), ModWoodTypes.CIAN));
    public static final RegistryObject<Block> KARAMBOLA = BLOCKS.register("karambola_crops",
            () -> new KarambolaBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> SEEDS_OF_THE_CALL_OF_THE_ANCESTORS = BLOCKS.register("seeds_of_the_call_of_the_ancestors",
            () -> new CallOfAncestorsBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> DARK_BIRCH_LOG = registerBlock("dark_birch_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_WOOD = registerBlock("dark_birch_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_DARK_BIRCH_LOG = registerBlock("stripped_dark_birch_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_DARK_BIRCH_WOOD = registerBlock("stripped_dark_birch_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_SAPLING = BLOCKS.register("dark_birch_sapling",
            () -> new FlameSaplings(new DarkBirchTree(), AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> DARK_BIRCH_LEAVES = BLOCKS.register("dark_birch_leaves",
            () -> new FlameLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> DARK_BIRCH_PLANKS = registerBlock("dark_birch_planks",
            () -> new FlameBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_STAIRS = registerBlock("dark_birch_stairs",
            () -> new FlameStairsBlock(() -> DARK_BIRCH_PLANKS.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_FENCE = registerBlock("dark_birch_fence",
            () -> new FlameFenceBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_FENCE_GATE = registerBlock("dark_birch_fence_gate",
            () -> new FlameGateFenceBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_SLAB = registerBlock("dark_birch_slab",
            () -> new FlameSlabBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_BUTTON = registerBlock("dark_birch_button",
            () -> new FlameButton(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).doesNotBlockMovement()));
    public static final RegistryObject<Block> DARK_BIRCH_PRESSURE_PLATE = registerBlock("dark_birch_pressure_plate",
            () -> new FlamePressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_BIRCH_DOOR = registerBlock("dark_birch_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> DARK_BIRCH_TRAPDOOR = registerBlock("dark_birch_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> DARK_BIRCH_SIGN = BLOCKS.register("dark_birch_sign",
            () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1).sound(SoundType.WOOD), ModWoodTypes.DARK_BIRCH));
    public static final RegistryObject<Block> DARK_BIRCH_WALL_SIGN = BLOCKS.register("dark_birch_wall_sign",
            () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1).sound(SoundType.WOOD), ModWoodTypes.DARK_BIRCH));


    public static final RegistryObject<Block> MOON_TEAR_OBSIDIAN_ORE = registerBlock("moon_tear_obsidian_ore",
            () -> new ModOreBlockMoonTear(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool()
                    .hardnessAndResistance(18).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.MOON_TEAR.get(), () -> ModSoundEvents.MOON_TEAR.get(),
                            () -> ModSoundEvents.MOON_TEAR.get(), () -> ModSoundEvents.MOON_TEAR.get(),
                            () -> ModSoundEvents.MOON_TEAR.get()))));
    public static final RegistryObject<Block> MOON_TEAR_BLOCK = registerBlock("moon_tear_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()
                    .hardnessAndResistance(8).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.MOON_TEAR.get(), () -> ModSoundEvents.MOON_TEAR.get(),
                            () -> ModSoundEvents.MOON_TEAR.get(), () -> ModSoundEvents.MOON_TEAR.get(),
                            () -> ModSoundEvents.MOON_TEAR.get()))));
    public static final RegistryObject<Block> AMAROST_BLOCK = registerBlock("amarost_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool()
                    .hardnessAndResistance(25).sound(SoundType.NETHERITE)));
    public static final RegistryObject<Block> MOON_TEAR_LIGHTING_ROD = registerBlock("moon_tear_lighting_rod",
            () -> new LightMachine(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()
                    .hardnessAndResistance(10).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.MOON_TEAR.get(), () -> ModSoundEvents.MOON_TEAR.get(),
                            () -> ModSoundEvents.MOON_TEAR.get(), () -> ModSoundEvents.MOON_TEAR.get(),
                            () -> ModSoundEvents.MOON_TEAR.get())).notSolid()));
    public static final RegistryObject<Block> AER_CRISTAL_ORE = registerBlock("aer_cristal_ore",
            () -> new ModOreBlockCristal(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(3).setLightLevel(value -> 6).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get()))));
    public static final RegistryObject<Block> FLAME_CRISTAL_ORE = registerBlock("flame_cristal_ore",
            () -> new ModOreBlockCristal(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(3).setLightLevel(value -> 6).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get()))));
    public static final RegistryObject<Block> TERRA_CRISTAL_ORE = registerBlock("terra_cristal_ore",
            () -> new ModOreBlockCristal(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(3).setLightLevel(value -> 6).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get()))));
    public static final RegistryObject<Block> AQUA_CRISTAL_ORE = registerBlock("aqua_cristal_ore",
            () -> new ModOreBlockCristal(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(3).setLightLevel(value -> 6).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get()))));
    public static final RegistryObject<Block> ETHER_CRISTAL_ORE = registerBlock("ether_cristal_ore",
            () -> new ModOreBlockCristal(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(3).setLightLevel(value -> 6).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get()))));
    public static final RegistryObject<Block> AER_CRISTAL = registerBlock("aer_cristal",
            () -> new CristalBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.4f).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get())).notSolid()));
    public static final RegistryObject<Block> FLAME_CRISTAL = registerBlock("flame_cristal",
            () -> new CristalBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.4f).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get())).notSolid()));
    public static final RegistryObject<Block> AQUA_CRISTAL = registerBlock("aqua_cristal",
            () -> new CristalBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.4f).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get())).notSolid()));
    public static final RegistryObject<Block> TERRA_CRISTAL = registerBlock("terra_cristal",
            () -> new CristalBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.4f).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get())).notSolid()));
    public static final RegistryObject<Block> ETHER_CRISTAL = registerBlock("ether_cristal",
            () -> new CristalBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.4f).sound(new ForgeSoundType(1f, 1f,
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get(), () -> ModSoundEvents.CRISTAL_BREAK.get(),
                            () -> ModSoundEvents.CRISTAL_BREAK.get())).notSolid()));
    public static final RegistryObject<Block> THISTLE = BLOCKS.register("thistle",
            () -> new FlowerBlock(Effects.ABSORPTION, 20, AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));

    public static final RegistryObject<Block> ELF_STONE = registerBlock("elf_stone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> MOSSY_ELF_STONE_BRICKS = registerBlock("mossy_elf_stone_bricks",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> CRACKED_ELF_STONE_BRICKS = registerBlock("cracked_elf_stone_bricks",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> LAVA_ROCK = registerBlock("lava_rock",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_ORE)));
    public static final RegistryObject<Block> CLAY_TILES = registerBlock("clay_tiles",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_BRICK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
    public static final RegistryObject<Block> SLAB_CLAY_TILES = registerBlock("slab_clay_tiles",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_BRICK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
    public static final RegistryObject<Block> SLAB_MOSSY_ELF_STONE_BRICKS = registerBlock("slab_mossy_elf_stone_bricks",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_BRICK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
    public static final RegistryObject<Block> STAIRS_CLAY_TILES = registerBlock("stairs_clay_tiles",
            () -> new StairsBlock(() -> CLAY_TILES.get().getDefaultState(),AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_BRICK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
    public static final RegistryObject<Block> SLAB_CRACKED_ELF_STONE_BRICKS = registerBlock("slab_cracked_elf_stone_bricks",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_BRICK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
    public static final RegistryObject<Block> STAIRS_CRACKED_ELF_STONE_BRICKS = registerBlock("stairs_cracked_elf_stone_bricks",
            () -> new StairsBlock(() -> CRACKED_ELF_STONE_BRICKS.get().getDefaultState(),AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_BRICK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
    public static final RegistryObject<Block> STAIRS_MOSSY_ELF_STONE_BRICKS = registerBlock("stairs_mossy_elf_stone_bricks",
            () -> new StairsBlock(() -> MOSSY_ELF_STONE_BRICKS.get().getDefaultState(),AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_BRICK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
    public static final RegistryObject<Block> LAVA_BRICK = registerBlock("lava_brick",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_ORE)));
    public static final RegistryObject<Block> PINFIRE_ORE = registerBlock("pinfire_ore",
            () -> new NetherrackBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(1).sound(SoundType.NETHER_ORE).setLightLevel(value -> 9)));
    public static final RegistryObject<Block> ELF_STONE_SLAB = registerBlock("elf_stone_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELF_STONE_STAIRS = registerBlock("elf_stone_stairs",
            () -> new StairsBlock(() -> ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELF_STONE_BRICKS = registerBlock("elf_stone_bricks",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELF_STONE_BRICKS_SLAB = registerBlock("elf_stone_bricks_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELF_STONE_BRICKS_STAIRS = registerBlock("elf_stone_bricks_stairs",
            () -> new StairsBlock(() -> ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_ELF_STONE_BRICKS = registerBlock("chiseled_elf_stone_bricks",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELF_GLASS = registerBlock("elf_glass",
            () -> new GlassBlock(AbstractBlock.Properties.from(Blocks.LIME_STAINED_GLASS)));
    public static final RegistryObject<Block> ELF_GLASS_PANE = registerBlock("elf_glass_pane",
            () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid()));
    public static final RegistryObject<Block> SOLAR_CONVERTER = registerBlock("solar_converter",
            () -> new SolarConverter(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(4).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ALCHEMY_TABLE = registerBlock("alchemy_table",
            () -> new AlchemyTable(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(4).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().notSolid().sound(SoundType.NETHER_ORE)));
    public static final RegistryObject<Block> THE_CALL_OF_THE_ANCESTORS = BLOCKS.register("the_call_of_the_ancestors",
            () -> new FlowerBlock(Effects.INVISIBILITY, 30, AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));

    public static final RegistryObject<Block> ANCIENT_ELF_BRICKS = registerBlock("ancient_elf_bricks",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_ANCIENT_ELF_BRICK = registerBlock("chiseled_ancient_elf_brick",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_ANCIENT_ELF_BRICKS = registerBlock("cracked_ancient_elf_bricks",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOSSY_ANCIENT_ELF_BRICKS = registerBlock("mossy_ancient_elf_bricks",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));


    public static final RegistryObject<Block> ANCIENT_ELF_STONE = registerBlock("ancient_elf_stone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_ANCIENT_ELF_STONE = registerBlock("cracked_ancient_elf_stone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOSSY_ANCIENT_ELF_STONE = registerBlock("mossy_ancient_elf_stone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));



    public static final RegistryObject<Block> ANCIENT_ELF_PILLAR = registerBlock("ancient_elf_pillar",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANCIENT_ELF_STONE_SLAB = registerBlock("ancient_elf_stone_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_ANCIENT_ELF_STONE_SLAB = registerBlock("cracked_ancient_elf_stone_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOSSY_ANCIENT_ELF_STONE_SLAB = registerBlock("mossy_ancient_elf_stone_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANCIENT_ELF_STONE_STAIRS = registerBlock("ancient_elf_stone_stairs",
            () -> new StairsBlock(() -> ANCIENT_ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_ANCIENT_ELF_STONE_STAIRS = registerBlock("cracked_ancient_elf_stone_stairs",
            () -> new StairsBlock(() -> CRACKED_ANCIENT_ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOSSY_ANCIENT_ELF_STONE_STAIRS = registerBlock("mossy_ancient_elf_stone_stairs",
            () -> new StairsBlock(() -> MOSSY_ANCIENT_ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANCIENT_ELF_BRICKS_SLAB = registerBlock("ancient_elf_bricks_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_ANCIENT_ELF_BRICKS_SLAB = registerBlock("cracked_ancient_elf_bricks_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOSSY_ANCIENT_ELF_BRICKS_SLAB = registerBlock("mossy_ancient_elf_bricks_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANCIENT_ELF_BRICKS_STAIRS = registerBlock("ancient_elf_bricks_stairs",
            () -> new StairsBlock(() -> ANCIENT_ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_ANCIENT_ELF_BRICKS_STAIRS = registerBlock("cracked_ancient_elf_bricks_stairs",
            () -> new StairsBlock(() -> ANCIENT_ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOSSY_ANCIENT_ELF_BRICKS_STAIRS = registerBlock("mossy_ancient_elf_bricks_stairs",
            () -> new StairsBlock(() -> ANCIENT_ELF_STONE.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANCIENT_ELF_STONE_FENCE = registerBlock("ancient_elf_stone_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANCIENT_ELF_BRICKS_FENCE = registerBlock("ancient_elf_bricks_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal",
            () -> new Pedestal(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> DRAWING_TABLE = registerBlock("drawing_table",
            () -> new DrawingTable(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()) {
            });
    public static final RegistryObject<Block> KNOBS_WORKBENCH = registerBlock("knobs_workbench",
            () -> new FaceHorizontal(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()) {
            });
    public static final RegistryObject<Block> CENTER_PEDESTAL = registerBlock("center_pedestal",
            () -> new Pedestal(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2).sound(SoundType.STONE).notSolid()));

    public static final RegistryObject<Block> CRUCIBLE = registerBlock("crucible",
            () -> new Crucible(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3).sound(SoundType.STONE).notSolid()));

    public static final RegistryObject<Block> THE_MAGIC_WEAVER = registerBlock("the_magic_weaver",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1).sound(SoundType.WOOD).notSolid()));


    public static final RegistryObject<Block> CRIMSON_SAPLING = BLOCKS.register("crimson_sapling",
            () -> new SaplingBlock(new CrimsonTree(), AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.RED)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> WARPED_SAPLING = BLOCKS.register("warped_sapling",
            () -> new SaplingBlock(new WarpedTree(), AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.RED)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> WARPED_WART = BLOCKS.register("warped_wart",
            () -> new WarpedWart(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.RED)
                    .doesNotBlockMovement().tickRandomly().sound(SoundType.NETHER_WART)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.THAUM_BLOCKS)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
