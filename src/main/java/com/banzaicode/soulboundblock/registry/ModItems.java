package com.banzaicode.soulboundblock.registry;

import com.banzaicode.soulboundblock.SoulboundBlockMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SoulboundBlockMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
/**
 * Registro y manejo de los ítems del mod, incluido el bloque soulbound como ítem.
 */
public class ModItems {

    /** Registro diferido para todos los ítems del mod. */
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SoulboundBlockMod.MOD_ID);

    /**
     * Ítem correspondiente al bloque soulbound, necesario para poder colocarlo en el mundo.
     */
    public static final RegistryObject<Item> SOULBOUND_BLOCK_ITEM =
            ITEMS.register("soulbound_block",
                    () -> new BlockItem(ModBlocks.SOULBOUND_BLOCK.get(), new Item.Properties()));

    /**
     * Registra los ítems en el bus de eventos de Forge.
     */
    public static void register(BusGroup modBus) {
        ITEMS.register(modBus);
    }

    /**
     * Añade el ítem a la pestaña de bloques de construcción en el modo creativo.
     */
    @SubscribeEvent
    public static void onCreativeTabBuild(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(SOULBOUND_BLOCK_ITEM);
        }
    }
}
