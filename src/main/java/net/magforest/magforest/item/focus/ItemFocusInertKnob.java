package net.magforest.magforest.item.focus;

import net.magforest.magforest.item.ItemFocus;
import net.minecraft.item.ItemStack;

public class ItemFocusInertKnob extends ItemFocus {
    public ItemFocusInertKnob(Properties properties) {
        super(properties);
    }

    public String getSortingHelper(ItemStack focusstack) {
        return "InertKnob"+super.getSortingHelper(focusstack);
    }
}

