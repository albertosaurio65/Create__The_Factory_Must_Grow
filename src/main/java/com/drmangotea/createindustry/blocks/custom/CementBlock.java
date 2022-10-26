package com.drmangotea.createindustry.blocks.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CementBlock extends FallingBlock {
    private final int dustColor;

    public CementBlock(int p_55967_, Properties p_55968_) {
        super(p_55968_);
        this.dustColor = p_55967_;
    }

    public int getDustColor(BlockState p_55970_, BlockGetter p_55971_, BlockPos p_55972_) {
        return this.dustColor;
    }
}