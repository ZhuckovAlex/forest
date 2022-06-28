package net.magforest.magforest.procedures;
import java.util.Map;
import java.util.HashMap;

import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

public class BlockMagic {
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
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                magforest.LOGGER.warn("Failed to load dependency world for procedure Plaint!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                magforest.LOGGER.warn("Failed to load dependency x for procedure Plaint!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                magforest.LOGGER.warn("Failed to load dependency y for procedure Plaint!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                magforest.LOGGER.warn("Failed to load dependency z for procedure Plaint!");
            return;
        }
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                magforest.LOGGER.warn("Failed to load dependency entity for procedure Plaint!");
            return;
        }
        IWorld world = (IWorld) dependencies.get("world");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        Entity entity = (Entity) dependencies.get("entity");
        if (Blocks.POPPY == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() && ModItems.MIRACULUM_FLAMAS.get()
                .asItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()) {
            world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
            world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ModBlocks.THISTLE.get().getDefaultState(), 3);
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 5, 3, 3, 3, 1);
            }
        }

        if (Blocks.DANDELION == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() && ModItems.MIRACULUM_FLAMAS.get()
                .asItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()) {
            world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
            world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ModBlocks.HYACINTH.get().getDefaultState(), 3);
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 5, 3, 3, 3, 1);
            }
        }
        if (Blocks.BLUE_ORCHID == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() && ModItems.MIRACULUM_FLAMAS.get()
                .asItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()) {
            world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
            world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ModBlocks.ICY_YAWN.get().getDefaultState(), 3);
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 5, 3, 3, 3, 1);
            }
        }

        if (Blocks.AZURE_BLUET == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() && ModItems.MIRACULUM_FLAMAS.get()
                .asItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()) {
            world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
            world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ModBlocks.SILVER_SAGE.get().getDefaultState(), 3);
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 5, 3, 3, 3, 1);
            }
        }

        if (Blocks.OXEYE_DAISY == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() && ModItems.MIRACULUM_FLAMAS.get()
                .asItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()) {
            world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
            world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ModBlocks.SLEEPY_LEAF.get().getDefaultState(), 3);
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 5, 3, 3, 3, 1);
            }
        }

        if (Blocks.CORNFLOWER == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() && ModItems.MIRACULUM_FLAMAS.get()
                .asItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()) {
            world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
            world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ModBlocks.SLEEPY_LEAF.get().getDefaultState(), 3);
            if (entity instanceof PlayerEntity) {
                ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
                ((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
                        ((PlayerEntity) entity).container.func_234641_j_());
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 5, 3, 3, 3, 1);
            }
        }

    }
}
