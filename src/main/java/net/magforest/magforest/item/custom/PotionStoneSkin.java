package net.magforest.magforest.item.custom;

import net.magforest.magforest.procedures.PotionStoneSkinProcedure;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PotionStoneSkin extends Item {
    public PotionStoneSkin(Properties properties) {
        super(properties);
    }

    @Override
    public UseAction getUseAction(ItemStack itemstack) {
        return UseAction.DRINK;
    }


    @Override
    public net.minecraft.util.SoundEvent getEatSound() {
        return net.minecraft.util.SoundEvents.BLOCK_BREWING_STAND_BREW;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
        ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
        double x = entity.getPosX();
        double y = entity.getPosY();
        double z = entity.getPosZ();

        PotionStoneSkinProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
        return retval;
    }
}