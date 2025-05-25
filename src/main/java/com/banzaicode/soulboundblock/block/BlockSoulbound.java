package com.banzaicode.soulboundblock.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class BlockSoulbound extends Block {

    public BlockSoulbound(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            BlockEntitySoulbound be = new BlockEntitySoulbound(pos, state);
            be.setOwner(level.getServer().getPlayerList().getPlayers().stream()
                .filter(p -> p.blockPosition().closerThan(pos, 2))
                .findFirst()
                .map(ServerPlayer::getUUID)
                .orElse(null));
            level.setBlockEntity(be);
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof BlockEntitySoulbound soulbound) {
            if (!player.getUUID().equals(soulbound.getOwner())) {
                if (!level.isClientSide) {
                    player.sendSystemMessage(net.minecraft.network.chat.Component.literal("No sos el dueño de este bloque."));
                }
                // Cancelar destrucción
                level.setBlock(pos, state, 3); // Restaura el bloque
                return;
            }
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntitySoulbound(pos, state);
    }
}
