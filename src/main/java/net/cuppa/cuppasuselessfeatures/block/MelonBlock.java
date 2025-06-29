package net.cuppa.cuppasuselessfeatures.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MelonBlock extends Block {
    public static final IntProperty BITES = IntProperty.of("bites", 0, 4);

    private static final VoxelShape BITE_SHAPE_1 = VoxelShapes.union(
            Block.createCuboidShape(0, 0, 8, 8, 16, 16),   // Left rear quarter
            Block.createCuboidShape(8, 0, 0, 16, 16, 8),   // Right front quarter
            Block.createCuboidShape(8, 0, 8, 16, 16, 16)   // Right rear quarter
    );

    private static final VoxelShape[] BITE_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(0, 0, 0, 16, 16, 16),   // bites = 0 (full)
            BITE_SHAPE_1, //bites = 1
            Block.createCuboidShape(8, 0, 0, 16, 16, 16),   // bites = 2
            Block.createCuboidShape(8, 0, 8, 16, 16, 16),  // bites = 3 (mostly gone)
    };

    public MelonBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(BITES, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            // Trigger hand swing animation on client
            player.swingHand(Hand.MAIN_HAND);
            return ActionResult.SUCCESS;
        }

        if (player.isCreative() || player.getHungerManager().isNotFull()) {
            if (!player.isCreative()) {
                player.getHungerManager().add(4, 2.4f);
            }

            int currentBites = state.get(BITES);
            if (currentBites < 3) {
                world.setBlockState(pos, state.with(BITES, currentBites + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int bites = Math.min(state.get(BITES), BITE_SHAPES.length - 1);
        return BITE_SHAPES[bites];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int bites = Math.min(state.get(BITES), BITE_SHAPES.length - 1);
        return BITE_SHAPES[bites];
    }
}
