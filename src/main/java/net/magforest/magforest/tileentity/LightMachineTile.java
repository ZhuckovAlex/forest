package net.magforest.magforest.tileentity;

import net.magforest.magforest.data.recipes.LightRodRecipe;
import net.magforest.magforest.data.recipes.ModLightningRodRecipeTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class LightMachineTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(()-> itemHandler);

    public LightMachineTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public LightMachineTile(){
        this(ModTileEntities.MOON_TEAR_LIGHTING_TILE.get());
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
        return new ItemStackHandler(2){
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }
            @Override
            public int getSlotLimit(int slot) {
                return 1;
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

    private void strikeLighting(){
        if(!this.world.isRemote()){
            EntityType.LIGHTNING_BOLT.spawn((ServerWorld)world, null, null,
                    pos, SpawnReason.TRIGGERED, true, true);
        }
    }

    public void craft(){
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }

        Optional<LightRodRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModLightningRodRecipeTypes.LIGHTING_RECIPE, inv, world);

        recipe.ifPresent(iRecipe ->{

            ItemStack output = iRecipe.getRecipeOutput();

            if(iRecipe.getWeather().equals(LightRodRecipe.Weather.CLEAR) &&
                    !world.isRaining()) {
                craftTheItem(output);
            }

            if(iRecipe.getWeather().equals(LightRodRecipe.Weather.RAIN) &&
                    world.isRaining()) {
                craftTheItem(output);
            }

            if(iRecipe.getWeather().equals(LightRodRecipe.Weather.THUNDERING) &&
                    world.isThundering()) {
                strikeLighting();
                craftTheItem(output);
            }

            markDirty();
        });
    }

    private void craftTheItem(ItemStack output) {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.insertItem(1, output, false);
    }

    @Override
    public void tick() {
        if(world.isRemote)
            return;
        craft();
    }
}
