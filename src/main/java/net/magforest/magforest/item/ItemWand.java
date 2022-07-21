package net.magforest.magforest.item;

import net.magforest.magforest.item.aspect.Aspect;
import net.magforest.magforest.item.aspect.AspectList;
import net.magforest.magforest.magforest;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Iterator;

public class ItemWand extends Item {

    public ItemWand(Properties properties) {
        super(properties);
    }

    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.hasTag()) {
            stack.setTag(new CompoundNBT());
            stack.getTag().putInt("sceptre", 1);
        }
       }
    public boolean isSceptre(ItemStack stack) {
        if ((stack.hasTag()) && (stack.getTag().getInt("sceptre") != 0)) {
            return true;
        }
        return false;
    }

    public void setFocus(ItemStack stack, ItemStack focus) {
        if(focus == null) {
            stack.removeChildTag("focus");
        } else {
            stack.setTagInfo("focus", focus.write(new CompoundNBT()));
        }

    }
    public int addVis(ItemStack is, Aspect aspect, int amount, boolean doit) {
        if(!aspect.isPrimal()) {
            return 0;
        } else {
            int storeAmount = this.getVis(is, aspect) + amount * 100;
            int leftover = Math.max(storeAmount - this.getMaxVis(is), 0);
            if(doit) {
                this.storeVis(is, aspect, Math.min(storeAmount, this.getMaxVis(is)));
            }

            return leftover / 100;
        }
    }
    public void storeVis(ItemStack is, Aspect aspect, int amount) {
        if (!is.hasTag())
            is.setTag(new CompoundNBT());
        is.getTag().putInt(aspect.getTag(), amount);
    }
    public int getMaxVis(ItemStack stack) {
        return 25 * (this.isSceptre(stack)?150:100);
    }
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
            if(this == ModItems.ITEM_DARK_BIRCH_WAND_FRAMED_BY_GOLD){
                ItemStack w1 = new ItemStack(this, 1);
                Iterator i$ = Aspect.getPrimalAspects().iterator();
                while(i$.hasNext()) {
                    Aspect aspect = (Aspect)i$.next();
                    ((ItemWand)w1.getItem()).addVis(w1, aspect, 100*100, true);
                }
                items.add(w1);
            }else if(this == ModItems.ITEM_DARK_BIRCH_WAND_FRAMED_BY_IRON){
                ItemStack w1 = new ItemStack(this, 1);
                Iterator i$ = Aspect.getPrimalAspects().iterator();
                while(i$.hasNext()) {
                    Aspect aspect = (Aspect)i$.next();
                    ((ItemWand)w1.getItem()).addVis(w1, aspect, 25*100, true);
                }
                items.add(w1);
            }else if(this == ModItems.ITEM_DARK_BIRCH_WAND_FRAMED_BY_MOON_TEAR){
                ItemStack w1 = new ItemStack(this, 1);
                Iterator i$ = Aspect.getPrimalAspects().iterator();
                while(i$.hasNext()) {
                    Aspect aspect = (Aspect)i$.next();
                    ((ItemWand)w1.getItem()).addVis(w1, aspect, 500*100, true);
                }
                items.add(w1);
            }
        }

    }
    public ItemFocus getFocus(ItemStack stack) {
        if(stack.hasTag() && stack.getTag().contains("focus")) {
            CompoundNBT nbt = stack.getChildTag("focus");
            return ItemStack.read(nbt).getItem() instanceof AirItem?null: (ItemFocus)ItemStack.read(nbt).getItem();
        } else {
            return null;
        }
    }

    public ItemStack getFocusItem(ItemStack stack) {
        if(stack.hasTag() && stack.getTag().contains("focus")) {
            CompoundNBT nbt = stack.getChildTag("focus");
            return ItemStack.read(nbt);
        } else {
            return null;
        }
    }
    public int getVis(ItemStack is, Aspect aspect) {
        int out = 0;
        if(is != null && aspect != null && is.hasTag() && is.getTag().contains(aspect.getTag())) {
            out = is.getTag().getInt(aspect.getTag());
        }

        return out;
    }
    public boolean consumeAllVis(ItemStack is, PlayerEntity player, AspectList aspects, boolean doit, boolean crafting) {
        if(aspects != null && aspects.size() != 0) {
            AspectList nl = new AspectList();
            Aspect[] arr$ = aspects.getAspects();
            int len$ = arr$.length;

            int i$;
            Aspect aspect;
            for(i$ = 0; i$ < len$; ++i$) {
                aspect = arr$[i$];
                int cost = aspects.getAmount(aspect);
                cost = (int)((float)cost * this.getConsumptionModifier(is, player, aspect, crafting));
                nl.add(aspect, cost);
            }

            arr$ = nl.getAspects();
            len$ = arr$.length;

            for(i$ = 0; i$ < len$; ++i$) {
                aspect = arr$[i$];
                if(this.getVis(is, aspect) < nl.getAmount(aspect)) {
                    return false;
                }
            }

            if(doit && !player.world.isRemote) {
                arr$ = nl.getAspects();
                len$ = arr$.length;

                for(i$ = 0; i$ < len$; ++i$) {
                    aspect = arr$[i$];
                    this.storeVis(is, aspect, this.getVis(is, aspect) - nl.getAmount(aspect));
                }
            }

            return true;
        } else {
            return false;
        }
    }



    public int getFocusFrugal(ItemStack itemstack) {
        return this.getFocus(itemstack) == null?0:this.getFocus(itemstack).getUpgradeLevel(this.getFocusItem(itemstack), FocusUpgradeType.frugal);
    }
    public float getConsumptionModifier(ItemStack is, PlayerEntity player, Aspect aspect, boolean crafting) {
        float consumptionModifier = 1.0F;

        if(player != null) {
            consumptionModifier -= getTotalVisDiscount(player, aspect);
        }

        if(this.getFocus(is) != null && !crafting) {
            consumptionModifier -= (float)this.getFocusFrugal(is) / 10.0F;
        }

        if(this.isSceptre(is)) {
            consumptionModifier -= 0.1F;
        }

        return Math.max(consumptionModifier, 0.1F);
    }

    public static float getTotalVisDiscount(PlayerEntity player, Aspect aspect) {
        int total = 0;
        if(player == null) {
            return 0.0F;
        } else {
            int level1;
            if(player.isPotionActive(Effect.get(18)) || player.isPotionActive(Effect.get(18))) {
                level1 = 0;
                int level2 = 0;
                if(player.isPotionActive(Effect.get(18))) {
                    level1 = player.getActivePotionEffect(Effect.get(18)).getAmplifier();
                }

                if(player.isPotionActive(Effect.get(18))) {
                    level2 = player.getActivePotionEffect(Effect.get(18)).getAmplifier();
                }

                total -= (Math.max(level1, level2) + 1) * 10;
            }

            return (float)total / 100.0F;
        }
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(Hand.MAIN_HAND);
        BlockRayTraceResult movingobjectposition = this.rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        if(movingobjectposition != null && movingobjectposition.getType() == RayTraceResult.Type.BLOCK) {
            BlockPos focus = movingobjectposition.getPos();
            //int ret = movingobjectposition.blockY;
            //int k = movingobjectposition.blockZ;
            Block bi = worldIn.getBlockState(focus).getBlock();
            //bi.getBlockMetadata(focus, ret, k);
            if(bi instanceof IWandable) {
                ItemStack tile = ((IWandable)bi).onWandRightClick(worldIn, itemstack, playerIn);
                if(tile != null) {
                    return new ActionResult(ActionResultType.SUCCESS,tile);
                }
            }

            TileEntity tile1 = worldIn.getTileEntity(focus);
            if(tile1 != null && tile1 instanceof IWandable) {//!!!IWandable
                ItemStack is = ((IWandable)tile1).onWandRightClick(worldIn, itemstack, playerIn);
                if(is != null) {
                    return new ActionResult(ActionResultType.SUCCESS,is);
                }
            }
        }

        ItemFocus focus1 = this.getFocus(itemstack);
        if(focus1 != null/* && !WandManager.isOnCooldown(player)*/) {
            //WandManager.setCooldown(player, focus1.getActivationCooldown(this.getFocusItem(itemstack)));
            ItemStack ret1 = focus1.onFocusRightClick(itemstack, worldIn, playerIn, movingobjectposition);
            if(ret1 != null) {
                return new ActionResult(ActionResultType.SUCCESS,ret1);
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT ;
    }
    public SoundEvent getEatSound() {
        return null;
    }

    public int getUseDuration(ItemStack stack) {
            return 9999999;

    }
    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        if (livingEntityIn != null && livingEntityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity)livingEntityIn;

            ItemFocus focus = this.getFocus(stack);
            if(focus != null /*&& !WandManager.isOnCooldown(player)*/) {
                /*WandManager.setCooldown(player, focus.getActivationCooldown(this.getFocusItem(stack)));*/
                focus.onUsingFocusTick(stack, player, worldIn);
            }

        }
    }



}
