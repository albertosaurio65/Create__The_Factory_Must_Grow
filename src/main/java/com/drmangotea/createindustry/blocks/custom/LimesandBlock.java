package com.drmangotea.createindustry.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class LimesandBlock extends FallingBlock {
    public LimesandBlock(BlockBehaviour.Properties p_53736_) {
        super(p_53736_);
    }

    public int getDustColor(BlockState p_53738_, BlockGetter p_53739_, BlockPos p_53740_) {
        return -8356741;
    }


}