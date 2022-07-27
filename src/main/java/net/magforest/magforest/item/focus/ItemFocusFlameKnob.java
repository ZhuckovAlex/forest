package net.magforest.magforest.item.focus;

import net.magforest.magforest.entity.ModEntityTypes;
import net.magforest.magforest.entity.projectile.EntityEmber;
import net.magforest.magforest.item.ItemFocus;
import net.magforest.magforest.item.ItemWand;
import net.magforest.magforest.item.aspect.Aspect;
import net.magforest.magforest.item.aspect.AspectList;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ItemFocusFlameKnob extends ItemFocus {
    private static final AspectList costBase = (new AspectList()).add(Aspect.FIRE, 75);
    long soundDelay = 0L;
    public ItemFocusFlameKnob(Properties properties) {
        super(properties);
    }
    public AspectList getVisCost(ItemStack itemstack) {
        return costBase;
    }
    public void onUsingFocusTick(ItemStack itemstack, PlayerEntity p, World world) {
        ItemWand wand = (ItemWand)itemstack.getItem();
        if(!wand.consumeAllVis(itemstack, p, this.getVisCost(itemstack), false, false)) {
            p.resetActiveHand();
        } else {
            byte range = 17;
            p.getLook((float)range);
            if(!world.isRemote && this.soundDelay < System.currentTimeMillis()) {
                this.soundDelay = System.currentTimeMillis() + 500L;
            }

            if(!world.isRemote && wand.consumeAllVis(itemstack, p, this.getVisCost(itemstack), true, false)) {
                float scatter = 15.0F;

                for(int a = 0; a < 2 ; ++a) {
                    EntityEmber orb = EntityEmber.createEmber(ModEntityTypes.EMBER.get(), p,world );
                    //orb.shoot(orb.getMotion().x,orb.getMotion().y,orb.getMotion().z,orb.func_70182_d(),15F);
                    orb.setPosition(orb.getPosX()+orb.getMotion().x,orb.getPosY()+orb.getMotion().y,orb.getPosZ()+orb.getMotion().z);



                    orb.setDirectionAndMovement(p, p.rotationPitch, p.rotationYaw, 0.0F, 1.0F, 1.0F);

                    world.addEntity(orb);
                    //world.sendPacketToServer(orb.createSpawnPacket());
                }
            }

        }
    }

    public String getSortingHelper(ItemStack focusstack) {
        return "FlameKnob"+super.getSortingHelper(focusstack);
    }


}

