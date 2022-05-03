package net.magforest.magforest.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class NetherSapling extends SaplingBlock {

    public NetherSapling(Tree treeIn, Properties properties) {
        super(treeIn, properties);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.matchesBlock(Blocks.CRIMSON_NYLIUM) || state.matchesBlock(Blocks.WARPED_NYLIUM);
    }
}
