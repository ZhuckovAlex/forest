package net.magforest.magforest.block.custom;

import net.magforest.magforest.container.LightningMachineContainer;
import net.magforest.magforest.tileentity.LightMachineTile;
import net.magforest.magforest.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class LightMachine extends Block {
    public LightMachine(Properties properties) {
        super(properties);

        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 16, 1, 2, 27, 2),
            Block.makeCuboidShape(0, 11, 0, 16, 16, 16),
            Block.makeCuboidShape(10, 0, 10, 14, 11, 14),
            Block.makeCuboidShape(10, 0, 2, 14, 11, 6),
            Block.makeCuboidShape(2, 0, 2, 6, 11, 6),
            Block.makeCuboidShape(2, 0, 10, 6, 11, 14),
            Block.makeCuboidShape(7.75, 23, 7.5, 8.75, 32, 8.5),
            Block.makeCuboidShape(7.25, 27, 7, 9.25, 30, 9),
            Block.makeCuboidShape(1, 16, 14, 2, 27, 15),
            Block.makeCuboidShape(14, 16, 14, 15, 27, 15),
            Block.makeCuboidShape(14, 16, 1, 15, 27, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1, 16, 1, 2, 27, 2),
            Block.makeCuboidShape(0, 11, 0, 16, 16, 16),
            Block.makeCuboidShape(10, 0, 10, 14, 11, 14),
            Block.makeCuboidShape(10, 0, 2, 14, 11, 6),
            Block.makeCuboidShape(2, 0, 2, 6, 11, 6),
            Block.makeCuboidShape(2, 0, 10, 6, 11, 14),
            Block.makeCuboidShape(7.75, 23, 7.5, 8.75, 32, 8.5),
            Block.makeCuboidShape(7.25, 27, 7, 9.25, 30, 9),
            Block.makeCuboidShape(1, 16, 14, 2, 27, 15),
            Block.makeCuboidShape(14, 16, 14, 15, 27, 15),
            Block.makeCuboidShape(14, 16, 1, 15, 27, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 16, 1, 2, 27, 2),
            Block.makeCuboidShape(0, 11, 0, 16, 16, 16),
            Block.makeCuboidShape(10, 0, 10, 14, 11, 14),
            Block.makeCuboidShape(10, 0, 2, 14, 11, 6),
            Block.makeCuboidShape(2, 0, 2, 6, 11, 6),
            Block.makeCuboidShape(2, 0, 10, 6, 11, 14),
            Block.makeCuboidShape(7.75, 23, 7.5, 8.75, 32, 8.5),
            Block.makeCuboidShape(7.25, 27, 7, 9.25, 30, 9),
            Block.makeCuboidShape(1, 16, 14, 2, 27, 15),
            Block.makeCuboidShape(14, 16, 14, 15, 27, 15),
            Block.makeCuboidShape(14, 16, 1, 15, 27, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 16, 1, 2, 27, 2),
            Block.makeCuboidShape(0, 11, 0, 16, 16, 16),
            Block.makeCuboidShape(10, 0, 10, 14, 11, 14),
            Block.makeCuboidShape(10, 0, 2, 14, 11, 6),
            Block.makeCuboidShape(2, 0, 2, 6, 11, 6),
            Block.makeCuboidShape(2, 0, 10, 6, 11, 14),
            Block.makeCuboidShape(7.75, 23, 7.5, 8.75, 32, 8.5),
            Block.makeCuboidShape(7.25, 27, 7, 9.25, 30, 9),
            Block.makeCuboidShape(1, 16, 14, 2, 27, 15),
            Block.makeCuboidShape(14, 16, 14, 15, 27, 15),
            Block.makeCuboidShape(14, 16, 1, 15, 27, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;



    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }


    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(FACING, direction.rotate(state.get(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FACING);
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);

                if(tileEntity instanceof LightMachineTile) {
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                    NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getPos());
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.lightning_machine");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new LightningMachineContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.MOON_TEAR_LIGHTING_TILE.get().create();
    }
}
