package com.dwwlsm.superrichsoil.mixin;

import com.dwwlsm.superrichsoil.SuperRichSoilFarmlandBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin {
    @Shadow
    public abstract int getAge(BlockState state);

    @Shadow
    public abstract int getMaxAge();

    @Shadow
    public abstract BlockState getStateForAge(int age);

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void superrichsoil$forceGrow(BlockState state, ServerLevel level, BlockPos pos,
                                         RandomSource random, CallbackInfo ci) {
        if (!(level.getBlockState(pos.below()).getBlock() instanceof SuperRichSoilFarmlandBlock)) {
            return;
        }
        int age = this.getAge(state);
        if (age >= this.getMaxAge()) {
            ci.cancel();
            return;
        }
        level.setBlock(pos, this.getStateForAge(age + 1), 2);
        ci.cancel();
    }
}
