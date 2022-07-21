package net.magforest.magforest.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AirItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemWand extends Item {
    public ItemWand(Properties properties) {
        super(properties);
    }

    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.hasTag()) {
            stack.setTag(new CompoundNBT());
            stack.getTag().putInt("sceptre", 1);
        }
       }
    public boolean isSceptre(ItemStack stack) {
        if ((stack.hasTag()) && (stack.getTag().getInt("sceptre") != 0)) {
            return true;
        }
        return false;
    }

    public void setFocus(ItemStack stack, ItemStack focus) {
        if(focus == null) {
            stack.removeChildTag("focus");
        } else {
            stack.setTagInfo("focus", focus.write(new CompoundNBT()));
        }

    }

    public ItemFocus getFocus(ItemStack stack) {
        if(stack.hasTag() && stack.getTag().contains("focus")) {
            CompoundNBT nbt = stack.getChildTag("focus");
            return ItemStack.read(nbt).getItem() instanceof AirItem?null: (ItemFocus)ItemStack.read(nbt).getItem();
        } else {
            return null;
        }
    }

    public ItemStack getFocusItem(ItemStack stack) {
        if(stack.hasTag() && stack.getTag().contains("focus")) {
            CompoundNBT nbt = stack.getChildTag("focus");
            return ItemStack.read(nbt);
        } else {
            return null;
        }
    }
}
