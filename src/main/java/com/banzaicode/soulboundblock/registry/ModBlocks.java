package com.banzaicode.soulboundblock.registry;

import com.banzaicode.soulboundblock.SoulboundBlockMod;
import com.banzaicode.soulboundblock.block.BlockSoulbound;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Contiene y registra los bloques personalizados del mod.
 */
public class ModBlocks {

    /** Registro diferido para todos los bloques del mod. */
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SoulboundBlockMod.MOD_ID);

    /**
     * Bloque principal que queda ligado al jugador que lo coloca.
     */
    public static final RegistryObject<Block> SOULBOUND_BLOCK =
            BLOCKS.register("soulbound_block",
                    () -> new BlockSoulbound(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()));

    /**
     * Registra los bloques en el bus de eventos de Forge.
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
