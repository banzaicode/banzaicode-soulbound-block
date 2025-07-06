package com.banzaicode.soulboundblock.registry;

import com.banzaicode.soulboundblock.SoulboundBlockMod;
import com.banzaicode.soulboundblock.block.BlockSoulbound;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SoulboundBlockMod.MOD_ID);

    public static final RegistryObject<Block> SOULBOUND_BLOCK =
            BLOCKS.register("soulbound_block",
                    () -> new BlockSoulbound(BlockBehaviour.Properties.of(Material.METAL)
                            .strength(50f, 1200f)
                            .requiresCorrectToolForDrops()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
