package net.magforest.magforest.events;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import net.magforest.magforest.events.packets.PacketFocusChangeToServer;
import net.magforest.magforest.item.ItemFocus;
import net.magforest.magforest.item.ItemWand;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.item.aspect.Aspect;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;

import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
public class REHWandHandler {

    static float radialHudScale = 0.0F;
    TreeMap<String, Integer> foci = new TreeMap();
    HashMap<String, ItemStack> fociItem = new HashMap();
    HashMap<String, Boolean> fociHover = new HashMap();
    HashMap<String, Float> fociScale = new HashMap();
    long lastTime = 0L;
    boolean lastState = false;

    public void defocus(Minecraft mc){
        mc.gameSettings.pauseOnLostFocus = false;
        mc.setGameFocused(false);
    }

    public void focus(Minecraft mc){
        mc.setGameFocused(true);
        mc.gameSettings.pauseOnLostFocus = true;
    }
    public void manabar(Minecraft mc, long time, RenderGameOverlayEvent event) {
        if(mc.player.getHeldItem(Hand.MAIN_HAND) != ItemStack.EMPTY && mc.player.getHeldItem(Hand.MAIN_HAND).getItem() instanceof ItemWand){
            ItemStack stack = mc.player.getHeldItem(Hand.MAIN_HAND);
            ItemWand wand = (ItemWand)stack.getItem();
            //mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID, "textures/gui/manabar.png"));

            GL11.glPushMatrix();
            mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID, "textures/gui/manabar.png"));
            float red = 1F;
            float green = 1F;
            float blue = 1F;
            float opacity = 1F;
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder worldRenderer = tessellator.getBuffer();
            worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR_TEX_LIGHTMAP);

            GL11.glScalef(2.0F,2.0F,42.0F);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            float x = 2;
            float y = 2;

            worldRenderer.addVertex((x + 0), (y + 5), 0,red,green,blue,opacity, 0.08F, 0.545F, 1, 220,1,1,1);
            worldRenderer.addVertex((x + 48), (y + 5), 0,red,green,blue,opacity, 0.92F, 0.545F, 1, 220,1,1,1);
            worldRenderer.addVertex((x + 48), (y + 0), 0, red,green,blue,opacity,0.92F, 0.455F,1, 220,1,1,1);
            worldRenderer.addVertex((x + 0), (y + 0), 0,red,green,blue,opacity, 0.08F, 0.455F, 1, 220,1,1,1);

            //magforest.LOGGER.debug(((float)wand.getVis(stack,Aspect.FIRE)/(float)wand.getMaxVis(stack)));
            float mnoz = (((float)wand.getVis(stack,Aspect.FIRE))/((float)wand.getMaxVis(stack)));
            worldRenderer.addVertex((x + 0), (y + 5), 0,red,green,blue,opacity, 0.08F, 0.295F, 1, 220,1,1,1);
            worldRenderer.addVertex((x + 48*mnoz), (y + 5), 0,red,green,blue,opacity, 0.08F+0.84F*mnoz, 0.295F, 1, 220,1,1,1);
            worldRenderer.addVertex((x + 48*mnoz), (y + 0), 0, red,green,blue,opacity,0.08F+0.84F*mnoz, 0.205F,1, 220,1,1,1);
            worldRenderer.addVertex((x + 0), (y + 0), 0,red,green,blue,opacity, 0.08F, 0.205F, 1, 220,1,1,1);

            tessellator.draw();
            GL11.glPopMatrix();
        }
    }

    public void handleFociRadial(Minecraft mc, long time, RenderGameOverlayEvent event) {
        if(ClientEvents.radialActive || radialHudScale > 0.0F) {
            mc.gameSettings.pauseOnLostFocus = false;
            if(ClientEvents.radialActive) {
                if(mc.currentScreen != null) {
                    ClientEvents.radialActive = false;
                    ClientEvents.radialLock = true;
                    focus(mc);
                    defocus(mc);
                    return;
                }

                if(radialHudScale == 0.0F) {
                    this.foci.clear();
                    this.fociItem.clear();
                    this.fociHover.clear();
                    this.fociScale.clear();
                    ItemStack key;

                    int a;
                    for(a = 0; a < 36; ++a) {
                        key = mc.player.inventory.mainInventory.get(a);
                        if(key != null && key.getItem() instanceof ItemFocus) {
                            this.foci.put(((ItemFocus)key.getItem()).getSortingHelper(key), Integer.valueOf(a));
                            this.fociItem.put(((ItemFocus)key.getItem()).getSortingHelper(key), key.copy());
                            this.fociScale.put(((ItemFocus)key.getItem()).getSortingHelper(key), Float.valueOf(1.0F));
                            this.fociHover.put(((ItemFocus)key.getItem()).getSortingHelper(key), Boolean.valueOf(false));
                        }
                    }


                    if(this.foci.size() > 0 && mc.isGameFocused()) {
                        defocus(mc);
                        mc.mouseHelper.ungrabMouse();
                    }
                }
            } else if(mc.currentScreen == null && this.lastState) {
//                if(/*Display.isActive() &&*/ !mc.isGameFocused()) {
//                    //mc.setGameFocused(true);
//                    mc.mouseHelper.grabMouse();
//                }
                if(!mc.isGameFocused()) {
                    mc.setGameFocused(true);

                mc.mouseHelper.grabMouse();
                    mc.gameSettings.pauseOnLostFocus = true;
                }
                this.lastState = false;
            }

            this.renderFocusRadialHUD(event.getWindow().getScaledWidth(), event.getWindow().getScaledHeight(), time, event.getPartialTicks());
            if(time > this.lastTime) {
                Iterator var13 = this.fociHover.keySet().iterator();

                while(var13.hasNext()) {
                    String var14 = (String)var13.next();
                    if(((Boolean)this.fociHover.get(var14)).booleanValue()) {
                        //select on hover s
                        if(!ClientEvents.radialActive && !ClientEvents.radialLock) {
                            PacketHandler.PACKET_HANDLER.sendToServer(new PacketFocusChangeToServer(mc.player, var14));
                            ClientEvents.radialLock = true;
                        }
                        //select on hover e

                        if(((Float)this.fociScale.get(var14)).floatValue() < 1.3F) {
                            this.fociScale.put(var14, Float.valueOf(((Float)this.fociScale.get(var14)).floatValue() + 0.025F));
                        }
                    } else if(((Float)this.fociScale.get(var14)).floatValue() > 1.0F) {
                        this.fociScale.put(var14, Float.valueOf(((Float)this.fociScale.get(var14)).floatValue() - 0.025F));
                    }
                }


                if (radialHudScale == 0.05F){
                    mc.gameSettings.pauseOnLostFocus = true;
                }

                if(!ClientEvents.radialActive) {
                    radialHudScale -= 0.05F;
                } else if(ClientEvents.radialActive && radialHudScale < 1.0F) {
                    radialHudScale += 0.05F;
                }

                if(radialHudScale > 1.0F) {
                    radialHudScale = 1.0F;
                }

                if(radialHudScale < 0.0F) {
                    radialHudScale = 0.0F;
                    ClientEvents.radialLock = false;
                }

                this.lastTime = time + 5L;
                this.lastState = ClientEvents.radialActive;
            }
        }


    }


    private void renderFocusRadialHUD(double sw, double sh, long time, float partialTicks) {
        ItemRenderer ri = Minecraft.getInstance().getItemRenderer();
        Minecraft mc = Minecraft.getInstance();
        if(mc.player.getHeldItem(Hand.MAIN_HAND) != null && mc.player.getHeldItem(Hand.MAIN_HAND).getItem() instanceof ItemWand) {
            ItemWand wand = (ItemWand)mc.player.getHeldItem(Hand.MAIN_HAND).getItem();
            ItemFocus focus = wand.getFocus(mc.player.getHeldItem(Hand.MAIN_HAND));
            int i = (int)((double)mc.mouseHelper.getMouseX() * sw / (double)mc.getMainWindow().getWidth());
            int j = (int)(sh - (double)mc.mouseHelper.getMouseY() * sh / (double)mc.getMainWindow().getHeight() - 1.0D);
            int k = mc.mouseHelper.isLeftDown()? 0: -1;
            if(this.fociItem.size() != 0) {
                GL11.glPushMatrix();
                GL11.glClear(256);
                GL11.glMatrixMode(5889);
                GL11.glLoadIdentity();
                GL11.glOrtho(0.0D, sw, sh, 0.0D, 1000.0D, 3000.0D);
                GL11.glMatrixMode(5888);
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
                GL11.glDisable(2929);
                GL11.glDepthMask(false);
                GL11.glPushMatrix();
                GL11.glTranslated(sw / 2.0D, sh / 2.0D, 0.0D);
                ItemStack tt = null;
                float width = 16.0F + (float)this.fociItem.size() * 2.5F;
                mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID, "textures/misc/radial.png"));
                GL11.glPushMatrix();
                GL11.glRotatef(partialTicks + (float)(mc.player.ticksExisted % 720) / 2.0F, 0.0F, 0.0F, 1.0F);
                GL11.glAlphaFunc(516, 0.003921569F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                this.renderQuadCenteredFromTexture(width * 2.75F * radialHudScale, 0.5F, 0.5F, 0.5F, 200, 771, 0.5F);
                GL11.glDisable(3042);
                GL11.glAlphaFunc(516, 0.1F);
                GL11.glPopMatrix();
                mc.textureManager.bindTexture(new ResourceLocation(magforest.MOD_ID, "textures/misc/radial2.png"));
                GL11.glPushMatrix();
                GL11.glRotatef(-(partialTicks + (float)(mc.player.ticksExisted % 720) / 2.0F), 0.0F, 0.0F, 1.0F);
                GL11.glAlphaFunc(516, 0.003921569F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                this.renderQuadCenteredFromTexture(width * 2.75F * radialHudScale, 0.5F, 0.5F, 0.5F, 200, 771, 0.5F);
                GL11.glDisable(3042);
                GL11.glAlphaFunc(516, 0.1F);
                GL11.glPopMatrix();
                if(focus != null) {
                    GL11.glPushMatrix();
                    GL11.glEnable('\u803a');
                    RenderHelper.enableStandardItemLighting();
                    ItemStack currentRot = wand.getFocusItem(mc.player.getHeldItem(Hand.MAIN_HAND)).copy();
                    currentRot.setTag(null);
                    ri.renderItemIntoGUI( currentRot, -8, -8);
                    RenderHelper.disableStandardItemLighting();
                    GL11.glDisable('\u803a');
                    GL11.glPopMatrix();
                    int pieSlice = (int)((double)i - sw / 2.0D);
                    int key = (int)((double)j - sh / 2.0D);
                    if(pieSlice >= -10 && pieSlice <= 10 && key >= -10 && key <= 10) {
                        tt = wand.getFocusItem(mc.player.getHeldItem(Hand.MAIN_HAND));
                    }
                }

                GL11.glScaled((double)radialHudScale, (double)radialHudScale, (double)radialHudScale);
                float var28 = -90.0F * radialHudScale;
                float var29 = 360.0F / (float)this.fociItem.size();
                String var30 = (String)this.foci.firstKey();

                for(int a = 0; a < this.fociItem.size(); ++a) {
                    double xx = (double)(MathHelper.cos(var28 / 180.0F * 3.1415927F) * width);
                    double yy = (double)(MathHelper.sin(var28 / 180.0F * 3.1415927F) * width);
                    var28 += var29;
                    GL11.glPushMatrix();
                    GL11.glTranslated(-xx, yy, 100.0D);
                    GL11.glScalef(((Float)this.fociScale.get(var30)).floatValue(), ((Float)this.fociScale.get(var30)).floatValue(), ((Float)this.fociScale.get(var30)).floatValue());
                    GL11.glEnable('\u803a');
                    RenderHelper.enableStandardItemLighting();
                    ItemStack item = ((ItemStack)this.fociItem.get(var30)).copy();
                    item.setTag(null);
                    ri.renderItemIntoGUI( item, -8, -8);
                    RenderHelper.disableStandardItemLighting();
                    GL11.glDisable('\u803a');
                    GL11.glPopMatrix();
                    if(!ClientEvents.radialLock && ClientEvents.radialActive) {
                        int mx = (int)((double)i - sw/2.0D  + xx);
                        int my = (int)((double)j - sh/2.0D  + yy);
                        if(mx >= -10 && mx <= 10 && my >= -10 && my <= 10) {
                            this.fociHover.put(var30, Boolean.valueOf(true));
                            tt = (ItemStack)this.fociItem.get(var30);
                            if(k == 0) {
                                ClientEvents.radialActive = false;
                                ClientEvents.radialLock = true;
                                mc.setGameFocused(true);
                                mc.mouseHelper.grabMouse();
                                PacketHandler.PACKET_HANDLER.sendToServer(new PacketFocusChangeToServer(mc.player, var30));
                                break;
                            }
                        } else {
                            this.fociHover.put(var30, Boolean.valueOf(false));
                        }
                    }

                    var30 = (String)this.foci.higherKey(var30);
                }

                GL11.glPopMatrix();
                if(tt != null) {
                    //tooltip на будущее можно подключить
                    //UtilsFX.drawCustomTooltip(mc.currentScreen, ri, mc.fontRenderer, tt.getTooltip(mc.player, mc.gameSettings.advancedItemTooltips), -4, 20, 11);
                }

                GL11.glDepthMask(true);
                GL11.glEnable(2929);
                GL11.glDisable(3042);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glPopMatrix();
            }
        }
    }



    public static void renderQuadCenteredFromTexture(float scale, float red, float green, float blue, int brightness, int blend, float opacity) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldRenderer = tessellator.getBuffer();
        worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR_TEX_LIGHTMAP);
        GL11.glScalef(scale, scale, scale);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, blend);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, opacity);
        if(brightness > 0) {
            tessellator.getBuffer().lightmap(brightness);
        }
        worldRenderer.color(red, green, blue, opacity);
        worldRenderer.addVertex(-0.5f, 0.5F, 0.0F,red,green,blue,opacity,0,1, 1, 1,1,1,1);
        worldRenderer.addVertex(0.5f, 0.5F, 1.0F,red,green,blue,opacity,1,1, 1, 1,1,1,1);
        worldRenderer.addVertex(0.5f, -0.5F, 1.0F,red,green,blue,opacity,1,0, 1, 1,1,1,1);
        worldRenderer.addVertex(-0.5f, -0.5F, 0.0F,red,green,blue,opacity,0,0, 1, 1,1,1,1);
        tessellator.draw();
        GL11.glDisable(3042);
    }










}

