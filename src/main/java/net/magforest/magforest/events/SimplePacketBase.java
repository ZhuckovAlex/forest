package net.magforest.magforest.events;

import net.minecraft.network.PacketBuffer;

import net.minecraftforge.fml.network.NetworkEvent.Context;
import java.util.function.Supplier;

public abstract class SimplePacketBase {

    public abstract void write(PacketBuffer buffer);

    public abstract void handle(Supplier<Context> context);
}
