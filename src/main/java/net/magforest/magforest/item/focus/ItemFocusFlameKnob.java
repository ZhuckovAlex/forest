package net.magforest.magforest.item.focus;

import net.magforest.magforest.item.ItemFocus;
import net.minecraft.item.ItemStack;

public class ItemFocusFlameKnob extends ItemFocus {
    public ItemFocusFlameKnob(Properties properties) {
        super(properties);
    }

    public String getSortingHelper(ItemStack focusstack) {
        return "FlameKnob"+super.getSortingHelper(focusstack);
    }
}

