package net.magforest.magforest.data.recipes;

import net.magforest.magforest.magforest;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLightningRodRecipeTypes
{
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, magforest.MOD_ID);

    public static final RegistryObject<LightRodRecipe.Serializer> LIGHTING_SERIALIZER
            = RECIPE_SERIALIZER.register("lighting", LightRodRecipe.Serializer::new);

    public static IRecipeType<LightRodRecipe> LIGHTING_RECIPE
            = new LightRodRecipe.LightningRecipeType();

    public static void register(IEventBus eventBus){
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, LightRodRecipe.TYPE_ID, LIGHTING_RECIPE);
    }
}
