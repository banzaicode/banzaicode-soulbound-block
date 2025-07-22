package com.banzaicode.soulboundblock;

import com.banzaicode.soulboundblock.registry.ModBlocks;
import com.banzaicode.soulboundblock.registry.ModItems;
import com.banzaicode.soulboundblock.registry.ModBlockEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Clase principal del mod que inicializa el registro de los elementos del
 * bloque "soulbound".
 */
@Mod(SoulboundBlockMod.MOD_ID)
public class SoulboundBlockMod {
    public static final String MOD_ID = "soulboundblock";

    /**
     * Constructor donde se registran los bloques, ítems y entidades de bloque
     * asociados al mod.
     */
    public SoulboundBlockMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlockEntities.register(modEventBus);
    }
}
