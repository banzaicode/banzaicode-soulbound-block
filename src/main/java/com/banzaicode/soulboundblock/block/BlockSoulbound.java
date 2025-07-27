package com.banzaicode.soulboundblock.block;

import com.banzaicode.soulboundblock.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.UUID;

/**
 * Bloque que queda "vinculado" al alma del jugador que lo coloca. Solo su dueño
 * podrá romperlo posteriormente.
 */
import net.minecraft.world.level.block.EntityBlock;

public class BlockSoulbound extends Block implements EntityBlock {

    /**
     * Constructor que simplemente delega la configuración del bloque.
     */
    public BlockSoulbound(Properties properties) {
        super(properties);
    }

    /**
     * Cuando se coloca el bloque se almacena el UUID del jugador más cercano
     * para dejarlo como dueño.
     */
    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BlockEntitySoulbound soulbound) {
                // Obtiene el jugador que lo colocó (por proximidad simple)
                ServerPlayer owner = level.getServer().getPlayerList().getPlayers().stream()
                        .filter(p -> p.blockPosition().closerThan(pos, 2))
                        .findFirst()
                        .orElse(null);
                if (owner != null) {
                    soulbound.setOwner(owner.getUUID());
                }
            }
        }
    }

    /**
     * Evita que un jugador distinto al dueño destruya el bloque. Si no es el
     * dueño se cancela la destrucción y se muestra un mensaje.
     */
    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BlockEntitySoulbound soulbound) {
                UUID owner = soulbound.getOwner();
                if (owner != null && !player.getUUID().equals(owner)) {
                    // No sos el dueño → no te deja romperlo
                    if (player instanceof ServerPlayer serverPlayer) {
                        serverPlayer.sendSystemMessage(
                                net.minecraft.network.chat.Component.literal("No sos el dueño de este bloque."));
                    }
                    level.setBlock(pos, state, 3); // Cancela destrucción
                    return state;
                }
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    /**
     * Indica que el bloque tiene una entidad asociada para guardar datos.
     */
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntitySoulbound(pos, state);
    }
}
