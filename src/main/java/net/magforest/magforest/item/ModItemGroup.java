package net.magforest.magforest.item;

import net.magforest.magforest.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup
{

    public static final ItemGroup THAUM_BLOCKS = new ItemGroup("thaum_blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.CIAN_LOG.get());
        }
    };
    public static final ItemGroup THAUM_ITEMS = new ItemGroup("thaum_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.KARAMBOLA.get());
        }
    };


}
