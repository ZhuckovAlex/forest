package net.magforest.magforest.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.magforest.magforest.container.SolarConverterContainer;
import net.magforest.magforest.magforest;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.chunk.ChunkRenderCache;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;

@OnlyIn(Dist.CLIENT)
public class SolarConverterScreen extends ContainerScreen<SolarConverterContainer> {


    public SolarConverterScreen(SolarConverterContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);

    }
    private final ResourceLocation GUI = new ResourceLocation(magforest.MOD_ID,
            "textures/gui/guimagic.png");
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
                super.render(matrixStack, mouseX,mouseY,partialTicks);
        this.renderHoveredTooltip(matrixStack,mouseX,mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0,0, this.xSize, this.ySize);
    }
    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        this.font.drawText(matrixStack, this.title, (float)this.titleX, (float)this.titleY, 4210752);
        this.font.drawText(matrixStack, this.playerInventory.getDisplayName(), (float)this.playerInventoryTitleX, (float)this.playerInventoryTitleY, 4210752);
    }
}
