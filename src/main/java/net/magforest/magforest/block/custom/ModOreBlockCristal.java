package net.magforest.magforest.block.custom;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class ModOreBlockCristal extends OreBlock {
    public ModOreBlockCristal(Properties properties) {
        super(properties);
    }
    @Override
    protected int getExperience(Random rand) {
        return MathHelper.nextInt(rand, 7, 15);
    }
}
