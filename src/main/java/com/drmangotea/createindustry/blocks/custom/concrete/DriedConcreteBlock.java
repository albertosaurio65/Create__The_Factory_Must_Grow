package com.drmangotea.createindustry.blocks.custom.concrete;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class DriedConcreteBlock extends Block implements DryingConcrete {
    private final DryingConcrete.DryingState dryingState;

    public DriedConcreteBlock(DryingConcrete.DryingState p_154925_, BlockBehaviour.Properties p_154926_) {
        super(p_154926_);
        this.dryingState = p_154925_;
    }

    public void randomTick(BlockState p_154929_, ServerLevel p_154930_, BlockPos p_154931_, Random p_154932_) {
        this.onRandomTick(p_154929_, p_154930_, p_154931_, p_154932_);
    }

    public boolean isRandomlyTicking(BlockState p_154935_) {
        return DryingConcrete.getNext(p_154935_.getBlock()).isPresent();
    }

    public DryingConcrete.DryingState getAge() {
        return this.dryingState;
    }
}