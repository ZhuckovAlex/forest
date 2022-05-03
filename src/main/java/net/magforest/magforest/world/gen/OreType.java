package net.magforest.magforest.world.gen;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;
import net.magforest.magforest.block.ModBlocks;

public enum OreType {

    MOON_TEAR(Lazy.of(ModBlocks.MOON_TEAR_ORE), 5, 5, 17, 1),
    PINFIRE_ORE(Lazy.of(ModBlocks.PINFIRE_ORE), 5, 8, 110, 2),
    LAVA_ROCK(Lazy.of(ModBlocks.LAVA_ROCK), 15, 4, 15, 15);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final int veinsPerChunk;


    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinsPerChunk = veinsPerChunk;
    }
    public int getVeinsPerChunk() {
        return veinsPerChunk;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if(block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}
