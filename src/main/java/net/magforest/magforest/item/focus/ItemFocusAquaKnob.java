package net.magforest.magforest.item.focus;

import net.magforest.magforest.entity.ModEntityTypes;
import net.magforest.magforest.entity.projectile.EntityFrostShard;
import net.magforest.magforest.item.ItemFocus;
import net.magforest.magforest.item.ItemWand;
import net.magforest.magforest.item.aspect.Aspect;
import net.magforest.magforest.item.aspect.AspectList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ItemFocusAquaKnob extends ItemFocus {
    private static final AspectList costBase = (new AspectList()).add(Aspect.WATER, 5);

    public ItemFocusAquaKnob(Properties properties) {
        super(properties);
    }
    public AspectList getVisCost(ItemStack itemstack) {
        return costBase;
    }

    public ItemStack onFocusRightClick(ItemStack itemstack, World world, PlayerEntity p, BlockRayTraceResult movingobjectposition) {
        ItemWand wand = (ItemWand)itemstack.getItem();
        if(!world.isRemote && wand.consumeAllVis(itemstack, p, this.getVisCost(itemstack), true, false)) {
            //int frosty = this.getUpgradeLevel(wand.getFocusItem(itemstack), FocusUpgradeType.alchemistsfrost);
            EntityFrostShard shard = null;

                shard = EntityFrostShard.createFrost(ModEntityTypes.FROST_SHARD.get(),p,world);
                //shard.setDamage((float)(3.0D + (double)wand.getFocusPotency(itemstack) * 1.5D));
                //shard.setFrosty(frosty);
                shard.setDirectionAndMovement(p, p.rotationPitch, p.rotationYaw, 0.0F, 1.0F, 1.0F);
                world.addEntity(shard);


            //world.playSoundAtEntity(shard, "thaumcraft:ice", 0.4F, 1.0F + world.rand.nextFloat() * 0.1F);
        }

        p.swingArm(Hand.MAIN_HAND);
        return itemstack;
    }
    public String getSortingHelper(ItemStack focusstack) {
        return "AquaKnob"+super.getSortingHelper(focusstack);
    }
}

