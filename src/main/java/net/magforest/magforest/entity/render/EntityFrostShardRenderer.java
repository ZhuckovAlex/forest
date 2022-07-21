package net.magforest.magforest.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.magforest.magforest.entity.projectile.EntityEmber;
import net.magforest.magforest.entity.projectile.EntityFrostShard;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.TippedArrowRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class EntityFrostShardRenderer extends EntityRenderer<EntityFrostShard> {

    public EntityFrostShardRenderer(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }


    public void render(EntityFrostShard entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)  {

        magforest.LOGGER.debug("EntityFrostShardRenderer");

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }


    public ResourceLocation getEntityTexture(EntityFrostShard entity) {
        return TippedArrowRenderer.RES_ARROW;
    }

}

