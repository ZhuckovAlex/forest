package net.magforest.magforest.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;

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