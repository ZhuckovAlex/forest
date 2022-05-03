package net.magforest.magforest.intigration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.magforest.magforest.data.recipes.LightRodRecipe;
import net.magforest.magforest.data.recipes.ModLightningRodRecipeTypes;
import net.magforest.magforest.magforest;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class MagforestJei implements IModPlugin
{

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(magforest.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new LightingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().world).getRecipeManager();
        registration.addRecipes(rm.getRecipesForType(ModLightningRodRecipeTypes.LIGHTING_RECIPE).stream()
                        .filter(r -> r instanceof LightRodRecipe).collect(Collectors.toList()),
                LightingRecipeCategory.UID);
    }

}
