package net.magforest.magforest.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.magforest;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Objects;

public class AlchemicalRecipe implements IAlchemical
{
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public AlchemicalRecipe(ResourceLocation id, ItemStack output,
                            NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }
    @Override
    public boolean matches(IInventory inv, World worldIn) {
        // Checks for correct focus (Glass Pane)
        if((recipeItems.get(0).test(inv.getStackInSlot(0)))
                &&
                (recipeItems.get(1).test(inv.getStackInSlot(1)))
                &&
                (recipeItems.get(2).test(inv.getStackInSlot(2)))
                &&
                (recipeItems.get(3).test(inv.getStackInSlot(3)))
                &&
                (recipeItems.get(4).test(inv.getStackInSlot(4)))
                &&
                (recipeItems.get(5).test(inv.getStackInSlot(5)))
                &&
                (recipeItems.get(6).test(inv.getStackInSlot(6)))
                &&
                (recipeItems.get(7).test(inv.getStackInSlot(7))))
        {
            return recipeItems.get(8).test(inv.getStackInSlot(8));
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }
    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }


    @Override
    public ResourceLocation getId() {
        return id;
    }

    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.ALCHEMY_TABLE.get());
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return AlchemicalRecipeTypes.ALCHEMY_SERIALIZER.get();
    }

    public static class AlchemicalRecipeType implements IRecipeType<AlchemicalRecipe> {
        @Override
        public String toString() {
            return AlchemicalRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<AlchemicalRecipe> {

        @Override
        public AlchemicalRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "output"));

            JsonArray ingredients = JSONUtils.getJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(9, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.deserialize(ingredients.get(i)));
            }

            return new AlchemicalRecipe(recipeId, output,
                    inputs);
        }

        @Nullable
        @Override
        public AlchemicalRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.read(buffer));
            }

            ItemStack output = buffer.readItemStack();
            return new AlchemicalRecipe(recipeId, output,
                    inputs);
        }

        @Override
        public void write(PacketBuffer buffer, AlchemicalRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buffer);
            }
            buffer.writeItemStack(recipe.getRecipeOutput(), false);
        }
    }

}
