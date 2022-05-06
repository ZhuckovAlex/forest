package net.magforest.magforest.block;

import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

public class DropAcorn {
    @Mod.EventBusSubscriber
    private static class GlobalTrigger {
        @SubscribeEvent
        public static void onBlockBreak(BlockEvent.BreakEvent event) {
            Entity entity = event.getPlayer();
            IWorld world = event.getWorld();
            Map<String, Object> dependencies = new HashMap<>();
            dependencies.put("xpAmount", event.getExpToDrop());
            dependencies.put("x", event.getPos().getX());
            dependencies.put("y", event.getPos().getY());
            dependencies.put("z", event.getPos().getZ());
            dependencies.put("px", entity.getPosX());
            dependencies.put("py", entity.getPosY());
            dependencies.put("pz", entity.getPosZ());
            dependencies.put("world", world);
            dependencies.put("entity", entity);
            dependencies.put("blockstate", event.getState());
            dependencies.put("event", event);
            executeProcedure(dependencies);
        }
    }
    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                magforest.LOGGER.warn("Failed to load dependency entity for procedure CropDropGrass!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                magforest.LOGGER.warn("Failed to load dependency x for procedure CropDropGrass!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                magforest.LOGGER.warn("Failed to load dependency y for procedure CropDropGrass!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                magforest.LOGGER.warn("Failed to load dependency z for procedure CropDropGrass!");
            return;
        }
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                magforest.LOGGER.warn("Failed to load dependency world for procedure CropDropGrass!");
            return;
        }
        Entity entity = (Entity) dependencies.get("entity");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        IWorld world = (IWorld) dependencies.get("world");
        double randomChance = 0;
        if ((!(world.isRemote()))) {
            if ((!(new Object() {
                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayerEntity) {
                        return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
                    } else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
                        NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
                                .getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
                        return _npi != null && _npi.getGameType() == GameType.CREATIVE;
                    }
                    return false;
                }
            }.checkGamemode(entity)))) {
                if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OAK_LEAVES))) {
                    randomChance = (double) Math.random();
                    if ((randomChance <= 0.025)) {
                        if (world instanceof World && !world.isRemote()) {
                            ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(ModItems.ACORN.get()));
                            entityToSpawn.setPickupDelay((int) 10);
                            world.addEntity(entityToSpawn);

                        }
                    }
                }
            }
        }
    }
}