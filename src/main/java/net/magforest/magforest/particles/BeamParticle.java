package net.magforest.magforest.particles;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

import java.awt.*;
public class BeamParticle extends Particle
{
    public int particle = 16;
    PlayerEntity player = null;
    private double offset = 0.0D;
    private float length = 0.0F;
    private float rotYaw = 0.0F;
    private float rotPitch = 0.0F;
    private float prevYaw = 0.0F;
    private float prevPitch = 0.0F;
    private double tX = 0.0D;
    private double tY = 0.0D;
    private double tZ = 0.0D;
    private double ptX = 0.0D;
    private double ptY = 0.0D;
    private double ptZ = 0.0D;
    private int type = 0;
    private float endMod = 1.0F;
    private boolean reverse = false;
    private boolean pulse = true;
    private int rotationspeed = 5;
    private float prevSize = 0.0F;
    public int impact;
    public BeamParticle(ClientWorld world, double x, double y, double z,
                        double velocityX, double velocityY, double velocityZ)
    {
        super(world, x, y, z, velocityX, velocityY, velocityZ);


        maxAge = 100;

        final float ALPHA_VALUE = 1.0F;
        this.particleAlpha = ALPHA_VALUE;


        motionX = velocityX;
        motionY = velocityY;
        motionZ = velocityZ;
        this.canCollide = true;
    }

    public BeamParticle(ClientWorld world, PlayerEntity player, double tx, double ty, double tz, Color color, int age)
    {
        super(world, tx, ty, tz, 0, 0,0);
        if(player.getEntityId() != Minecraft.getInstance().renderViewEntity.getEntityId()) {
            this.offset = (double)(player.getHeight() / 2.0F) + 0.25D;
        }
        setColor(color.getRed()/255.0F, color.getGreen()/255.0F, color.getBlue()/255.0F);
        this.player = player;
        this.setSize(0.02F, 0.02F);
        //this.noClip = true;
        super.motionX = 0.0D;
        super.motionY = 0.0D;
        super.motionZ = 0.0D;
        this.tX = tx;
        this.tY = ty;
        this.tZ = tz;
        float xd = (float)(player.getPosX() - this.tX);
        float yd = (float)(player.getPosY() + this.offset - this.tY);
        float zd = (float)(player.getPosZ() - this.tZ);
        this.length = MathHelper.sqrt(xd * xd + yd * yd + zd * zd);
        double var7 = (double)MathHelper.sqrt((double)(xd * xd + zd * zd));
        this.rotYaw = (float)(Math.atan2((double)xd, (double)zd) * 180.0D / 3.141592653589793D);
        this.rotPitch = (float)(Math.atan2((double)yd, var7) * 180.0D / 3.141592653589793D);
        this.prevYaw = this.rotYaw;
        this.prevPitch = this.rotPitch;
        super.setMaxAge(age);
        Entity renderentity = Minecraft.getInstance().renderViewEntity;
        byte visibleDistance = 50;
        if(!Minecraft.getInstance().isFancyGraphicsEnabled()) {
            visibleDistance = 25;
        }
        if(renderentity.getDistance(player) > (double)visibleDistance) {
            super.setMaxAge( 0);
        }
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
    public void setEndMod(float endMod) {
        this.endMod = endMod;
    }
    public void setType(int type) {
        this.type = type;
    }

    public void updateBeam(double x, double y, double z) {
        this.tX = x;
        this.tY = y;
        this.tZ = z;
        while( super.maxAge - super.age < 4) {
            setMaxAge(getMaxAge()+1);
        }

    }
    public void renderParticle(IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
        if(this.player.getEntityId() != Minecraft.getInstance().player.getEntityId())
            return;
        double interpPosX = this.prevPosX + (this.posX - this.prevPosX) * (float)partialTicks;
        double interpPosY = this.prevPosY + (this.posY - this.prevPosY) * (float)partialTicks;
        double interpPosZ = this.prevPosZ + (this.posZ - this.prevPosZ) * (float)partialTicks;
        //tessellator.draw();
        //float f = partialTicks;
        Tessellator tessellator = Tessellator.getInstance();
        Minecraft mc = Minecraft.getInstance();
        BufferBuilder builder = (BufferBuilder)buffer;
        GL11.glPushMatrix();
        float var9 = 1.0F;
        float slide = (float)Minecraft.getInstance().player.ticksExisted;
        float rot = (float)(super.world.getGameTime() % (long)(360 / this.rotationspeed) * (long)this.rotationspeed) + (float)this.rotationspeed * partialTicks;
        float size = 1.0F;
        if(this.pulse) {
            size = Math.min((float)super.age / 4.0F, 1.0F);
            size = (float)((double)this.prevSize + (double)(size - this.prevSize) * (double)partialTicks);
        }

        float op = 0.4F;
        if(this.pulse && super.maxAge - super.age <= 4) {
            op = 0.4F - (float)(4 - (super.maxAge - super.age)) * 0.1F;
        }

        switch(this.type) {
            case 1:
                mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID,"textures/misc/beam1.png"));
                break;
            case 2:
                mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID,"textures/misc/beam2.png"));
                break;
            case 3:
                mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID,"textures/misc/beam3.png"));
                break;
            default:
                mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID,"textures/misc/beam.png"));
        }

        GL11.glTexParameterf(3553, 10242, 10497.0F);
        GL11.glTexParameterf(3553, 10243, 10497.0F);
        GL11.glDisable(2884);
        float var11 = slide + partialTicks;
        if(this.reverse) {
            var11 *= -1.0F;
        }

        float var12 = -var11 * 0.2F - (float)MathHelper.floor(-var11 * 0.1F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glDepthMask(false);
        double prex = this.player.prevPosX;
        double prey = this.player.prevPosY + this.offset;
        double prez = this.player.prevPosZ;
        double px = this.player.getPosX();
        double py = this.player.getPosY() + this.offset;
        double pz = this.player.getPosZ();
        prex -= (double)(MathHelper.cos(this.player.prevRotationYaw / 180.0F * 3.141593F) * 0.066F);
        prey -= 0.06D;
        prez -= (double)(MathHelper.sin(this.player.prevRotationYaw / 180.0F * 3.141593F) * 0.04F);
        Vector3d vec3d = this.player.getLook(1.0F);
        prex += vec3d.x * 0.3D;
        prey += vec3d.y * 0.3D;
        prez += vec3d.z * 0.3D;
        px -= (double)(MathHelper.cos(this.player.rotationYaw / 180.0F * 3.141593F) * 0.066F);
        py -= 0.06D;
        pz -= (double)(MathHelper.sin(this.player.rotationYaw / 180.0F * 3.141593F) * 0.04F);
        vec3d = this.player.getLook(1.0F);
        px += vec3d.x * 0.3D;
        py += vec3d.y * 0.3D;
        pz += vec3d.z * 0.3D;
        float xx = (float)(prex + (px - prex) * (double)partialTicks - interpPosX);
        float yy = (float)(prey + (py - prey) * (double)partialTicks - interpPosY);
        float zz = (float)(prez + (pz - prez) * (double)partialTicks - interpPosZ);
        GL11.glTranslated(xx, yy,zz);
        float ry = (float)((double)this.prevYaw + (double)(this.rotYaw - this.prevYaw) * (double)partialTicks);
        float rp = (float)((double)this.prevPitch + (double)(this.rotPitch - this.prevPitch) * (double)partialTicks);
        GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(180.0F + ry, 0.0F, 0.0F, -1.0F);

        GL11.glRotatef(rp, 1.0F, 0.0F, 0.0F);
        double var44 = -0.15F * (double)size;
        double var17 = 0.15F * (double)size;
        double var44b = -0.15F * (double)size * (double)this.endMod;
        double var17b = 0.15F * (double)size * (double)this.endMod;
        GL11.glRotatef(rot, 0.0F, 1.0F, 0.0F);
        for(int t = 0; t < 3; ++t) {
            double var29 = (double)(this.length * size * var9);
            double var31 = 0.0F;
            double var33 = 1.0F;
            double var35 = (double)(-1.0F + var12 + (float)t / 3.0F);
            double var37 = (double)(this.length * size * var9) + var35;
            GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);

            builder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR_TEX_LIGHTMAP);
            builder.addVertex((float) var44b, (float) var29, 0.0F,super.particleRed,super.particleGreen,super.particleBlue,op,(float)var33,(float)var37, OverlayTexture.NO_OVERLAY, 200,0,1,0);
            builder.addVertex((float) var44, 0.0F, 0.0F,super.particleRed,super.particleGreen,super.particleBlue,op,(float)var33,(float)var35, OverlayTexture.NO_OVERLAY, 200,0,1,0);
            builder.addVertex((float) var17, 0.0F, 0.0F,super.particleRed,super.particleGreen,super.particleBlue,op,(float)var31,(float)var35, OverlayTexture.NO_OVERLAY, 200,0,1,0);
            builder.addVertex((float) var17b, (float) var29, 0.0F,super.particleRed,super.particleGreen,super.particleBlue,op,(float)var31,(float)var37, OverlayTexture.NO_OVERLAY, 200,0,1,0);
            tessellator.draw();
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDepthMask(true);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        if(this.impact > 0) {
            //this.renderImpact(tessellator,  buffer, renderInfo,  partialTicks);
        }

        //Minecraft.getMinecraft().renderEngine.bindTexture(UtilsFX.getParticleTexture());
        //tessellator.startDrawingQuads();
        this.prevSize = size;
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.CUSTOM;
    }

    public boolean shouldCull() {
        return false;
    }
    @Override
    public void tick()
    {
        super.prevPosX = this.player.getPosX();
        super.prevPosY = this.player.getPosY() + this.offset;
        super.prevPosZ = this.player.getPosZ();
        this.ptX = this.tX;
        this.ptY = this.tY;
        this.ptZ = this.tZ;
        super.posX = this.tX;
        super.posY = this.tY;
        super.posZ = this.tZ;
        this.prevYaw = this.rotYaw;
        this.prevPitch = this.rotPitch;
        float xd = (float)(this.player.getPosX() - this.tX);
        float yd = (float)(this.player.getPosY() + this.offset - this.tY);
        float zd = (float)(this.player.getPosZ() - this.tZ);
        this.length = MathHelper.sqrt(xd * xd + yd * yd + zd * zd);
        double var7 = (double)MathHelper.sqrt((double)(xd * xd + zd * zd));
        this.rotYaw = (float)(Math.atan2((double)xd, (double)zd) * 180.0D / 3.141592653589793D);
        this.rotPitch = (float)(Math.atan2((double)yd, var7) * 180.0D / 3.141592653589793D);
        while ( this.rotPitch - this.prevPitch < -180.0F) {
            this.prevPitch -= 360.0F;
        }

        while(this.rotPitch - this.prevPitch >= 180.0F) {
            this.prevPitch += 360.0F;
        }

        while(this.rotYaw - this.prevYaw < -180.0F) {
            this.prevYaw -= 360.0F;
        }

        while(this.rotYaw - this.prevYaw >= 180.0F) {
            this.prevYaw += 360.0F;
        }

        if(this.impact > 0) {
            --this.impact;
        }

        if(super.age++ >= super.maxAge) {
            this.setExpired();
        }
    }


}