package com.banzaicode.soulboundblock.block;

import com.banzaicode.soulboundblock.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

/**
 * Entidad de bloque que almacena el UUID del jugador que colocó el bloque
 * soulbound.
 */
public class BlockEntitySoulbound extends BlockEntity {

    private UUID owner;

    /**
     * Crea una nueva instancia asociada al tipo de entidad registrado.
     */
    public BlockEntitySoulbound(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOULBOUND_BLOCK_ENTITY.get(), pos, state);
    }

    /**
     * Obtiene el UUID del dueño del bloque.
     */
    public UUID getOwner() {
        return owner;
    }

    /**
     * Establece el dueño del bloque y marca la entidad como modificada.
     */
    public void setOwner(UUID owner) {
        this.owner = owner;
        setChanged();
    }

    /**
     * Guarda el UUID del dueño en el NBT para persistirlo.
     */
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (owner != null) {
            tag.putUUID("owner", owner);
        }
    }

    /**
     * Carga el UUID del dueño desde el NBT al aparecer el bloque en el mundo.
     */
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.hasUUID("owner")) {
            owner = tag.getUUID("owner");
        }
    }
}
