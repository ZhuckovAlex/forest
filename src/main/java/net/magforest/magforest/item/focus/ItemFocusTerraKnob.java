package net.magforest.magforest.item.focus;

import net.magforest.magforest.item.ItemFocus;
import net.minecraft.item.ItemStack;

public class ItemFocusTerraKnob extends ItemFocus {
    public ItemFocusTerraKnob(Properties properties) {
        super(properties);
    }

    public String getSortingHelper(ItemStack focusstack) {
        return "TerraKnob"+super.getSortingHelper(focusstack);
    }
}

