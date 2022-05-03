package net.magforest.magforest.intigration.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.data.recipes.LightRodRecipe;
import net.magforest.magforest.magforest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class LightingRecipeCategory implements IRecipeCategory<LightRodRecipe>
{

    public final static ResourceLocation UID = new ResourceLocation(magforest.MOD_ID, "lighting");
    public final static ResourceLocation TEXTURE = new ResourceLocation(magforest.MOD_ID, "textures/gui/lighting_rod_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableStatic lightningBolt;

    public LightingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.MOON_TEAR_LIGHTING_ROD.get()));
        lightningBolt = helper.createDrawable(TEXTURE,176,0,13,17);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends LightRodRecipe> getRecipeClass() {
        return LightRodRecipe.class;
    }

    @Override
    public String getTitle() {
        return ModBlocks.MOON_TEAR_LIGHTING_ROD.get().getTranslatedName().getString();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(LightRodRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, LightRodRecipe recipe, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0,true,79,30);
        recipeLayout.getItemStacks().init(1,true,79,52);
        recipeLayout.getItemStacks().init(2,false,102,42);
        recipeLayout.getItemStacks().set(ingredients);
    }
    @Override
    public void draw(LightRodRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        if(recipe.getWeather() == LightRodRecipe.Weather.THUNDERING) {
            this.lightningBolt.draw(matrixStack, 82, 9);
        }
}
}
