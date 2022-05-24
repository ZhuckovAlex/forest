package net.magforest.magforest.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModItemEnchant extends Item {
    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
        return true;
    }
    public ModItemEnchant(Properties properties) {
        super(properties);
    }
}
