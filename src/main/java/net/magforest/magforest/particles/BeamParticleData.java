package net.magforest.magforest.particles;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.magforest.magforest.events.CommonEvents;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Locale;

public class BeamParticleData implements IParticleData {

    public BeamParticleData(Color tint, double diameter) {
        this.tint = tint;
        this.diameter = constrainDiameterToValidRange(diameter);
    }

    public Color getTint() {
        return tint;
    }

    public double getDiameter() {
        return diameter;
    }
    @Override
    public ParticleType<BeamParticleData> getType() {
        return CommonEvents.beamParticleType;
    }
    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeInt(tint.getRed());
        buffer.writeInt(tint.getGreen());
        buffer.writeInt(tint.getBlue());
        buffer.writeDouble(diameter);
    }
    @Nonnull
    @Override
    public String getParameters() {
        return String.format(Locale.ROOT, "%s %.2f %i %i %i",
                this.getType().getRegistryName(), diameter, tint.getRed(), tint.getGreen(), tint.getBlue());
    }
    private static double constrainDiameterToValidRange(double diameter) {
        final double MIN_DIAMETER = 0.05;
        final double MAX_DIAMETER = 1.0;
        return MathHelper.clamp(diameter, MIN_DIAMETER, MAX_DIAMETER);
    }

    private Color tint;
    private double diameter;


    public static final Codec<BeamParticleData> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Codec.INT.fieldOf("tint").forGetter(d -> d.tint.getRGB()),
                    Codec.DOUBLE.fieldOf("diameter").forGetter(d -> d.diameter)
            ).apply(instance, BeamParticleData::new)
    );

    private BeamParticleData(int tintRGB, double diameter) {
        this.tint = new Color(tintRGB);
        this.diameter = constrainDiameterToValidRange(diameter);
    }


    public static final IDeserializer<BeamParticleData> DESERIALIZER = new IDeserializer<BeamParticleData>() {

        // parse the parameters for this particle from a /particle command
        @Nonnull
        @Override
        public BeamParticleData deserialize(@Nonnull ParticleType<BeamParticleData> type, @Nonnull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            double diameter = constrainDiameterToValidRange(reader.readDouble());

            final int MIN_COLOUR = 0;
            final int MAX_COLOUR = 255;
            reader.expect(' ');
            int red = MathHelper.clamp(reader.readInt(), MIN_COLOUR, MAX_COLOUR);
            reader.expect(' ');
            int green = MathHelper.clamp(reader.readInt(), MIN_COLOUR, MAX_COLOUR);
            reader.expect(' ');
            int blue = MathHelper.clamp(reader.readInt(), MIN_COLOUR, MAX_COLOUR);
            Color color = new Color(red, green, blue);

            return new BeamParticleData(color, diameter);
        }

        // read the particle information from a PacketBuffer after the client has received it from the server
        @Override
        public BeamParticleData read(@Nonnull ParticleType<BeamParticleData> type, PacketBuffer buf) {
            // warning! never trust the data read in from a packet buffer.

            final int MIN_COLOUR = 0;
            final int MAX_COLOUR = 255;
            int red = MathHelper.clamp(buf.readInt(), MIN_COLOUR, MAX_COLOUR);
            int green = MathHelper.clamp(buf.readInt(), MIN_COLOUR, MAX_COLOUR);
            int blue = MathHelper.clamp(buf.readInt(), MIN_COLOUR, MAX_COLOUR);
            Color color = new Color(red, green, blue);

            double diameter = constrainDiameterToValidRange(buf.readDouble());

            return new BeamParticleData(color, diameter);
        }
    };




}
