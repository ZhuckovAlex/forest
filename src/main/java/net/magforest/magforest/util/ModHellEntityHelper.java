package net.magforest.magforest.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;



public class ModHellEntityHelper {

    public static boolean isHellEntity(Entity entity){
        EntityType type = entity.getType();
        if(type == EntityType.ENDERMAN||
        type == EntityType.GHAST||
        type == EntityType.WITHER_SKELETON||
        type == EntityType.MAGMA_CUBE||
        type == EntityType.BLAZE)
            return true;
        return false;

    }
}
