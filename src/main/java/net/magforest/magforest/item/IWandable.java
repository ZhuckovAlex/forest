package net.magforest.magforest.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IWandable {
    int onWandRightClick(World var1, ItemStack var2, PlayerEntity var3, int var4, int var5, int var6, int var7, int var8);

    ItemStack onWandRightClick(World var1, ItemStack var2, PlayerEntity var3);

    void onUsingWandTick(ItemStack var1, PlayerEntity var2, int var3);

    void onWandStoppedUsing(ItemStack var1, World var2, PlayerEntity var3, int var4);
}
