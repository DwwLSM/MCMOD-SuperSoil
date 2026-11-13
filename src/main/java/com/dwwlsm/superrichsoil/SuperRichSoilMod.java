package com.dwwlsm.superrichsoil;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(SuperRichSoilMod.MOD_ID)
public class SuperRichSoilMod {
    public static final String MOD_ID = "superrichsoil";

    public SuperRichSoilMod(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
    }
}
