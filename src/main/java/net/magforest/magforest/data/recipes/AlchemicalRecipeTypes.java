package net.magforest.magforest.data.recipes;

import net.magforest.magforest.magforest;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlchemicalRecipeTypes
{
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, magforest.MOD_ID);

    public static final RegistryObject<AlchemicalRecipe.Serializer> ALCHEMY_SERIALIZER
            = RECIPE_SERIALIZER.register("alchemical", AlchemicalRecipe.Serializer::new);

    public static IRecipeType<AlchemicalRecipe> ALCHEMY_RECIPE
            = new AlchemicalRecipe.AlchemicalRecipeType();

    public static void register(IEventBus eventBus){
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, AlchemicalRecipe.TYPE_ID, ALCHEMY_RECIPE);
    }
}
