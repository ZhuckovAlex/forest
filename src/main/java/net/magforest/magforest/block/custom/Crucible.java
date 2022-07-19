package net.magforest.magforest.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

public class Crucible extends Block {
    public Crucible(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        Vector3d offset = state.getOffset(world, pos);
        return VoxelShapes.or(
                makeCuboidShape(2, 2, 2, 14, 14, 3),
                makeCuboidShape(14, 2, 2, 13, 14, 14),
                makeCuboidShape(14, 2, 14, 2, 14, 13),
                makeCuboidShape(2, 2, 13, 3, 14, 2),
                makeCuboidShape(2, 2, 2, 14, 3, 14)

                ).withOffset(offset.x, offset.y, offset.z);
    }
}
