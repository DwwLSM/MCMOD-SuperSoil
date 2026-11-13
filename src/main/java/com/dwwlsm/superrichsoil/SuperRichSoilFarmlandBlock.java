package com.dwwlsm.superrichsoil;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import vectorwing.farmersdelight.common.block.RichSoilFarmlandBlock;

import javax.annotation.Nullable;

public class SuperRichSoilFarmlandBlock extends RichSoilFarmlandBlock {
    public SuperRichSoilFarmlandBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFertile(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(MOISTURE) > 0;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            turnToSuperRichSoil(null, state, level, pos);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if (!this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos())) {
            return ModBlocks.SUPER_RICH_SOIL.get().defaultBlockState();
        }
        return super.getStateForPlacement(context);
    }

    public static void turnToSuperRichSoil(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(
                state, ModBlocks.SUPER_RICH_SOIL.get().defaultBlockState(), level, pos));
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, state));
    }
}
