package net.magforest.magforest.procedures;

import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;




public class AlchemyTableRecipes
{
    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                magforest.LOGGER.warn("Failed to load dependency world for procedure Alchemy!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                magforest.LOGGER.warn("Failed to load dependency x for procedure Alchemy!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                magforest.LOGGER.warn("Failed to load dependency y for procedure Alchemy!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                magforest.LOGGER.warn("Failed to load dependency z for procedure Alchemy!");
            return;
        }
        IWorld world = (IWorld) dependencies.get("world");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        if ((new Object() {
            public ItemStack getItemStack(BlockPos pos, int sltid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).copy());
                    });
                }
                return _retval.get();
            }
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get() && (new Object() {
            public ItemStack getItemStack(BlockPos pos, int sltid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).copy());
                    });
                }
                return _retval.get();
            }
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.FEATHER && (new Object() {
            public ItemStack getItemStack(BlockPos pos, int sltid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).copy());
                    });
                }
                return _retval.get();
            }
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.GLOWSTONE_DUST && (new Object() {
            public ItemStack getItemStack(BlockPos pos, int sltid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).copy());
                    });
                }
                return _retval.get();
            }
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Items.PHANTOM_MEMBRANE && (new Object() {
            public ItemStack getItemStack(BlockPos pos, int sltid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).copy());
                    });
                }
                return _retval.get();
            }
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get() && ((new Object() {
            public ItemStack getItemStack(BlockPos pos, int sltid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).copy());
                    });
                }
                return _retval.get();
            }
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem() || (new Object() {
            public ItemStack getItemStack(BlockPos pos, int sltid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).copy());
                    });
                }
                return _retval.get();
            }
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.WIND_REFLECTION.get().asItem()) && new Object() {
            public int getAmount(IWorld world, BlockPos pos, int sltid) {
                AtomicInteger _retval = new AtomicInteger(0);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).getCount());
                    });
                }
                return _retval.get();
            }
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && new Object() {
            public int getAmount(IWorld world, BlockPos pos, int sltid) {
                AtomicInteger _retval = new AtomicInteger(0);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).getCount());
                    });
                }
                return _retval.get();
            }
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 8 && new Object() {
            public int getAmount(IWorld world, BlockPos pos, int sltid) {
                AtomicInteger _retval = new AtomicInteger(0);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).getCount());
                    });
                }
                return _retval.get();
            }
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 2 && new Object() {
            public int getAmount(IWorld world, BlockPos pos, int sltid) {
                AtomicInteger _retval = new AtomicInteger(0);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).getCount());
                    });
                }
                return _retval.get();
            }
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 2 && new Object() {
            public int getAmount(IWorld world, BlockPos pos, int sltid) {
                AtomicInteger _retval = new AtomicInteger(0);
                TileEntity _ent = world.getTileEntity(pos);
                if (_ent != null) {
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        _retval.set(capability.getStackInSlot(sltid).getCount());
                    });
                }
                return _retval.get();
            }
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (8)) <= 63) {
            if (world instanceof World && !world.isRemote()) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (1);
                    final int _amount = (int) 1;
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_sltid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (2);
                    final int _amount = (int) 8;
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_sltid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (3);
                    final int _amount = (int) 2;
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_sltid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (4);
                    final int _amount = (int) 2;
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_sltid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (6);
                    final int _amount = (int) 1;
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_sltid).copy();
                            if (_stk.attemptDamageItem(_amount, new Random(), null)) {
                                _stk.shrink(1);
                                _stk.setDamage(0);
                            }
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.WIND_REFLECTION.get());
                    _setstack.setCount((int) (new Object() {
                        public int getAmount(IWorld world, BlockPos pos, int sltid) {
                            AtomicInteger _retval = new AtomicInteger(0);
                            TileEntity _ent = world.getTileEntity(pos);
                            if (_ent != null) {
                                _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                                    _retval.set(capability.getStackInSlot(sltid).getCount());
                                });
                            }
                            return _retval.get();
                        }
                    }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (8)) + 1));
                    _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
                        }
                    });
                }
            }
        }
    }

}