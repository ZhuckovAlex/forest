package net.magforest.magforest.entity.projectile;

import net.magforest.magforest.magforest;
import net.magforest.magforest.util.ModHellEntityHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityFrostShard extends ThrowableEntity implements IEntityAdditionalSpawnData {
    public double bounce = 0.5D;
    public int bounceLimit = 0;
    public boolean fragile = false;
    public EntityFrostShard(EntityType<? extends ThrowableEntity> entityEmberEntityType, World world) {
        super(entityEmberEntityType,world);

    }

    public static EntityFrostShard createFrost(EntityType<? extends ThrowableEntity> type, LivingEntity livingEntityIn, World worldIn){
        EntityFrostShard ember = new EntityFrostShard(type,worldIn);
        ember.setPosition(livingEntityIn.getPosX(), livingEntityIn.getPosYEye() - (double)0.1F, livingEntityIn.getPosZ());
        ember.setShooter(livingEntityIn);
        return ember;
    }

    protected void onImpact(RayTraceResult mop) {
        int a;
        int a1;
        if(mop.getType() == RayTraceResult.Type.ENTITY) {
            Entity entityHit = ((EntityRayTraceResult)mop).getEntity();
            int var20 = MathHelper.floor(super.getPosX()) - MathHelper.floor(entityHit.getPosX());
            a = MathHelper.floor(super.getPosY()) - MathHelper.floor(entityHit.getPosY());
            a1 = MathHelper.floor(super.getPosZ()) - MathHelper.floor(entityHit.getPosZ());

            if(a1 != 0) {
                super.setMotion(super.getMotion().x,super.getMotion().y,super.getMotion().z* -1.0D);
                //super.motionZ *= -1.0D;
            }

            if(var20 != 0) {
                super.setMotion(super.getMotion().x* -1.0D,super.getMotion().y,super.getMotion().z);
                //super.motionX *= -1.0D;;
            }

            if(a != 0) {
                super.setMotion(super.getMotion().x,super.getMotion().y* -0.9D,super.getMotion().z);
               // super.motionY * -0.9D;
            }

//            super.motionX *= 0.66D;
//            super.motionY *= 0.66D;
//            super.motionZ *= 0.66D;

            super.setMotion(super.getMotion().x* 0.66D,super.getMotion().y* 0.66D,super.getMotion().z* 0.66D);

//            for(int my = 0; (float)my < this.getDamage(); ++my) {
//                super.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(ConfigBlocks.blockCustomOre) + "_15", super.posX, super.posY, super.posZ, 4.0D * ((double)super.rand.nextFloat() - 0.5D), 0.5D, ((double)super.rand.nextFloat() - 0.5D) * 4.0D);
//            }
        } else if(mop.getType() == RayTraceResult.Type.BLOCK) {
            Direction var10 = Direction.getFacingFromVector(mop.getHitVec().x,mop.getHitVec().y,mop.getHitVec().z);
            if(var10.getZOffset() != 0) {
                super.setMotion(super.getMotion().x,super.getMotion().y,super.getMotion().z* -1.0D);
                //super.motionZ *= -1.0D;
            }

            if(var10.getXOffset() != 0) {
                super.setMotion(super.getMotion().x* -1.0D,super.getMotion().y,super.getMotion().z);
                //super.motionX *= -1.0D;
            }

            if(var10.getYOffset() != 0) {
                super.setMotion(super.getMotion().x,super.getMotion().y* -0.9D,super.getMotion().z);
                //super.motionY *= -0.9D;
            }

            BlockPos pos = ((BlockRayTraceResult)mop).getPos();

            //magforest.LOGGER.debug(pos);
            Block var12 = super.world.getBlockState(pos).getBlock();
            try {
                this.playSound(var12.getSoundType(var12.getDefaultState()).getBreakSound(), 0.3F, 1.2F / (super.rand.nextFloat() * 0.2F + 0.9F));
            } catch (Exception var9) {
                ;
            }

            if(super.world.getBlockState(pos).getMaterial() == Material.FIRE) {
                super.world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }else if(super.world.getBlockState(pos).getMaterial() == Material.LAVA) {
                super.world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
            }

//            for(a1 = 0; (float)a1 < this.getDamage(); ++a1) {
//                super.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(var12) + "_" + super.worldObj.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ), super.posX, super.posY, super.posZ, 4.0D * ((double)super.rand.nextFloat() - 0.5D), 0.5D, ((double)super.rand.nextFloat() - 0.5D) * 4.0D);
//            }
        }

//        super.motionX *= this.bounce;
//        super.motionY *= this.bounce;
//        super.motionZ *= this.bounce;
        super.setMotion(super.getMotion().x* this.bounce,super.getMotion().y* this.bounce,super.getMotion().z* this.bounce);
        float var11 = MathHelper.sqrt(super.getMotion().x * super.getMotion().x + super.getMotion().y * super.getMotion().y + super.getMotion().z * super.getMotion().z);
        super.setPosition(super.getPosX() - super.getMotion().x / (double)var11 * 0.05000000074505806D,super.getPosY()-super.getMotion().y / (double)var11 * 0.05000000074505806D,super.getPosZ()-super.getMotion().z / (double)var11 * 0.05000000074505806D);
        //this.setBeenAttacked();
        if(!super.world.isRemote && mop.getType() == RayTraceResult.Type.ENTITY) {
            Entity entityHit = ((EntityRayTraceResult)mop).getEntity();
            entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), ModHellEntityHelper.isHellEntity(entityHit)? this.getDamage()*6:this.getDamage());


        }

        if(this.bounceLimit-- <= 0) {
            this.setDead();
//            this.playSound(Blocks.ICE.getSoundType(Blocks.ICE.getDefaultState()).getBreakSound(), 0.3F, 1.2F / (super.rand.nextFloat() * 0.2F + 0.9F));
//
//            for(a = 0; (float)a < 8.0F * this.getDamage(); ++a) {
//                super.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.ICE.getDefaultState()), super.getPosX(), super.getPosY(), super.getPosZ(), 4.0D * ((double)super.rand.nextFloat() - 0.5D), 0.5D, ((double)super.rand.nextFloat() - 0.5D) * 4.0D);
//            }
        }

    }
    public IPacket<?> createSpawnPacket() {return NetworkHooks.getEntitySpawningPacket(this);}
    public float getDamage() {
        return 1F;
    }
    public void tick() {
        super.tick();
        float var20;

        Vector3d vector3d = this.getMotion();
        Vector3d vector3d1 = this.getPositionVec();
        Vector3d vector3d2 = vector3d1.add(vector3d);
        RayTraceResult raytraceresult = world.rayTraceBlocks(new RayTraceContext(vector3d1, vector3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.ANY, this));
        if (raytraceresult.getType() != RayTraceResult.Type.MISS  && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
            this.onImpact(raytraceresult);
        }
        var20 = MathHelper.sqrt(super.getMotion().getX() * super.getMotion().getX() + super.getMotion().getZ() * super.getMotion().getZ());
        super.rotationYaw = (float)(Math.atan2(super.getMotion().getX(), super.getMotion().getZ()) * 180.0D / 3.141592653589793D);

        for(super.rotationPitch = (float)(Math.atan2(super.getMotion().getY(), (double)var20) * 180.0D / 3.141592653589793D); super.rotationPitch - super.prevRotationPitch < -180.0F; super.prevRotationPitch -= 360.0F) {
            ;
        }

        while(super.rotationPitch - super.prevRotationPitch >= 180.0F) {
            super.prevRotationPitch += 360.0F;
        }

        while(super.rotationYaw - super.prevRotationYaw < -180.0F) {
            super.prevRotationYaw -= 360.0F;
        }

        while(super.rotationYaw - super.prevRotationYaw >= 180.0F) {
            super.prevRotationYaw += 360.0F;
        }

        super.rotationPitch = super.prevRotationPitch + (super.rotationPitch - super.prevRotationPitch) * 0.2F;
        super.rotationYaw = super.prevRotationYaw + (super.rotationYaw - super.prevRotationYaw) * 0.2F;
    }
    @Override
    protected void registerData() {

    }
    protected float getGravityVelocity() {
        return this.fragile?0.015F:0.05F;
    }
    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeDouble(this.bounce);
        buffer.writeInt(this.bounceLimit);
        buffer.writeBoolean(this.fragile);
    }

    @Override
    public void readSpawnData(PacketBuffer additionalData) {
        this.bounce = additionalData.readDouble();
        this.bounceLimit = additionalData.readInt();
        this.fragile = additionalData.readBoolean();
    }
}
