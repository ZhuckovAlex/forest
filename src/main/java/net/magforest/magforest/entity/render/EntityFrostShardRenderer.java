package net.magforest.magforest.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.magforest.magforest.entity.projectile.EntityEmber;
import net.magforest.magforest.entity.projectile.EntityFrostShard;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.TippedArrowRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import org.lwjgl.opengl.GL11;

public class EntityFrostShardRenderer extends EntityRenderer<EntityFrostShard> {

    public EntityFrostShardRenderer(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }
    public static final ResourceLocation aqua_texture = new ResourceLocation(magforest.MOD_ID, "textures/misc/particles.png");

    public void render(EntityFrostShard entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)  {

        Minecraft mc = Minecraft.getInstance();
        matrixStackIn.push();
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(this.getEntityTexture(entityIn),false));
        MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        float f2 = (float)(1 + 5) / 8.0F;
        float f3 = f2 + 0.125F;
        float f4 = 0.875F;


        float f5 = f4 + 0.125F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.5F;

        float particleScale = 0.25F;
        matrixStackIn.scale(particleScale, particleScale, particleScale);
        matrixStackIn.rotate( Vector3f.YP.rotationDegrees(180- MathHelper.lerp(partialTicks, mc.player.prevRotationYaw, mc.player.rotationYaw)));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(-MathHelper.lerp(partialTicks, mc.player.prevRotationPitch, mc.player.rotationPitch)));
        drawVertex(matrix4f, matrix3f, ivertexbuilder,(-f7), (-f8), 0.0F,f2,f5,0,1,0, 220);
        drawVertex(matrix4f, matrix3f, ivertexbuilder,(f6 - f7), (-f8), 0.0F,f3,f5,0,1,0,220);
        drawVertex(matrix4f, matrix3f, ivertexbuilder,(f6 - f7), (1.0F - f8), 0.0F,f3,f4,0,1,0, 220);
        drawVertex(matrix4f, matrix3f, ivertexbuilder,(-f7), (1.0F - f8), 0.0F,f2,f4,0,1,0, 220);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    public void drawVertex(Matrix4f matrix, Matrix3f normals, IVertexBuilder vertexBuilder, float offsetX, float offsetY, float offsetZ, float textureU, float textureV, float normalX, float normalY, float normalZ, int packedLightIn) {
        vertexBuilder.pos(matrix, (float)offsetX, (float)offsetY, (float)offsetZ).color(1.0F, 1.0F, 1.0F, 0.9F).tex(textureU, textureV).overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLightIn).normal(normals, (float)normalX, (float)normalY, (float)normalZ).endVertex();
    }

    public ResourceLocation getEntityTexture(EntityFrostShard entity) {
        return aqua_texture;
    }

}

