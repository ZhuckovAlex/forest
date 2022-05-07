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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == Blocks.OAK_LOG.asItem() && new Object() {
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
        }.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (0)) >= 4 && (new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == Blocks.OAK_LOG.asItem() && new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == Blocks.OAK_LOG.asItem() && ((new Object() {
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
        }.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8))).getItem() == Blocks.DIAMOND_ORE.asItem() || (new Object() {
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
                                        .getValue(new ResourceLocation("ambient.basalt_deltas.additions")),
                                SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("ambient.basalt_deltas.additions")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (world instanceof ServerWorld) {
                ((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 20, 1, 1, 1, 80);
            }
            {
                TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
                if (_ent != null) {
                    final int _sltid = (int) (0);
                    final int _amount = (int) 4;
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
                    final int _sltid = (int) (8);
                    final ItemStack _setstack = new ItemStack(Blocks.DIAMOND_ORE);
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