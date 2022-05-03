package net.magforest.magforest.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CristalBlock extends DirectionalBlock {

    protected static final VoxelShape UP = Block.makeCuboidShape(7.0D, 8.0D, 7.0D, 10.0D, 16.0D, 10.0D);
    protected static final VoxelShape DOWN = Block.makeCuboidShape(7.0D, 0.0D, 6.0D, 10.0D, 8.0D, 9.0D);
    protected static final VoxelShape SOUTH = Block.makeCuboidShape(7.0D, 6.0D, 8.0D, 10.0D, 9.0D, 16.0D);
    protected static final VoxelShape NORTH = Block.makeCuboidShape(6.0D, 6.0D, 0.0D, 9.0D, 9.0D, 8.0D);
    protected static final VoxelShape EAST = Block.makeCuboidShape(8.0D, 6.0D, 6.0D, 16.0D, 9.0D, 9.0D);
    protected static final VoxelShape WEST = Block.makeCuboidShape(0.0D, 6.0D, 7.0D, 8.0D, 9.0D, 10.0D);
    public CristalBlock(Properties builder) {
        super(builder);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }


    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.with(FACING, mirrorIn.mirror(state.get(FACING)));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING).getOpposite()) {
            case DOWN:
                return DOWN;
            case UP:
                return UP;
            case NORTH:
                return NORTH;
            case SOUTH:
                return SOUTH;
            case WEST:
                return WEST;
            case EAST:
                return EAST;
        }

        return null;
    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getFace();
        BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(direction.getOpposite()));
        return blockstate.matchesBlock(this) && blockstate.get(FACING) == direction ? this.getDefaultState().with(FACING, direction.getOpposite()) : this.getDefaultState().with(FACING, direction);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}

