package net.magforest.magforest.entity.render;

import net.magforest.magforest.entity.custom.MoonMothEntity;
import net.magforest.magforest.entity.model.MoonMothModel;
import net.magforest.magforest.magforest;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MoonMothRender extends MobRenderer<MoonMothEntity, MoonMothModel<MoonMothEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(magforest.MOD_ID, "textures/entity/moon_moth.png");

    public MoonMothRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MoonMothModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(MoonMothEntity entity) {
        return TEXTURE;
    }
}