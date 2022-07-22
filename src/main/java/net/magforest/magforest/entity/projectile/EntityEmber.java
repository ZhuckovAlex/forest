package net.magforest.magforest.entity.projectile;

import net.magforest.magforest.magforest;
import net.magforest.magforest.util.ModHellEntityHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityEmber extends ThrowableEntity implements IEntityAdditionalSpawnData {

    public int duration = 20;
    public int firey = 0;
    public float damage = 5.0F;

    public EntityEmber(EntityType<? extends ThrowableEntity> entityEmberEntityType, World world) {
        super(entityEmberEntityType,world);

    }

    public static EntityEmber createEmber(EntityType<? extends ThrowableEntity> type, LivingEntity livingEntityIn, World worldIn){
        EntityEmber ember = new EntityEmber(type,worldIn);
        ember.setPosition(livingEntityIn.getPosX(), livingEntityIn.getPosYEye() - (double)0.1F, livingEntityIn.getPosZ());
        ember.setShooter(livingEntityIn);
        return ember;
    }

//    public EntityEmber(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World worldIn) {
//        this(type, worldIn);
//        this.setPosition(x, y, z);
//    }
//
//    public EntityEmber(EntityType<? extends ThrowableEntity> type, LivingEntity livingEntityIn, World worldIn) {
//        this(type, livingEntityIn.getPosX(), livingEntityIn.getPosYEye() - (double)0.1F, livingEntityIn.getPosZ(), worldIn);
//        this.setShooter(livingEntityIn);
//    }





    @Override
    protected void registerData() {

    }

    public void tick() {
        if(super.ticksExisted > this.duration) {
            this.setDead();
        }

        if(this.duration <= 20) {
            super.setMotion(super.getMotion().x * 0.95D,super.getMotion().y * 0.95D,super.getMotion().z * 0.95D);
        } else {
            super.setMotion(super.getMotion().x * 0.975D,super.getMotion().y * 0.975D,super.getMotion().z * 0.975D);
        }

        if(super.onGround) {
            super.setMotion(super.getMotion().x * 0.66D,super.getMotion().y * 0.66D,super.getMotion().z * 0.66D);
        }

        super.tick();
    }

    protected boolean canTriggerWalking() {
        return false;
    }
    protected void onImpact(RayTraceResult result) {
        if(!super.world.isRemote) {
            if(result.getType() == RayTraceResult.Type.ENTITY) {
                if(!ModHellEntityHelper.isHellEntity(((EntityRayTraceResult)result).getEntity()))
                if(!((EntityRayTraceResult)result).getEntity().isImmuneToFire() && ((EntityRayTraceResult)result).getEntity().attackEntityFrom(DamageSource.IN_FIRE, this.damage)) {
                   ((EntityRayTraceResult)result).getEntity().setFire(3 + this.firey);

                }
            } else if(result.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos pos =  ((BlockRayTraceResult)result).getPos();
                if(super.world.getBlockState(pos).getMaterial().getColor() == MaterialColor.ICE) {
                    super.world.setBlockState(pos, Blocks.WATER.getDefaultState());
                }
            }
        }

        this.setDead();
    }

    public void writeSpawnData(PacketBuffer data) {
        data.writeByte(this.duration);
    }

    public void readSpawnData(PacketBuffer data) {
        this.duration = data.readByte();
    }
    protected float getGravityVelocity() {
        return 0.0F;
    }

    public float func_70182_d() {
        return 1.0F;
    }




    public void writeAdditional(CompoundNBT par1NBTTagCompound) {
        super.writeAdditional(par1NBTTagCompound);
        par1NBTTagCompound.putFloat("damage", this.damage);
        par1NBTTagCompound.putInt("firey", this.firey);
        par1NBTTagCompound.putInt("duration", this.duration);
    }

    public void readAdditional(CompoundNBT par1NBTTagCompound) {
        super.readAdditional(par1NBTTagCompound);
        this.damage = par1NBTTagCompound.getFloat("damage");
        this.firey = par1NBTTagCompound.getInt("firey");
        this.duration = par1NBTTagCompound.getInt("duration");
    }


}
