package com.banzaicode.soulboundblock.registry;

import com.banzaicode.soulboundblock.SoulboundBlockMod;
import com.banzaicode.soulboundblock.block.BlockEntitySoulbound;
import com.banzaicode.soulboundblock.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SoulboundBlockMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<BlockEntitySoulbound>> SOULBOUND_BLOCK_ENTITY =
        BLOCK_ENTITIES.register("soulbound_block_entity",
            () -> BlockEntityType.Builder.of(
                BlockEntitySoulbound::new,
                ModBlocks.SOULBOUND_BLOCK.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
