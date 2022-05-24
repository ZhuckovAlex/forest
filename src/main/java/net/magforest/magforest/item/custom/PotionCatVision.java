package net.magforest.magforest.item.custom;

import net.magforest.magforest.procedures.PotionCatVisionProcedure;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PotionCatVision extends Item {
    public PotionCatVision(Properties properties) {
        super(properties);
    }

    @Override
    public UseAction getUseAction(ItemStack itemstack) {
        return UseAction.DRINK;
    }


    @Override
    public net.minecraft.util.SoundEvent getEatSound() {
        return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
        ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
        double x = entity.getPosX();
        double y = entity.getPosY();
        double z = entity.getPosZ();

        PotionCatVisionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
        return retval;
    }
}