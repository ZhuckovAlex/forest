package net.magforest.magforest.item;

import net.magforest.magforest.item.aspect.AspectList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ItemFocus extends Item {

    public ItemFocus(Properties properties) {
        super(properties);
    }

    public String getSortingHelper(ItemStack focusstack) {
        String out = "";
        short[] arr$ = this.getAppliedUpgrades(focusstack);
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            short id = arr$[i$];
            out = out + id;
        }

        return out;
    }

    public int getUpgradeLevel(ItemStack focusstack, FocusUpgradeType focusUpgradetype) {
        short[] list = this.getAppliedUpgrades(focusstack);
        int level = 0;
        short[] arr$ = list;
        int len$ = list.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            short id = arr$[i$];
            if(id == focusUpgradetype.id) {
                ++level;
            }
        }

        return level;
    }
    public ItemStack onFocusRightClick(ItemStack itemstack, World world, PlayerEntity p, BlockRayTraceResult movingobjectposition) {
        p.setActiveHand(Hand.MAIN_HAND);

        return itemstack;
    }

    public void onPlayerStoppedUsingFocus(ItemStack wandstack, World world, PlayerEntity player, int count) {}
    public void onUsingFocusTick(ItemStack wandstack, PlayerEntity player, World world) {}
    public AspectList getVisCost(ItemStack focusstack) {
        return null;
    }
    public short[] getAppliedUpgrades(ItemStack focusstack) {
        short[] l = new short[]{(short)-1, (short)-1, (short)-1, (short)-1, (short)-1};
        ListNBT nbttaglist = this.getFocusUpgradeTagList(focusstack);
        if(nbttaglist == null) {
            return l;
        } else {
            for(int j = 0; j < nbttaglist.size() && j < 5; ++j) {
                l[j] = nbttaglist.getCompound(j).getShort("id");
            }

            return l;
        }
    }
    private ListNBT getFocusUpgradeTagList(ItemStack focusstack) {
        return (!focusstack.hasTag())?null:focusstack.getTag().getList("upgrade", 10);
    }
}