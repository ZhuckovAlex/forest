package net.magforest.magforest.procedures;

import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class Alchemy
{
    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                magforest.LOGGER.warn("Failed to load dependency world for procedure Solarmagic!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                magforest.LOGGER.warn("Failed to load dependency x for procedure Solarmagic!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                magforest.LOGGER.warn("Failed to load dependency y for procedure Solarmagic!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                magforest.LOGGER.warn("Failed to load dependency z for procedure Solarmagic!");
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == ModBlocks.SLEEPY_LEAF.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 7 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModBlocks.ICY_YAWN.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 7 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == ModBlocks.SILVER_SAGE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 6 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (5))).getItem() == ModBlocks.BLACK_TOADSTOOL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (5)) >= 2 && ((new Object() {
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
        }
        .getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 800);
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
                    final int _amount = (int) 7;
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
                    final int _amount = (int) 7;
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
                    final int _amount = (int) 6;
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
                    final int _sltid = (int) (5);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.ALCHEMICAL_INFUSION.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == ModBlocks.THISTLE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 12 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModBlocks.BLACK_TOADSTOOL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Items.GUNPOWDER.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 5 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.ENTROPY_POTION.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
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
                    final int _amount = (int) 12;
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
                    final int _amount = (int) 5;
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.ENTROPY_POTION.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.HONEY_BOTTLE.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModBlocks.HYACINTH.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Blocks.OXEYE_DAISY.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 5 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.HEALING_POTION.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
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
                    final int _amount = (int) 5;
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.HEALING_POTION.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModItems.MOON_TEAR.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.ENTROPY_POTION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.ETHER_ESSENCE.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (2);
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
                    final int _sltid = (int) (3);
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
                    final int _sltid = (int) (6);
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
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.ETHER_ESSENCE.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.NETHER_WART.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 7 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.GLOWSTONE_DUST.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Items.BLAZE_POWDER.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 6 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.FIREWATER.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
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
                    final int _amount = (int) 7;
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
                    final int _amount = (int) 6;
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
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.FIREWATER.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.KELP.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 16 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.GLOWSTONE_DUST.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Items.PUFFERFISH.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.SPIRIT_OF_THE_SEA.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
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
                    final int _amount = (int) 16;
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
                    final int _sltid = (int) (6);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.SPIRIT_OF_THE_SEA.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.FEATHER.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 8 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.GLOWSTONE_DUST.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Items.PHANTOM_MEMBRANE.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.WIND_REFLECTION.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
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
                            _stk.shrink(_amount);
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.CRYSTAL_PHIAL.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.GRASS.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 10 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.GLOWSTONE_DUST.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Items.DIRT.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) >= 2 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.TURF_EXTRACT.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
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
                    final int _amount = (int) 10;
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
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.TURF_EXTRACT.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == ModItems.ETHER_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.REDSTONE.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 10 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.SPIRIT_OF_THE_SEA.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.WATER_ESSENCE.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (2);
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
                    final int _sltid = (int) (3);
                    final int _amount = (int) 10;
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
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.WATER_ESSENCE.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == ModItems.ETHER_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.REDSTONE.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 10 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.FIREWATER.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.FIRE_ESSENCE.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (2);
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
                    final int _sltid = (int) (3);
                    final int _amount = (int) 10;
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
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.FIRE_ESSENCE.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == ModItems.ETHER_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.REDSTONE.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 10 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.WIND_REFLECTION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.AER_ESSENCE.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (2);
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
                    final int _sltid = (int) (3);
                    final int _amount = (int) 10;
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
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.AER_ESSENCE.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == ModItems.ETHER_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.REDSTONE.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3)) >= 10 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == ModItems.ALCHEMICAL_INFUSION.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.TURF_EXTRACT.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModItems.TERRA_ESSENCE.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (2);
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
                    final int _sltid = (int) (3);
                    final int _amount = (int) 10;
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
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
                        }
                    });
                }
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModItems.TERRA_ESSENCE.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == Items.QUARTZ.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.AER_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModBlocks.AER_CRISTAL.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (6);
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
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModBlocks.AER_CRISTAL.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == Items.QUARTZ.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.WATER_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModBlocks.AQUA_CRISTAL.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (6);
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
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModBlocks.AQUA_CRISTAL.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == Items.QUARTZ.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.TERRA_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModBlocks.TERRA_CRISTAL.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (6);
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
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModBlocks.TERRA_CRISTAL.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == Items.QUARTZ.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.FIRE_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModBlocks.FLAME_CRISTAL.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (6);
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
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModBlocks.FLAME_CRISTAL.get());
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6))).getItem() == Items.QUARTZ.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (6)) >= 1 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7))).getItem() == ModItems.ETHER_ESSENCE.get().asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (7)) >= 1 && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == ModBlocks.ETHER_CRISTAL.get().asItem() || (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.AIR.asItem()) && new Object() {
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
                ((World) world)
                        .playSound(null, new BlockPos((int) x, (int) y, (int) z),
                                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                        .getValue(new ResourceLocation("magforest:alchemy")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("magforest:alchemy")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (6);
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
                    final int _sltid = (int) (7);
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(ModBlocks.ETHER_CRISTAL.get());
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