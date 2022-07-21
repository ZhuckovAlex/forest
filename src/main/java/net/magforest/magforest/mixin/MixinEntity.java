package net.magforest.magforest.mixin;

import net.magforest.magforest.item.ItemWand;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.item.focus.ItemFocusAerKnob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;

@Mixin(Entity.class)
public abstract class MixinEntity {


    @Shadow public abstract EntityType<?> getType();

    @Shadow public World world;

    @Shadow public abstract int getEntityId();

    @Shadow public abstract EntityDataManager getDataManager();

    @Shadow public abstract float getEyeHeight();

    @Shadow public abstract void setAir(int air);

    @Shadow public abstract int getAir();


    @Inject(method = "getMaxAir", at = @At("HEAD"), cancellable = true)
    public void onGetMaxAir(CallbackInfoReturnable<Integer> cir) {
        int value = 300;
        if(this.getEyeHeight() != 0){
        if(this.getType() == EntityType.PLAYER && this.world.getEntityByID(this.getEntityId()) != null){
            PlayerEntity player = (PlayerEntity)this.world.getEntityByID(this.getEntityId());
            for (Iterator<ItemStack> it = player.inventory.mainInventory.iterator(); it.hasNext(); ) {
                ItemStack stack = it.next();
                if(stack.getItem() instanceof ItemWand){
                    ItemWand wand = (ItemWand)stack.getItem();
                    if(wand.getFocus(stack) == ModItems.ITEM_AER_KNOB)
                    {
                        value = 420;
                        break;
                    }
                }

            }
        }
        if(getAir() > value)
            setAir(value);
        }
        cir.setReturnValue(value);
    }
}
