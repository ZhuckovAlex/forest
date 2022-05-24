package net.magforest.magforest.procedures;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.GameType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class PotionCatVisionProcedure {
    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                magforest.LOGGER.warn("Failed to load dependency entity for procedure PotionGlotok!");
            return;
        }
        Entity entity = (Entity) dependencies.get("entity");
        if (!(new Object() {
            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayerEntity) {
                    return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
                } else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
                    NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
                            .getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
                    return _npi != null && _npi.getGameType() == GameType.CREATIVE;
                }
                return false;
            }
        }.checkGamemode(entity))) {

            if (entity instanceof LivingEntity)
                ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 4800, (int) 0));
        } else {
            if (entity instanceof LivingEntity)
                ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 4800, (int) 0));
        }
    }
}