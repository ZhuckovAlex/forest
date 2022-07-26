package net.magforest.magforest.particles;

import com.mojang.serialization.Codec;
import net.minecraft.particles.ParticleType;

public class BeamParticleType extends ParticleType<BeamParticleData> {
    private static boolean ALWAYS_SHOW_REGARDLESS_OF_DISTANCE_FROM_PLAYER = false;
    public BeamParticleType() {
        super(ALWAYS_SHOW_REGARDLESS_OF_DISTANCE_FROM_PLAYER, BeamParticleData.DESERIALIZER);
    }

    public Codec<BeamParticleData> func_230522_e_() {
        return BeamParticleData.CODEC;
    }
}