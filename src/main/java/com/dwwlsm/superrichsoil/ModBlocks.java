package com.dwwlsm.superrichsoil;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SuperRichSoilMod.MOD_ID);

    public static final DeferredBlock<SuperRichSoilBlock> SUPER_RICH_SOIL = BLOCKS.registerBlock(
            "super_rich_soil",
            SuperRichSoilBlock::new,
            Block.Properties.ofFullCopy(Blocks.DIRT).randomTicks());
    public static final DeferredBlock<SuperRichSoilFarmlandBlock> SUPER_RICH_SOIL_FARMLAND = BLOCKS.registerBlock(
            "super_rich_soil_farmland",
            SuperRichSoilFarmlandBlock::new,
            Block.Properties.ofFullCopy(Blocks.FARMLAND));

    private ModBlocks() {
    }
}
