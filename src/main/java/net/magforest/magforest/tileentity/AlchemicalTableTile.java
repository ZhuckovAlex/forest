package net.magforest.magforest.tileentity;

import net.magforest.magforest.data.recipes.AlchemicalRecipe;
import net.magforest.magforest.data.recipes.AlchemicalRecipeTypes;
import net.magforest.magforest.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;
import java.util.Stack;

public class AlchemicalTableTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(()-> itemHandler);

    public AlchemicalTableTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public AlchemicalTableTile(){
        this(ModTileEntities.ALCHEMICAL_TABLE_TILE.get());
    }
    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("Inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("Inv", itemHandler.serializeNBT());
        return super.write(compound);
    }
    private ItemStackHandler createHandler(){
        return new ItemStackHandler(9){
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot) {
                    case 6: return stack.getItem() == ModItems.ALCHEMICAL_INFUSION.get()
                            ||
                            stack.getItem() == ModItems.ENTROPY_POTION.get();
                    case 7: return stack.getItem() == ModItems.ALCHEMICAL_INFUSION.get()
                            ||
                            stack.getItem() == ModItems.ENTROPY_POTION.get();
                    default:
                        return true;
                }
            }


            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)){
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }


    public void craft(){
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }

        Optional<AlchemicalRecipe> recipe = world.getRecipeManager()
                .getRecipe(AlchemicalRecipeTypes.ALCHEMY_RECIPE, inv, world);

        recipe.ifPresent(iRecipe ->{
            ItemStack output = iRecipe.getRecipeOutput();
            craftTheItem(output);
            markDirty();
        });
    }
    private void craftTheItem(ItemStack output) {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.extractItem(2, 1, false);
        itemHandler.extractItem(3, 1, false);
        itemHandler.extractItem(4, 1, false);
        itemHandler.extractItem(5, 1, false);
        itemHandler.getStackInSlot(6).attemptDamageItem(1, new Random(),null);
        itemHandler.getStackInSlot(7).attemptDamageItem(1, new Random(),null);
        itemHandler.insertItem(8, output, false);

        if (itemHandler instanceof IItemHandlerModifiable) {
            ItemStack _stk = itemHandler.getStackInSlot(7).copy();
            if (_stk.attemptDamageItem(0, new Random(), null)) {
                _stk.shrink(1);
            }
            ((IItemHandlerModifiable) itemHandler).setStackInSlot(7, _stk);
        }
        if (itemHandler instanceof IItemHandlerModifiable) {
            ItemStack _stk = itemHandler.getStackInSlot(6).copy();
            if (_stk.attemptDamageItem(0, new Random(), null)) {
                _stk.shrink(1);
            }
            ((IItemHandlerModifiable) itemHandler).setStackInSlot(6, _stk);
        }
}

    @Override
    public void tick() {
        if(world.isRemote)
            return;
        craft();
    }
}