package net.magforest.magforest.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

public class Pedestal extends Block {
    public Pedestal(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        Vector3d offset = state.getOffset(world, pos);
        return VoxelShapes.or(
                makeCuboidShape(2, 9, 2, 14, 16, 14),
                makeCuboidShape(4, 5, 4, 12, 9, 12),
                makeCuboidShape(3, 0, 3, 13, 5, 13)
                ).withOffset(offset.x, offset.y, offset.z);
    }
}
