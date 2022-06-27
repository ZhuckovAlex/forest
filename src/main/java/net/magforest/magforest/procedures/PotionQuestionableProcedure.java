package net.magforest.magforest.procedures;

import net.magforest.magforest.magforest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.Map;

public class PotionQuestionableProcedure {
    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                magforest.LOGGER.warn("Failed to load dependency entity for procedure PotionGlotok!");
            return;
        }
        Entity entity = (Entity) dependencies.get("entity");
        if (entity instanceof LivingEntity)
            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 400, (int) 0, false,false));
        ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 80, (int) 0, false,false));
    }

}