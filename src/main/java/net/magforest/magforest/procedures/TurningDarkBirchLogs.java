package net.magforest.magforest.procedures;

import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class TurningDarkBirchLogs {
    @Mod.EventBusSubscriber
    private static class GlobalTrigger {
        @SubscribeEvent
        public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

            PlayerEntity entity = event.getPlayer();
            if (event.getHand() != entity.getActiveHand()) {
                return;
            }
            double i = event.getPos().getX();
            double j = event.getPos().getY();
            double k = event.getPos().getZ();
            IWorld world = event.getWorld();
            BlockState state = world.getBlockState(event.getPos());
            Map<String, Object> dependencies = new HashMap<>();
            dependencies.put("x", i);
            dependencies.put("y", j);
            dependencies.put("z", k);
            dependencies.put("world", world);
            dependencies.put("entity", entity);
            dependencies.put("direction", event.getFace());
            dependencies.put("blockstate", state);
            dependencies.put("event", event);
            executeProcedure(dependencies);
        }
    }
    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                magforest.LOGGER.warn("Failed to load dependency entity for procedure Magic!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                magforest.LOGGER.warn("Failed to load dependency x for procedure Magic!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                magforest.LOGGER.warn("Failed to load dependency y for procedure Magic!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                magforest.LOGGER.warn("Failed to load dependency z for procedure Magic!");
            return;
        }
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                magforest.LOGGER.warn("Failed to load dependency world for procedure Magic!");
            return;
        }
        Entity entity = (Entity) dependencies.get("entity");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        IWorld world = (IWorld) dependencies.get("world");
        boolean found = false;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ModBlocks.STRIPPED_DARK_BIRCH_LOG.get() ||
                (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ModBlocks.DARK_BIRCH_LOG.get() ||
                (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ModBlocks.STRIPPED_DARK_BIRCH_WOOD.get() ||
                (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ModBlocks.DARK_BIRCH_WOOD.get())
                && (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ModItems.ETHER_MIX.get()
                .asItem()))) {
            world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = new ItemStack(ModItems.ETHER_MIX.get());
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }

            if (true) {
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;
                    private IWorld world;

                    public void start(IWorld world, int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                        this.world = world;
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks += 1;
                            if (this.ticks >= this.waitTicks)
                                run();
                        }
                    }

                    private void run() {
                        if (entity instanceof PlayerEntity) {
                            ItemStack _setstack = new ItemStack(ModItems.DARK_BIRCH_CORE.get());
                            _setstack.setCount((int) 1);
                            ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
                        }
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(world, (int) 30);

                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 30, 1, 1, 1, 0.1);
                }

                if (world instanceof World && !world.isRemote()) {
                    ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1);
                } else {
                    ((World) world).playSound(x, y, z,
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
                }

            }
        }
    }
}
