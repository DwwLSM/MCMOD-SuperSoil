package com.dwwlsm.superrichsoil;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SuperRichSoilMod.MOD_ID);

    public static final DeferredItem<BlockItem> SUPER_RICH_SOIL = ITEMS.register(
            "super_rich_soil", () -> new BlockItem(ModBlocks.SUPER_RICH_SOIL.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> SUPER_RICH_SOIL_FARMLAND = ITEMS.register(
            "super_rich_soil_farmland",
            () -> new BlockItem(ModBlocks.SUPER_RICH_SOIL_FARMLAND.get(), new Item.Properties()));

    private ModItems() {
    }
}
