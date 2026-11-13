package com.dwwlsm.superrichsoil;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import vectorwing.farmersdelight.common.block.RichSoilBlock;

import javax.annotation.Nullable;

public class SuperRichSoilBlock extends RichSoilBlock {
    public SuperRichSoilBlock(Properties properties) {
        super(properties);
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility toolAction, boolean simulate) {
        if (ItemAbilities.HOE_TILL.equals(toolAction)
                && context.getLevel().getBlockState(context.getClickedPos().above()).isAir()) {
            return ModBlocks.SUPER_RICH_SOIL_FARMLAND.get().defaultBlockState();
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
