package net.magforest.magforest.item.focus;

import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.entity.ModEntityTypes;
import net.magforest.magforest.entity.projectile.EntityAir;
import net.magforest.magforest.entity.projectile.EntityEmber;
import net.magforest.magforest.item.ItemFocus;
import net.magforest.magforest.item.ItemWand;
import net.magforest.magforest.item.aspect.Aspect;
import net.magforest.magforest.item.aspect.AspectList;
import net.magforest.magforest.magforest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.world.BlockEvent;

import java.util.HashMap;

public class ItemFocusTerraKnob extends ItemFocus {
    private static final AspectList cost = (new AspectList()).add(Aspect.FIRE, 5);
    static HashMap<String, Long> soundDelay = new HashMap();
    static HashMap<String, Object> beam = new HashMap();
    static HashMap<String, Float> breakcount = new HashMap();
    static HashMap<String, Integer> lastX = new HashMap();
    static HashMap<String, Integer> lastY = new HashMap();
    static HashMap<String, Integer> lastZ = new HashMap();
    public ItemFocusTerraKnob(Properties properties) {
        super(properties);
    }
    public AspectList getVisCost(ItemStack itemstack) {
        return cost;
    }
    public void onUsingFocusTick(ItemStack itemstack, PlayerEntity p, World world) {
        ItemWand wand = (ItemWand)itemstack.getItem();
        if(!wand.consumeAllVis(itemstack, p, this.getVisCost(itemstack), false, false)) {
            p.resetActiveHand();
        } else {
            String pp = "R" + p.getName();
            if(!world.isRemote) {
                pp = "S" + p.getName();
            }

            if(soundDelay.get(pp) == null) {
                soundDelay.put(pp, Long.valueOf(0L));
            }

            if(breakcount.get(pp) == null) {
                breakcount.put(pp, Float.valueOf(0.0F));
            }

            if(lastX.get(pp) == null) {
                lastX.put(pp, Integer.valueOf(0));
            }

            if(lastY.get(pp) == null) {
                lastY.put(pp, Integer.valueOf(0));
            }

            if(lastZ.get(pp) == null) {
                lastZ.put(pp, Integer.valueOf(0));
            }


            RayTraceResult mop = p.pick(20.0D,0.0F,false);
            Vector3d v = p.getLookVec();
            double tx = p.getPosX() + v.x * 10.0D;
            double ty = p.getPosY() + v.y * 10.0D;
            double tz = p.getPosZ() + v.z * 10.0D;
            byte impact = 0;
            /*if(mop != null) {
                tx = mop.getHitVec().getX();
                ty = mop.getHitVec().getY();
                tz = mop.getHitVec().getZ();
                impact = 5;
                if(!world.isRemote && ((Long)soundDelay.get(pp)).longValue() < System.currentTimeMillis()) {
                    //p.world.playSound(tx, ty, tz, "thaumcraft:rumble", 0.3F, 1.0F);
                    soundDelay.put(pp, Long.valueOf(System.currentTimeMillis() + 1200L));
                }
            } else {
                soundDelay.put(pp, Long.valueOf(0L));
            }*/


            if(world.isRemote) {
                //beaFm.put(pp, Thaumcraft.proxy.beamCont(p.worldObj, p, tx, ty, tz, 2, '\uff66', false, impact > 0?2.0F:0.0F, beam.get(pp), impact));
            }

            if(mop != null && mop.getType() == RayTraceResult.Type.BLOCK && world.getBlockState(((BlockRayTraceResult)mop).getPos()).canHarvestBlock(world,((BlockRayTraceResult)mop).getPos(),p)) {
                BlockPos pos = ((BlockRayTraceResult)mop).getPos();
                BlockState state = world.getBlockState(pos);
                Block bi = state.getBlock();

                //int md = state.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ);
                float hardness = state.getBlockHardness(world,pos);
                if(hardness >= 0.0F) {
                    int pot = 0;
                    float speed = 0.05F + (float)pot * 0.1F;
                    if(state.getMaterial() == Material.ROCK || state.getMaterial() == Material.WOOD || state.getMaterial() == Material.IRON
                            || state.getMaterial() == Material.ORGANIC || state.getMaterial() == Material.WEB || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.EARTH || state.getMaterial() == Material.SAND) {
                        speed = 0.25F + (float)pot * 0.25F;
                    }

                    if(bi == Blocks.OBSIDIAN){
                        speed *= 5.5F;
                    }
                    if(bi == Blocks.CRYING_OBSIDIAN){
                        speed *= 4.0F;
                    }
                    if(bi == ModBlocks.MOON_TEAR_OBSIDIAN_ORE.get()){
                        speed *= 5.0F;
                    }

                    if(((Integer)lastX.get(pp)).intValue() == (int)mop.getHitVec().x && ((Integer)lastY.get(pp)).intValue() == (int)mop.getHitVec().y && ((Integer)lastZ.get(pp)).intValue() == (int)mop.getHitVec().z) {
                        float bc = ((Float)breakcount.get(pp)).floatValue();
                        int a;
                        if(world.isRemote && bc > 0.0F && bi != Blocks.AIR) {
                            a = (int)(bc / hardness * 9.0F);
                            excavateFX(pos, p, world,  a);
                        }

                        if(world.isRemote) {
                            if(bc >= hardness) {
                                breakcount.put(pp, Float.valueOf(0.0F));
                            } else {
                                breakcount.put(pp, Float.valueOf(bc + speed));
                            }
                        } else if(bc >= hardness && wand.consumeAllVis(itemstack, p, this.getVisCost(itemstack), true, false)) {

                            this.excavate(world, itemstack, p, pos, state);



                            lastX.put(pp, Integer.valueOf(Integer.MAX_VALUE));
                            lastY.put(pp, Integer.valueOf(Integer.MAX_VALUE));
                            lastZ.put(pp, Integer.valueOf(Integer.MAX_VALUE));
                            breakcount.put(pp, Float.valueOf(0.0F));
                        } else {
                            breakcount.put(pp, Float.valueOf(bc + speed));
                        }
                    } else {
                        lastX.put(pp, Integer.valueOf((int)mop.getHitVec().x));
                        lastY.put(pp, Integer.valueOf((int)mop.getHitVec().y));
                        lastZ.put(pp, Integer.valueOf((int)mop.getHitVec().z));
                        breakcount.put(pp, Float.valueOf(0.0F));
                    }
                }
            } else {
                lastX.put(pp, Integer.valueOf(Integer.MAX_VALUE));
                lastY.put(pp, Integer.valueOf(Integer.MAX_VALUE));
                lastZ.put(pp, Integer.valueOf(Integer.MAX_VALUE));
                breakcount.put(pp, Float.valueOf(0.0F));
            }


        }
    }


    public void onPlayerStoppedUsingFocus(ItemStack stack, World world, PlayerEntity p, int count) {
        String pp = "R" + p.getName();
        if(!world.isRemote) {
            pp = "S" + p.getName();
        }

        if(soundDelay.get(pp) == null) {
            soundDelay.put(pp, Long.valueOf(0L));
        }

        if(breakcount.get(pp) == null) {
            breakcount.put(pp, Float.valueOf(0.0F));
        }

        if(lastX.get(pp) == null) {
            lastX.put(pp, Integer.valueOf(0));
        }

        if(lastY.get(pp) == null) {
            lastY.put(pp, Integer.valueOf(0));
        }

        if(lastZ.get(pp) == null) {
            lastZ.put(pp, Integer.valueOf(0));
        }

        beam.put(pp, (Object)null);
        lastX.put(pp, Integer.valueOf(Integer.MAX_VALUE));
        lastY.put(pp, Integer.valueOf(Integer.MAX_VALUE));
        lastZ.put(pp, Integer.valueOf(Integer.MAX_VALUE));
        breakcount.put(pp, Float.valueOf(0.0F));
    }

//    @OnlyIn(Dist.CLIENT)
//    public Object beamCont(World worldObj, EntityPlayer p, double tx, double ty, double tz, int type, int color, boolean reverse, float endmod, Object input, int impact) {
//        FXBeamWand beamcon = null;
//        Color c = new Color(color);
//        if(input instanceof FXBeamWand) {
//            beamcon = (FXBeamWand)input;
//        }
//
//        if(beamcon != null && !beamcon.isDead) {
//            beamcon.updateBeam(tx, ty, tz);
//            beamcon.setEndMod(endmod);
//            beamcon.impact = impact;
//        } else {
//            beamcon = new FXBeamWand(worldObj, p, tx, ty, tz, (float)c.getRed() / 255.0F, (float)c.getGreen() / 255.0F, (float)c.getBlue() / 255.0F, 8);
//            beamcon.setType(type);
//            beamcon.setEndMod(endmod);
//            beamcon.setReverse(reverse);
//            FMLClientHandler.instance().getClient().effectRenderer.addEffect(beamcon);
//        }
//
//        return beamcon;
//    }
    @OnlyIn(Dist.CLIENT)
    public void excavateFX(BlockPos pos , PlayerEntity p, World world, int progress) {
        world.sendBlockBreakProgress(p.getEntityId(), pos, progress);
    }
    private boolean excavate(World world, ItemStack stack, PlayerEntity player, BlockPos pos, BlockState state) {
        GameType gt = GameType.SURVIVAL;
        if(player.abilities.allowEdit) {
            if(player.isCreative()) {
                gt = GameType.CREATIVE;
            }
        } else {
            gt = GameType.ADVENTURE;
        }

        int event = ForgeHooks.onBlockBreakEvent(world, gt, (ServerPlayerEntity)player, pos);
        if(event == -1) {
            return false;
        } else {

            //world.setBlockToAir(x, y, z);
            world.destroyBlock(pos,true);
            //world.setBlockState(pos,Blocks.AIR.getDefaultState());
            //world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (md << 12));
            return true;
        }
    }
    public String getSortingHelper(ItemStack focusstack) {
        return "TerraKnob"+super.getSortingHelper(focusstack);
    }
}

