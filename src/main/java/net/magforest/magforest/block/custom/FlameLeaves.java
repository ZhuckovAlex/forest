package net.magforest.magforest.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nullable;
public class FlameLeaves extends LeavesBlock{
    public static final Block block = null;

        public FlameLeaves(Properties Properties) {
        super(Properties);
    }
    private static class BlockColorRegisterHandler {
        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public void blockColorLoad(ColorHandlerEvent.Block event) {
            event.getBlockColors().register((bs, world, pos, index) -> {
                return world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.get(0.5D, 1.0D);
            }, block);
        }
    }

    private static class ItemColorRegisterHandler {
        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public void itemColorLoad(ColorHandlerEvent.Item event) {
            event.getItemColors().register((stack, index) -> {
                return GrassColors.get(0.5D, 1.0D);
            }, block);
        }
    }


    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        {
            return 100;
        }
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face)
        {
            return true;
        }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 10;

    }
    @Override
    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
        super.catchFire(state, world, pos, face, igniter);
    }
    @Override
    public boolean isBurning(BlockState state, IBlockReader world, BlockPos pos) {
        return true;
    }
}
