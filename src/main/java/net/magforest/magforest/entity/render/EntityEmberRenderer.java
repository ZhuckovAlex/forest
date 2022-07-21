package net.magforest.magforest.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.magforest.magforest.entity.projectile.EntityEmber;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.TippedArrowRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;


public class EntityEmberRenderer extends EntityRenderer<EntityEmber> {

    public EntityEmberRenderer(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }


    public void render(EntityEmber entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)  {
        Minecraft mc = Minecraft.getInstance();
        magforest.LOGGER.debug("EntityEmberRenderer");
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldRenderer = tessellator.getBuffer();
        GL11.glPushMatrix();
        GL11.glTranslated(entityIn.getPosX(), entityIn.getPosY(), entityIn.getPosZ());
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        //UtilsFX.bindTexture(ParticleEngine.particleTexture);
        mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID, "textures/misc/particles.png"));

        int p = (int)(8.0F * ((float)entityIn.ticksExisted / (float)entityIn.duration));
        float f2 = (float)(7 + p) / 16.0F;
        float f3 = f2 + 0.0625F;
        float f4 = 0.5625F;
        float f5 = f4 + 0.0625F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.5F;
        float fc = (float)entityIn.ticksExisted / (float)entityIn.duration;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
        float particleScale = 0.25F + fc;
        GL11.glScalef(particleScale, particleScale, particleScale);
        GL11.glRotatef(180.0F - super.renderManager.getCameraOrientation().getY(), 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-super.renderManager.getCameraOrientation().getX(), 1.0F, 0.0F, 0.0F);
        worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR_TEX_LIGHTMAP);
//        tessellator.setBrightness(220);
//        tessellator.setNormal(0.0F, 1.0F, 0.0F);
//        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 0.9F);
//        tessellator.addVertexWithUV((double)(-f7), (double)(-f8), 0.0D, (double)f2, (double)f5);
//        tessellator.addVertexWithUV((double)(f6 - f7), (double)(-f8), 0.0D, (double)f3, (double)f5);
//        tessellator.addVertexWithUV((double)(f6 - f7), (double)(1.0F - f8), 0.0D, (double)f3, (double)f4);
//        tessellator.addVertexWithUV((double)(-f7), (double)(1.0F - f8), 0.0D, (double)f2, (double)f4);
        worldRenderer.lightmap(220);
        worldRenderer.normal(0.0F, 1.0F, 0.0F);
        worldRenderer.color(1.0F, 1.0F, 1.0F, 0.9F);
        worldRenderer.addVertex((-f7), (-f8), 0.0F,1.0F, 1.0F, 1.0F, 0.9F,f2,f5, 1, 1,1,1,1);
        worldRenderer.addVertex((f6 - f7), (-f8), 0.0F,1.0F, 1.0F, 1.0F, 0.9F,f3,f5, 1, 1,1,1,1);
        worldRenderer.addVertex((f6 - f7), (1.0F - f8), 0.0F,1.0F, 1.0F, 1.0F, 0.9F,f3,f4, 1, 1,1,1,1);
        worldRenderer.addVertex((-f7), (1.0F - f8), 0.0F,1.0F, 1.0F, 1.0F, 0.9F,f2,f4, 1, 1,1,1,1);
        tessellator.draw();
        GL11.glDisable(3042);
        GL11.glDisable('\u803a');
        GL11.glPopMatrix();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }


    public ResourceLocation getEntityTexture(EntityEmber entity) {
        return TippedArrowRenderer.RES_ARROW;
    }
}
