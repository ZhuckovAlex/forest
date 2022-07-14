package net.magforest.magforest.events;

import net.magforest.magforest.MagforestModElements;
import net.magforest.magforest.events.packets.PacketFocusChangeToServer;
import net.magforest.magforest.magforest;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraftforge.fml.network.NetworkDirection.PLAY_TO_SERVER;

public class PacketHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("magforest", "magforest"),
            () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    private static int messageID = 0;

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
                                      BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }
    public static <M extends SimplePacketBase> void messageBuilder(Class<M> type,Function<PacketBuffer, M> factory, NetworkDirection direction) {
        PACKET_HANDLER.messageBuilder(type,messageID++,direction).encoder(M::write).decoder(factory).consumer(M::handle).add();
    }

    public static void init(){
        messageBuilder(PacketFocusChangeToServer.class, PacketFocusChangeToServer::new,PLAY_TO_SERVER);
    }
}
