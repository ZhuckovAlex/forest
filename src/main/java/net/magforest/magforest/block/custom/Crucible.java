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
                makeCuboidShape(2, 0, 2, 5, 2, 5),
                makeCuboidShape(2, 0, 11, 5, 2, 14),
                makeCuboidShape(11, 0, 11, 14, 2, 14),
                makeCuboidShape(11, 0, 2, 14, 2, 5),
                makeCuboidShape(4, 2, 4, 12, 3, 12),
                makeCuboidShape(4, 4, 14, 12, 6, 15),
                makeCuboidShape(3, 4, 13, 4, 6, 14),
                makeCuboidShape(2, 4, 12, 3, 6, 13),
                makeCuboidShape(13, 4, 12, 14, 6, 13),
                makeCuboidShape(12, 4, 2, 13, 6, 3),
                makeCuboidShape(4, 4, 1, 12, 6, 2),
                makeCuboidShape(13, 4, 3, 14, 6, 4),
                makeCuboidShape(12, 4, 13, 13, 6, 14),
                makeCuboidShape(3, 4, 2, 4, 6, 3),
                makeCuboidShape(2, 4, 3, 3, 6, 4),
                makeCuboidShape(1, 4, 4, 2, 6, 12),
                makeCuboidShape(14, 4, 4, 15, 6, 12),
                makeCuboidShape(2, 3, 4, 3, 4, 12),
                makeCuboidShape(4, 3, 13, 12, 4, 14),
                makeCuboidShape(13, 3, 4, 14, 4, 12),
                makeCuboidShape(4, 3, 2, 12, 4, 3),
                makeCuboidShape(12, 3, 3, 13, 4, 4),
                makeCuboidShape(12, 3, 12, 13, 4, 13),
                makeCuboidShape(3, 3, 12, 4, 4, 13),
                makeCuboidShape(3, 3, 3, 4, 4, 4),
                makeCuboidShape(4, 2, 12, 12, 3, 13),
                makeCuboidShape(12, 2, 4, 13, 3, 12),
                makeCuboidShape(4, 2, 3, 12, 3, 4),
                makeCuboidShape(3, 2, 4, 4, 3, 12),
                makeCuboidShape(0, 6, 4, 1, 12, 12),
                makeCuboidShape(1, 6, 12, 2, 12, 13),
                makeCuboidShape(2, 6, 13, 3, 12, 14),
                makeCuboidShape(3, 6, 14, 4, 12, 15),
                makeCuboidShape(4, 6, 15, 12, 12, 16),
                makeCuboidShape(13, 6, 13, 14, 12, 14),
                makeCuboidShape(12, 6, 14, 13, 12, 15),
                makeCuboidShape(14, 6, 12, 15, 12, 13),
                makeCuboidShape(15, 6, 4, 16, 12, 12),
                makeCuboidShape(14, 6, 3, 15, 12, 4),
                makeCuboidShape(13, 6, 2, 14, 12, 3),
                makeCuboidShape(12, 6, 1, 13, 12, 2),
                makeCuboidShape(4, 6, 0, 12, 12, 1),
                makeCuboidShape(3, 6, 1, 4, 12, 2),
                makeCuboidShape(2, 6, 2, 3, 12, 3),
                makeCuboidShape(1, 6, 3, 2, 12, 4),
                makeCuboidShape(4, 11, 14, 12, 13, 15),
                makeCuboidShape(12, 11, 13, 13, 13, 14),
                makeCuboidShape(13, 11, 12, 14, 13, 13),
                makeCuboidShape(14, 11, 4, 15, 13, 12),
                makeCuboidShape(13, 11, 3, 14, 13, 4),
                makeCuboidShape(12, 11, 2, 13, 13, 3),
                makeCuboidShape(4, 11, 1, 12, 13, 2),
                makeCuboidShape(3, 11, 2, 4, 13, 3),
                makeCuboidShape(2, 11, 3, 3, 13, 4),
                makeCuboidShape(1, 11, 4, 2, 13, 12),
                makeCuboidShape(2, 11, 12, 3, 13, 13),
                makeCuboidShape(3, 11, 13, 4, 13, 14),

                makeCuboidShape(2, 14, 12, 3, 15, 13),
                makeCuboidShape(3, 14, 13, 4, 15, 14),
                makeCuboidShape(3, 13, 12, 4, 15, 13),
                makeCuboidShape(2, 13, 4, 3, 15, 12),
                makeCuboidShape(2, 14, 3, 3, 15, 4),
                makeCuboidShape(3, 13, 3, 4, 15, 4),
                makeCuboidShape(3, 14, 2, 4, 15, 3),
                makeCuboidShape(4, 13, 2, 12, 15, 3),
                makeCuboidShape(4, 14, 1, 12, 15, 2),
                makeCuboidShape(3, 11, 13, 4, 13, 14),
                makeCuboidShape(12, 14, 2, 13, 15, 3),
                makeCuboidShape(12, 13, 3, 13, 15, 4),
                makeCuboidShape(13, 14, 3, 14, 15, 4),
                makeCuboidShape(14, 14, 4, 15, 15, 12),
                makeCuboidShape(13, 13, 4, 14, 15, 12),
                makeCuboidShape(13, 14, 12, 14, 15, 13),
                makeCuboidShape(12, 14, 13, 13, 15, 14),
                makeCuboidShape(4, 13, 13, 12, 15, 14),
                makeCuboidShape(4, 14, 14, 12, 15, 15),
                makeCuboidShape(1, 14, 4, 2, 15, 12),
                makeCuboidShape(12, 13, 12, 13, 15, 13)
                ).withOffset(offset.x, offset.y, offset.z);
    }
}
