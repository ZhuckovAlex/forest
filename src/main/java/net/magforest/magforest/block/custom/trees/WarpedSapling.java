package net.magforest.magforest.block.custom.trees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class WarpedSapling extends SaplingBlock {
    public WarpedSapling(Tree treeIn, Properties properties) {
        super(treeIn, properties);
    }
    @Override
    public boolean isValidPosition(BlockState blockstate, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState groundState = worldIn.getBlockState(blockpos);
        Block ground = groundState.getBlock();
        return ground == this || (ground == Blocks.GRASS_BLOCK)|| (ground == Blocks.DIRT)|| (ground == Blocks.COARSE_DIRT)|| (ground == Blocks.PODZOL)|| (ground == Blocks.FARMLAND)|| (ground == Blocks.WARPED_NYLIUM);
    }
}
