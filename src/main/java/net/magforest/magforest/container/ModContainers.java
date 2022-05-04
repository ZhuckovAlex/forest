package net.magforest.magforest.container;

import net.magforest.magforest.magforest;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, magforest.MOD_ID);

    public static final RegistryObject<ContainerType<LightningMachineContainer>> LIGHTING_MACHINE_CONTAINER
            = CONTAINERS.register("lighting_machine_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new LightningMachineContainer(windowId, world, pos, inv, inv.player);
            })));
    public static final RegistryObject<ContainerType<SolarConverterContainer>> SOLAR_CONVERTER_CONTAINER
            = CONTAINERS.register("solar_converter_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new SolarConverterContainer(windowId, world, pos, inv, inv.player);
            })));
    public static final RegistryObject<ContainerType<AlchemyTableContainer>> ALCHEMY_TABLE_CONTAINER
            = CONTAINERS.register("alchemy_table_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new AlchemyTableContainer(windowId, world, pos, inv, inv.player);
            })));


    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
