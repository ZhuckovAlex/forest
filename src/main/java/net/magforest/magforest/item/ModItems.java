package net.magforest.magforest.item;

import net.magforest.magforest.block.ModBlocks;

import net.magforest.magforest.entity.ModEntityTypes;
import net.magforest.magforest.item.custom.*;
import net.magforest.magforest.item.focus.*;
import net.magforest.magforest.magforest;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, magforest.MOD_ID);

    public static final RegistryObject<Item> CIAN_SIGN = ITEMS.register("cian_sign",
            () -> new SignItem(new Item.Properties().maxStackSize(16).group(ModItemGroup.THAUM_BLOCKS),
                    ModBlocks.CIAN_SIGN.get(), ModBlocks.CIAN_WALL_SIGN.get()));
    public static final RegistryObject<Item> DARK_BIRCH_SIGN = ITEMS.register("dark_birch_sign",
            () -> new SignItem(new Item.Properties().maxStackSize(16).group(ModItemGroup.THAUM_BLOCKS),
                    ModBlocks.DARK_BIRCH_SIGN.get(), ModBlocks.DARK_BIRCH_WALL_SIGN.get()));

    public static final RegistryObject<Item> KARAMBOLA = ITEMS.register("karambola",
            () -> new BlockItem(ModBlocks.KARAMBOLA.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> SEEDS_OF_THE_CALL_OF_THE_ANCESTORS = ITEMS.register("seeds_of_the_call_of_the_ancestors",
            () -> new BlockItem(ModBlocks.SEEDS_OF_THE_CALL_OF_THE_ANCESTORS.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_ITEMS)));

    public static final RegistryObject<Item> CIAN_LEAVES = ITEMS.register("cian_leaves",
            () -> new BlockItem(ModBlocks.CIAN_LEAVES.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static ItemFocusAerKnob ITEM_AER_KNOB = new ItemFocusAerKnob(new Item.Properties().maxStackSize(1).group(ModItemGroup.SPELLS));
    public static final RegistryObject<Item> AER_KNOB = ITEMS.register("aer_knob",
            () -> ITEM_AER_KNOB);
    public static ItemFocusAquaKnob ITEM_AQUA_KNOB = new ItemFocusAquaKnob(new Item.Properties().maxStackSize(1).group(ModItemGroup.SPELLS));
    public static final RegistryObject<Item> AQUA_KNOB = ITEMS.register("aqua_knob",
            () -> ITEM_AQUA_KNOB);
    public static ItemFocusFlameKnob ITEM_FLAME_KNOB = new ItemFocusFlameKnob(new Item.Properties().maxStackSize(1).group(ModItemGroup.SPELLS));
    public static final RegistryObject<Item> FLAME_KNOB = ITEMS.register("flame_knob",
            () -> ITEM_FLAME_KNOB);
    public static ItemFocusInertKnob ITEM_INERT_KNOB = new ItemFocusInertKnob(new Item.Properties().maxStackSize(1).group(ModItemGroup.SPELLS));
    public static final RegistryObject<Item> INERT_KNOB = ITEMS.register("inert_knob",
            () -> ITEM_INERT_KNOB);
    public static ItemFocusTerraKnob ITEM_TERRA_KNOB = new ItemFocusTerraKnob(new Item.Properties().maxStackSize(1).group(ModItemGroup.SPELLS));
    public static final RegistryObject<Item> TERRA_KNOB = ITEMS.register("terra_knob",
            () -> ITEM_TERRA_KNOB);
    public static final RegistryObject<Item> JIRAZOL = ITEMS.register("jirazol",
            () -> new Item( new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> PRIMORDIAL_FIRE = ITEMS.register("primordial_fire",
            () -> new Item( new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> CIAN_SAPLING = ITEMS.register("cian_sapling",
            () -> new BlockItem(ModBlocks.CIAN_SAPLING.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> DARK_BIRCH_LEAVES = ITEMS.register("dark_birch_leaves",
            () -> new BlockItem(ModBlocks.DARK_BIRCH_LEAVES.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> DARK_BIRCH_SAPLING = ITEMS.register("dark_birch_sapling",
            () -> new BlockItem(ModBlocks.DARK_BIRCH_SAPLING.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> CRIMSON_SAPLING = ITEMS.register("crimson_sapling",
            () -> new BlockItem(ModBlocks.CRIMSON_SAPLING.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> WARPED_SAPLING = ITEMS.register("warped_sapling",
            () -> new BlockItem(ModBlocks.WARPED_SAPLING.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> WARPED_WART = ITEMS.register("warped_wart",
            () -> new BlockItem(ModBlocks.WARPED_WART.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> HYACINTH = ITEMS.register("hyacinth",
            () -> new BlockItem(ModBlocks.HYACINTH.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> BLACK_TOADSTOOL = ITEMS.register("black_toadstool",
            () -> new BlockItem(ModBlocks.BLACK_TOADSTOOL.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> ICY_YAWN = ITEMS.register("icy_yawn",
            () -> new BlockItem(ModBlocks.ICY_YAWN.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> SLEEPY_LEAF = ITEMS.register("sleepy_leaf",
            () -> new BlockItem(ModBlocks.SLEEPY_LEAF.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> SILVER_SAGE = ITEMS.register("silver_sage",
            () -> new BlockItem(ModBlocks.SILVER_SAGE.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> THE_CALL_OF_THE_ANCESTORS = ITEMS.register("the_call_of_the_ancestors",
            () -> new BlockItem(ModBlocks.THE_CALL_OF_THE_ANCESTORS.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> THISTLE = ITEMS.register("thistle",
            () -> new BlockItem(ModBlocks.THISTLE.get(), new Item.Properties()
                    .group(ModItemGroup.THAUM_BLOCKS)));
    public static final RegistryObject<Item> MOON_TEAR = ITEMS.register("moon_tear",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ELVEN_DUST = ITEMS.register("elven_dust",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> CHALK = ITEMS.register("chalk",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS).maxStackSize(1).maxDamage(120)));
    public static final RegistryObject<Item> INKWELL = ITEMS.register("inkwell",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS).maxStackSize(1).maxDamage(120)));
    public static final RegistryObject<Item> BLUE_CHALK = ITEMS.register("blue_chalk",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS).maxStackSize(1).maxDamage(120)));
    public static final RegistryObject<Item> MOON_TEAR_KNIFE = ITEMS.register("moon_tear_knife",
            () -> new SwordItem(ModItemTier.MOON_TEAR, 6,-2,  new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_PICKAXE = ITEMS.register("moon_tear_pickaxe",
            () -> new PickaxeItem(ModItemTier.MOON_TEAR, 4,-2,  new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_AXE = ITEMS.register("moon_tear_axe",
            () -> new AxeItem(ModItemTier.MOON_TEAR, 8,-3,  new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_SHOVEL = ITEMS.register("moon_tear_shovel",
            () -> new ShovelItem(ModItemTier.MOON_TEAR, 4.5f,-2,  new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_HOE = ITEMS.register("moon_tear_hoe",
            () -> new HoeItem(ModItemTier.MOON_TEAR, 0,-2,  new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_BOOTS = ITEMS.register("moon_tear_boots",
            () -> new ArmorItem(ModArmorMaterial.MOON_TEAR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_LEGGINGS = ITEMS.register("moon_tear_leggings",
            () -> new ArmorItem(ModArmorMaterial.MOON_TEAR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_CHESTPLATE = ITEMS.register("moon_tear_chestplate",
            () -> new ArmorItem(ModArmorMaterial.MOON_TEAR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_HELMET = ITEMS.register("moon_tear_helmet",
            () -> new ArmorItem(ModArmorMaterial.MOON_TEAR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_INGOT = ITEMS.register("amarost_ingot",
            () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_AXE = ITEMS.register("amarost_axe",
            () -> new AxeItem(ModItemTier.AMAROST,10,-2,new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_SWORD = ITEMS.register("amarost_sword",
            () -> new SwordItem(ModItemTier.AMAROST,8,-1,new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_PICKAXE = ITEMS.register("amarost_pickaxe",
            () -> new PickaxeItem(ModItemTier.AMAROST,6,-1,new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_SHOVEL = ITEMS.register("amarost_shovel",
            () -> new ShovelItem(ModItemTier.AMAROST,6.5f,-1,new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_HOE = ITEMS.register("amarost_hoe",
            () -> new HoeItem(ModItemTier.AMAROST,1,-1,new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_BOOTS = ITEMS.register("amarost_boots",
            () -> new ArmorItem(ModArmorMaterial.AMAROST, EquipmentSlotType.FEET,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_LEGGINGS = ITEMS.register("amarost_leggings",
            () -> new ArmorItem(ModArmorMaterial.AMAROST, EquipmentSlotType.LEGS,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_CHESTPLATE = ITEMS.register("amarost_chestplate",
            () -> new ArmorItem(ModArmorMaterial.AMAROST, EquipmentSlotType.CHEST,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AMAROST_HELMET = ITEMS.register("amarost_helmet",
            () -> new ArmorItem(ModArmorMaterial.AMAROST, EquipmentSlotType.HEAD,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_POWDER = ITEMS.register("moon_tear_powder",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AER_POWDER = ITEMS.register("aer_powder",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AQUA_POWDER = ITEMS.register("aqua_powder",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ETHER_POWDER = ITEMS.register("ether_powder",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> FLAME_POWDER = ITEMS.register("flame_powder",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> TERRA_POWDER = ITEMS.register("terra_powder",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AER_MIX = ITEMS.register("aer_mix",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AQUA_MIX = ITEMS.register("aqua_mix",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ETHER_MIX = ITEMS.register("ether_mix",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> FLAME_MIX = ITEMS.register("flame_mix",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> TERRA_MIX = ITEMS.register("terra_mix",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> DARK_BIRCH_CORE = ITEMS.register("dark_birch_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> OAK_CORE = ITEMS.register("oak_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> SPRUCE_CORE = ITEMS.register("spruce_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> DARK_OAK_CORE = ITEMS.register("dark_oak_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> BIRCH_CORE = ITEMS.register("birch_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> JUNGLE_CORE = ITEMS.register("jungle_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ACACIA_CORE = ITEMS.register("acacia_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> GOLDEN_CAP = ITEMS.register("golden_cap",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> IRON_CAP = ITEMS.register("iron_cap",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MOON_TEAR_CAP = ITEMS.register("moon_tear_cap",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));

    public static ItemWand ITEM_DARK_BIRCH_WAND_FRAMED_BY_GOLD = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> DARK_BIRCH_WAND_FRAMED_BY_GOLD = ITEMS.register("dark_birch_wand_framed_by_gold",
            () -> ITEM_DARK_BIRCH_WAND_FRAMED_BY_GOLD);
    public static ItemWand ITEM_DARK_BIRCH_WAND_FRAMED_BY_IRON = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> DARK_BIRCH_WAND_FRAMED_BY_IRON = ITEMS.register("dark_birch_wand_framed_by_iron",
            () -> ITEM_DARK_BIRCH_WAND_FRAMED_BY_IRON);
    public static ItemWand ITEM_DARK_BIRCH_WAND_FRAMED_BY_MOON_TEAR = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> DARK_BIRCH_WAND_FRAMED_BY_MOON_TEAR = ITEMS.register("dark_birch_wand_framed_by_moon_tear",
            () -> ITEM_DARK_BIRCH_WAND_FRAMED_BY_MOON_TEAR);

    public static ItemWand ITEM_OAK_WAND_FRAMED_BY_GOLD = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> OAK_WAND_FRAMED_BY_GOLD = ITEMS.register("oak_wand_framed_by_gold",
            () -> ITEM_OAK_WAND_FRAMED_BY_GOLD);
    public static ItemWand ITEM_OAK_WAND_FRAMED_BY_IRON = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> OAK_WAND_FRAMED_BY_IRON = ITEMS.register("oak_wand_framed_by_iron",
            () -> ITEM_OAK_WAND_FRAMED_BY_IRON);
    public static ItemWand ITEM_OAK_WAND_FRAMED_BY_MOON_TEAR = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> OAK_WAND_FRAMED_BY_MOON_TEAR = ITEMS.register("oak_wand_framed_by_moon_tear",
            () -> ITEM_OAK_WAND_FRAMED_BY_MOON_TEAR);

    public static ItemWand ITEM_SPRUCE_WAND_FRAMED_BY_GOLD = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> SPRUCE_WAND_FRAMED_BY_GOLD = ITEMS.register("spruce_wand_framed_by_gold",
            () -> ITEM_SPRUCE_WAND_FRAMED_BY_GOLD);
    public static ItemWand ITEM_SPRUCE_WAND_FRAMED_BY_IRON = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> SPRUCE_WAND_FRAMED_BY_IRON = ITEMS.register("spruce_wand_framed_by_iron",
            () -> ITEM_SPRUCE_WAND_FRAMED_BY_IRON);
    public static ItemWand ITEM_SPRUCE_WAND_FRAMED_BY_MOON_TEAR = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> SPRUCE_WAND_FRAMED_BY_MOON_TEAR = ITEMS.register("spruce_wand_framed_by_moon_tear",
            () -> ITEM_SPRUCE_WAND_FRAMED_BY_MOON_TEAR);

    public static ItemWand ITEM_DARK_OAK_WAND_FRAMED_BY_GOLD = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> DARK_OAK_WAND_FRAMED_BY_GOLD = ITEMS.register("dark_oak_wand_framed_by_gold",
            () -> ITEM_DARK_OAK_WAND_FRAMED_BY_GOLD);
    public static ItemWand ITEM_DARK_OAK_WAND_FRAMED_BY_IRON = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> DARK_OAK_WAND_FRAMED_BY_IRON = ITEMS.register("dark_oak_wand_framed_by_iron",
            () -> ITEM_DARK_OAK_WAND_FRAMED_BY_IRON);
    public static ItemWand ITEM_DARK_OAK_WAND_FRAMED_BY_MOON_TEAR = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> DARK_OAK_WAND_FRAMED_BY_MOON_TEAR = ITEMS.register("dark_oak_wand_framed_by_moon_tear",
            () -> ITEM_DARK_OAK_WAND_FRAMED_BY_MOON_TEAR);

    public static ItemWand ITEM_BIRCH_WAND_FRAMED_BY_GOLD = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> BIRCH_WAND_FRAMED_BY_GOLD = ITEMS.register("birch_wand_framed_by_gold",
            () -> ITEM_BIRCH_WAND_FRAMED_BY_GOLD);
    public static ItemWand ITEM_BIRCH_WAND_FRAMED_BY_IRON = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> BIRCH_WAND_FRAMED_BY_IRON = ITEMS.register("birch_wand_framed_by_iron",
            () -> ITEM_BIRCH_WAND_FRAMED_BY_IRON);
    public static ItemWand ITEM_BIRCH_WAND_FRAMED_BY_MOON_TEAR = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> BIRCH_WAND_FRAMED_BY_MOON_TEAR = ITEMS.register("birch_wand_framed_by_moon_tear",
            () -> ITEM_BIRCH_WAND_FRAMED_BY_MOON_TEAR);

    public static ItemWand ITEM_ACACIA_WAND_FRAMED_BY_GOLD = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> ACACIA_WAND_FRAMED_BY_GOLD = ITEMS.register("acacia_wand_framed_by_gold",
            () -> ITEM_ACACIA_WAND_FRAMED_BY_GOLD);
    public static ItemWand ITEM_ACACIA_WAND_FRAMED_BY_IRON = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> ACACIA_WAND_FRAMED_BY_IRON = ITEMS.register("acacia_wand_framed_by_iron",
            () -> ITEM_ACACIA_WAND_FRAMED_BY_IRON);
    public static ItemWand ITEM_ACACIA_WAND_FRAMED_BY_MOON_TEAR = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> ACACIA_WAND_FRAMED_BY_MOON_TEAR = ITEMS.register("acacia_wand_framed_by_moon_tear",
            () -> ITEM_ACACIA_WAND_FRAMED_BY_MOON_TEAR);

    public static ItemWand ITEM_JUNGLE_WAND_FRAMED_BY_GOLD = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> JUNGLE_WAND_FRAMED_BY_GOLD = ITEMS.register("jungle_wand_framed_by_gold",
            () -> ITEM_JUNGLE_WAND_FRAMED_BY_GOLD);
    public static ItemWand ITEM_JUNGLE_WAND_FRAMED_BY_IRON = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> JUNGLE_WAND_FRAMED_BY_IRON = ITEMS.register("jungle_wand_framed_by_iron",
            () -> ITEM_JUNGLE_WAND_FRAMED_BY_IRON);
    public static ItemWand ITEM_JUNGLE_WAND_FRAMED_BY_MOON_TEAR = new ItemWand(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS));
    public static final RegistryObject<Item> JUNGLE_WAND_FRAMED_BY_MOON_TEAR = ITEMS.register("jungle_wand_framed_by_moon_tear",
            () -> ITEM_JUNGLE_WAND_FRAMED_BY_MOON_TEAR);

    public static final RegistryObject<Item> PESTLE = ITEMS.register("pestle",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle",
            () -> new DamageItem(new Item.Properties().maxStackSize(1).maxDamage(64).group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MAGICA = ITEMS.register("magica",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> CIAN_BOAT = ITEMS.register("cian_boat",
            () -> new ModCianBoatItem(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS),"cian"));
    public static final RegistryObject<Item> DARK_BIRCH_BOAT = ITEMS.register("dark_birch_boat",
            () -> new ModDarkBirchBoatItem(new Item.Properties().maxStackSize(1).group(ModItemGroup.THAUM_ITEMS),"dark_birch"));
    public static final RegistryObject<Item> FIRE_ESSENCE = ITEMS.register("fire_essence",
            () -> new ModItemEnchant(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> WATER_ESSENCE = ITEMS.register("water_essence",
            () -> new ModItemEnchant(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> TERRA_ESSENCE = ITEMS.register("terra_essence",
            () -> new ModItemEnchant(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> AER_ESSENCE = ITEMS.register("aer_essence",
            () -> new ModItemEnchant(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ETHER_ESSENCE = ITEMS.register("ether_essence",
            () -> new ModItemEnchant(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> FOCUSING_LENS = ITEMS.register("focusing_lens",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> SCROLL = ITEMS.register("scroll",
            () -> new Item(new Item.Properties().group(ModItemGroup.SPELLS)));
    public static final RegistryObject<Item> FLAME_SCROLL = ITEMS.register("flame_scroll",
            () -> new Item(new Item.Properties().group(ModItemGroup.SPELLS)));
    public static final RegistryObject<Item> AQUA_SCROLL = ITEMS.register("aqua_scroll",
            () -> new Item(new Item.Properties().group(ModItemGroup.SPELLS)));
    public static final RegistryObject<Item> AER_SCROLL = ITEMS.register("aer_scroll",
            () -> new Item(new Item.Properties().group(ModItemGroup.SPELLS)));
    public static final RegistryObject<Item> TERRA_SCROLL = ITEMS.register("terra_scroll",
            () -> new Item(new Item.Properties().group(ModItemGroup.SPELLS)));
    public static final RegistryObject<Item> MOON_MOTH_SPAWN_EGG = ITEMS.register("moon_moth_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.MOON_MOTH,0x30d5c8,0x42aaff,
                    new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));

    public static final RegistryObject<Item> GOLDEN_LEAF = ITEMS.register("golden_leaf",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ACORN = ITEMS.register("acorn",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> POTION_STONE_SKIN = ITEMS.register("potion_stone_skin",
            () -> new PotionStoneSkin(new Item.Properties().food(new Food.Builder().hunger(0).saturation(0).setAlwaysEdible().build()).group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> POTION_CHEERFULNESS = ITEMS.register("potion_cheerfulness",
            () -> new PotionCheerfulness(new Item.Properties().food(new Food.Builder().hunger(0).saturation(0).setAlwaysEdible().build()).group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> POTION_CAT_VISION = ITEMS.register("potion_cat_vision",
            () -> new PotionCatVision(new Item.Properties().food(new Food.Builder().hunger(0).saturation(0).setAlwaysEdible().build()).group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> POTION_OF_IMPETUOSITY = ITEMS.register("potion_of_impetuosity",
            () -> new PotionOfImpetuosity(new Item.Properties().food(new Food.Builder().hunger(0).saturation(0).setAlwaysEdible().build()).group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> THE_SMELL_OF_LOVE = ITEMS.register("the_smell_of_love",
            () -> new PotionLove(new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> STAR_MOSS = ITEMS.register("star_moss",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ALCHEMICAL_INFUSION = ITEMS.register("alchemical_infusion",
            () -> new Item(new Item.Properties().maxStackSize(1).maxDamage(80).group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> POTION_HEALING = ITEMS.register("potion_healing",
            () -> new PotionHealing(new Item.Properties().food(new Food.Builder().hunger(0).saturation(0).fastToEat().setAlwaysEdible().build()).group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> ENTROPY_POTION = ITEMS.register("entropy_potion",
            () -> new Item(new Item.Properties().maxStackSize(1).maxDamage(25).group(ModItemGroup.POTIONS)));

    public static final RegistryObject<Item> CRYSTAL_PHIAL = ITEMS.register("crystal_phial",
            () -> new Item(new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> MAGIC_CLOTH = ITEMS.register("magic_cloth",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> STONE_OF_TRANSFORMATION = ITEMS.register("stone_of_transformation",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ALCHEMICAL_SILVER = ITEMS.register("alchemical_silver",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> LIQUID_SILVER = ITEMS.register("liquid_silver",
            () -> new Item(new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));

    public static final RegistryObject<Item> WIND_REFLECTION = ITEMS.register("wind_reflection",
            () -> new Item(new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> TURF_EXTRACT = ITEMS.register("turf_extract",
        () -> new Item(new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> SPIRIT_OF_THE_SEA = ITEMS.register("spirit_of_the_sea",
            () -> new Item(new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> FIREWATER = ITEMS.register("firewater",
            () -> new Item(new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> CRYSTAL_SHARD = ITEMS.register("crystal_shard",
            () -> new Item( new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> WING_OF_THE_MOON_MOTH = ITEMS.register("wing_of_the_moon_moth",
            () -> new Item( new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> MIRACULUM_FLAMAS = ITEMS.register("miraculum_flammas",
            () -> new Item( new Item.Properties().group(ModItemGroup.THAUM_ITEMS)));
    public static final RegistryObject<Item> ANCIENT_POT = ITEMS.register("ancient_pot",
            () -> new Item( new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> FIRE_POT = ITEMS.register("fire_pot",
            () -> new Item( new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> POT_OF_POISON = ITEMS.register("pot_of_poison",
            () -> new Item( new Item.Properties().group(ModItemGroup.POTIONS)));
    public static final RegistryObject<Item> QUESTIONABLE_POTION = ITEMS.register("questionable_potion",
            () -> new PotionQuestionable( new Item.Properties().food(new Food.Builder().hunger(0).saturation(0).setAlwaysEdible().build()).group(ModItemGroup.POTIONS)));






    public static final RegistryObject<Item> KARAMBOLA_FRUIT = ITEMS.register("karambola_fruit",
            () -> new Item (new Item.Properties().food(new Food.Builder().hunger(6).saturation(0.4f).build())
                    .group(ModItemGroup.THAUM_ITEMS)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
