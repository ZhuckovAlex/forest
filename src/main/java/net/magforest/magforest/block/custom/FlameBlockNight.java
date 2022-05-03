package net.magforest.magforest.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class FlameBlockNight extends Block {
    public FlameBlockNight(Properties Properties) {
        super(Properties);
    }

    public static BooleanProperty NIGHT_TIME = BooleanProperty.create("night_time");

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        context.getWorld().getPendingBlockTicks().scheduleTick(context.getPos(), this, 20);
        return this.getDefaultState().with(NIGHT_TIME, context.getWorld().isNightTime());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(NIGHT_TIME);
    }


    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if(worldIn.isNightTime()) {
            worldIn.setBlockState(pos, state.with(NIGHT_TIME, true));
        } else {
            worldIn.setBlockState(pos, state.with(NIGHT_TIME, false));
        }

        worldIn.getPendingBlockTicks().scheduleTick(pos, this, 20);
        super.tick(state, worldIn, pos, rand);
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        {
            return 75;
        }
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face)
        {
            return true;
        }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 15;

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
