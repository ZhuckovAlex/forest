package net.magforest.magforest.item.focus;

import net.magforest.magforest.item.ItemFocus;
import net.minecraft.item.ItemStack;

public class ItemFocusAquaKnob extends ItemFocus {
    public ItemFocusAquaKnob(Properties properties) {
        super(properties);
    }

    public String getSortingHelper(ItemStack focusstack) {
        return "AquaKnob"+super.getSortingHelper(focusstack);
    }
}

