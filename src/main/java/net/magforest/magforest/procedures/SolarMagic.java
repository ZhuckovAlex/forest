package net.magforest.magforest.procedures;
import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.magforest;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;


import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;


public class SolarMagic
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
        if (world.canBlockSeeSky(new BlockPos((int) x, (int) (y + 1), (int) z)) && ((world instanceof World) ? ((World) world).isDaytime() : false)) {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == Items.IRON_INGOT.asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == Items.QUARTZ.asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.IRON_INGOT.asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Items.QUARTZ.asItem() && new Object() {
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
            }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) <= 63 && ((new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == ModItems.INERT_KNOB.get().asItem() || (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Blocks.CAVE_AIR.asItem())) {
                if (world instanceof World && !world.isRemote()) {
                    ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1);
                } else {
                    ((World) world).playSound(x, y, z,
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
                }
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 50, 1, 1, 1, 40);
                }
                {
                    TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                    if (_ent != null) {
                        final int _sltid = (int) (0);
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
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;
                    private IWorld world;

                    public void start(IWorld world, int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                        this.world = world;
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks += 1;
                            if (this.ticks >= this.waitTicks)
                                run();
                        }
                    }

                    private void run() {
                        {
                            TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                            if (_ent != null) {
                                final int _sltid = (int) (4);
                                final ItemStack _setstack = new ItemStack(ModItems.INERT_KNOB.get());
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
                                }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) + 1));
                                _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
                                    }
                                });
                            }
                        }
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(world, (int) 100);
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == Items.ENDER_PEARL.asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.JIRAZOL.get().asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Items.EMERALD.asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == Blocks.STONE.asItem() && new Object() {
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
            }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) <= 63 && ((new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == ModBlocks.MOON_TEAR_ORE.get().asItem() || (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Blocks.CAVE_AIR.asItem())) {
                if (world instanceof World && !world.isRemote()) {
                    ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1);
                } else {
                    ((World) world).playSound(x, y, z,
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
                }
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 50, 1, 1, 1, 40);
                }
                {
                    TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                    if (_ent != null) {
                        final int _sltid = (int) (0);
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
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;
                    private IWorld world;

                    public void start(IWorld world, int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                        this.world = world;
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks += 1;
                            if (this.ticks >= this.waitTicks)
                                run();
                        }
                    }

                    private void run() {
                        {
                            TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                            if (_ent != null) {
                                final int _sltid = (int) (4);
                                final ItemStack _setstack = new ItemStack(ModBlocks.MOON_TEAR_ORE.get());
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
                                }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) + 1));
                                _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
                                    }
                                });
                            }
                        }
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(world, (int) 40);
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.AER_SCROLL.get().asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModItems.INERT_KNOB.get().asItem() && new Object() {
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
            }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) <= 63 && ((new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == ModItems.AER_KNOB.get().asItem() || (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Blocks.CAVE_AIR.asItem())) {
                if (world instanceof World && !world.isRemote()) {
                    ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1);
                } else {
                    ((World) world).playSound(x, y, z,
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
                }
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 50, 1, 1, 1, 40);
                }
                {
                    TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                    if (_ent != null) {
                        final int _sltid = (int) (0);
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
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;
                    private IWorld world;

                    public void start(IWorld world, int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                        this.world = world;
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks += 1;
                            if (this.ticks >= this.waitTicks)
                                run();
                        }
                    }

                    private void run() {
                        {
                            TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                            if (_ent != null) {
                                final int _sltid = (int) (4);
                                final ItemStack _setstack = new ItemStack(ModItems.AER_KNOB.get());
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
                                }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) + 1));
                                _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
                                    }
                                });
                            }
                        }
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(world, (int) 40);
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.AQUA_SCROLL.get().asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModItems.INERT_KNOB.get().asItem() && new Object() {
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
            }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) <= 63 && ((new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == ModItems.AQUA_KNOB.get().asItem() || (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Blocks.CAVE_AIR.asItem())) {
                if (world instanceof World && !world.isRemote()) {
                    ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1);
                } else {
                    ((World) world).playSound(x, y, z,
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
                }
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 50, 1, 1, 1, 40);
                }
                {
                    TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                    if (_ent != null) {
                        final int _sltid = (int) (0);
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
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;
                    private IWorld world;

                    public void start(IWorld world, int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                        this.world = world;
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks += 1;
                            if (this.ticks >= this.waitTicks)
                                run();
                        }
                    }

                    private void run() {
                        {
                            TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                            if (_ent != null) {
                                final int _sltid = (int) (4);
                                final ItemStack _setstack = new ItemStack(ModItems.AQUA_KNOB.get());
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
                                }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) + 1));
                                _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
                                    }
                                });
                            }
                        }
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(world, (int) 40);
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.TERRA_SCROLL.get().asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModItems.INERT_KNOB.get().asItem() && new Object() {
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
            }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) <= 63 && ((new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == ModItems.TERRA_KNOB.get().asItem() || (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Blocks.CAVE_AIR.asItem())) {
                if (world instanceof World && !world.isRemote()) {
                    ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1);
                } else {
                    ((World) world).playSound(x, y, z,
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
                }
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 50, 1, 1, 1, 40);
                }
                {
                    TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                    if (_ent != null) {
                        final int _sltid = (int) (0);
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
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;
                    private IWorld world;

                    public void start(IWorld world, int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                        this.world = world;
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks += 1;
                            if (this.ticks >= this.waitTicks)
                                run();
                        }
                    }

                    private void run() {
                        {
                            TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                            if (_ent != null) {
                                final int _sltid = (int) (4);
                                final ItemStack _setstack = new ItemStack(ModItems.TERRA_KNOB.get());
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
                                }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) + 1));
                                _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
                                    }
                                });
                            }
                        }
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(world, (int) 40);
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == ModItems.FLAME_SCROLL.get().asItem() && (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == ModItems.INERT_KNOB.get().asItem() && new Object() {
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
            }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) <= 63 && ((new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == ModItems.FLAME_KNOB.get().asItem() || (new Object() {
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
            }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == Blocks.CAVE_AIR.asItem())) {
                if (world instanceof World && !world.isRemote()) {
                    ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1);
                } else {
                    ((World) world).playSound(x, y, z,
                            (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("magforest:craftstart")),
                            SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
                }
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 50, 1, 1, 1, 40);
                }
                {
                    TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                    if (_ent != null) {
                        final int _sltid = (int) (0);
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
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;
                    private IWorld world;

                    public void start(IWorld world, int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                        this.world = world;
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks += 1;
                            if (this.ticks >= this.waitTicks)
                                run();
                        }
                    }

                    private void run() {
                        {
                            TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                            if (_ent != null) {
                                final int _sltid = (int) (4);
                                final ItemStack _setstack = new ItemStack(ModItems.FLAME_KNOB.get());
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
                                }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4)) + 1));
                                _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
                                    }
                                });
                            }
                        }
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(world, (int) 40);
            }

        }
    }
}