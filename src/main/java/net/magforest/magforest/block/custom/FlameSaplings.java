package net.magforest.magforest.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.Random;

public class FlameSaplings extends SaplingBlock {


    public FlameSaplings(Tree treeIn, Properties properties) {
        super(treeIn, properties);
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