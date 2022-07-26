package net.magforest.magforest.particles;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BasicParticleType;

import javax.annotation.Nullable;

public class BeamParticleFactory implements IParticleFactory<BeamParticleData> {  //IParticleFactory
    public static BeamParticleFactory FACTORY;
    @Nullable
    @Override
    public Particle makeParticle(BeamParticleData flameParticleData, ClientWorld world, double xPos, double yPos, double zPos, double xVelocity, double yVelocity, double zVelocity) {
        BeamParticle newParticle = new BeamParticle(world, xPos, yPos, zPos, xVelocity, yVelocity, zVelocity);
        return newParticle;
    }


    public BeamParticleFactory() {
        FACTORY = this;
    }
}