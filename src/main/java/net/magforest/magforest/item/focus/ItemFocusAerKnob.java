package net.magforest.magforest.item.focus;

import net.magforest.magforest.item.ItemFocus;
import net.minecraft.item.ItemStack;

public class ItemFocusAerKnob extends ItemFocus {
    public ItemFocusAerKnob(Properties properties) {
        super(properties);
    }

    public String getSortingHelper(ItemStack focusstack) {
        return "AerKnob"+super.getSortingHelper(focusstack);
    }
}

