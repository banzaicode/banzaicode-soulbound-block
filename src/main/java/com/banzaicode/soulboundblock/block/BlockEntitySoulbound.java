package com.banzaicode.soulboundblock.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ObjectHolder;

import java.util.UUID;

public class BlockEntitySoulbound extends BlockEntity {

    private UUID owner;

    public BlockEntitySoulbound(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOULBOUND_BLOCK_ENTITY.get(), pos, state);
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (owner != null) tag.putUUID("owner", owner);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.hasUUID("owner")) owner = tag.getUUID("owner");
    }
}
