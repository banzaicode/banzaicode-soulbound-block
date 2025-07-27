package com.banzaicode.soulboundblock.registry;

import com.banzaicode.soulboundblock.SoulboundBlockMod;
import com.banzaicode.soulboundblock.block.BlockEntitySoulbound;
import com.banzaicode.soulboundblock.registry.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import java.util.Set;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registro de las entidades de bloque utilizadas para el bloque soulbound.
 */
public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SoulboundBlockMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<BlockEntitySoulbound>> SOULBOUND_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("soulbound_block_entity",
                    () -> new BlockEntityType<>(
                            BlockEntitySoulbound::new,
                            Set.of(ModBlocks.SOULBOUND_BLOCK.get())));

    /**
     * Registra las entidades de bloque en el bus de eventos de Forge.
     */
    public static void register(BusGroup modBus) {
        BLOCK_ENTITIES.register(modBus);
    }
}
