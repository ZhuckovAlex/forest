package net.magforest.magforest.entity.projectile;

import net.magforest.magforest.util.ModHellEntityHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityAir extends ThrowableEntity implements IEntityAdditionalSpawnData {

    public int duration = 20;
    public float damage = 2.0F;

    public EntityAir(EntityType<? extends ThrowableEntity> entityEmberEntityType, World world) {
        super(entityEmberEntityType,world);

    }

    public static EntityAir createAir(EntityType<? extends ThrowableEntity> type, LivingEntity livingEntityIn, World worldIn){
        EntityAir ember = new EntityAir(type,worldIn);
        ember.setPosition(livingEntityIn.getPosX(), livingEntityIn.getPosYEye() - (double)0.1F, livingEntityIn.getPosZ());
        ember.setShooter(livingEntityIn);
        return ember;
    }






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
    private int knockbackStrength = 0;
    protected void onImpact(RayTraceResult result) {
        if(!super.world.isRemote) {
            if(result.getType() == RayTraceResult.Type.ENTITY) {

                    if(((EntityRayTraceResult)result).getEntity().attackEntityFrom(DamageSource.IN_FIRE, this.damage)) {
                        if (this.knockbackStrength > 0) {
                            Vector3d vector3d = this.getMotion().mul(1.0D, 0.1D, 1.0D).normalize().scale((double)this.knockbackStrength * 0.6D);
                            if (vector3d.lengthSquared() > 0.0D) {
                                ((EntityRayTraceResult)result).getEntity().addVelocity(vector3d.x, 0.5D, vector3d.z);
                            }
                        }

                    }
            }
        }

        this.setDead();
    }

    public void setKnockbackStrength(int knockbackStrengthIn) {
        this.knockbackStrength = knockbackStrengthIn;
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
        par1NBTTagCompound.putInt("duration", this.duration);
    }

    public void readAdditional(CompoundNBT par1NBTTagCompound) {
        super.readAdditional(par1NBTTagCompound);
        this.damage = par1NBTTagCompound.getFloat("damage");
        this.duration = par1NBTTagCompound.getInt("duration");
    }


}
