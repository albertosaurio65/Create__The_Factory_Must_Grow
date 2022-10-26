package com.drmangotea.createindustry.blocks.custom.concrete;

import com.drmangotea.createindustry.blocks.BlockRegistry;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Optional;
import java.util.function.Supplier;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

public interface DryingConcrete extends ChangeOverTimeBlock<DryingConcrete.DryingState> {
    Supplier<BiMap<Block, Block>> SOLIDIFY_LEVEL = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(BlockRegistry.LIQUID_CONCRETE.get(), BlockRegistry.CONCRETE.get()).put(BlockRegistry.LIQUID_REBAR_CONCRETE.get(), BlockRegistry.REBAR_CONCRETE.get()).build();
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return SOLIDIFY_LEVEL.get().inverse();
    });

    static Optional<Block> getPrevious(Block p_154891_) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(p_154891_));
    }

    static Block getFirst(Block p_154898_) {
        Block block = p_154898_;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(p_154898_); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<BlockState> getPrevious(BlockState p_154900_) {
        return getPrevious(p_154900_.getBlock()).map((p_154903_) -> {
            return p_154903_.withPropertiesOf(p_154900_);
        });
    }

    static Optional<Block> getNext(Block p_154905_) {
        return Optional.ofNullable(SOLIDIFY_LEVEL.get().get(p_154905_));
    }


    default Optional<BlockState> getNext(BlockState p_154893_) {
        return getNext(p_154893_.getBlock()).map((p_154896_) -> p_154896_.withPropertiesOf(p_154893_));
    }

    default float getChanceModifier() {
        if (this.getAge() == DryingConcrete.DryingState.UNAFFECTED) {return 10.15f;}return 1.0f;
    }

  enum DryingState {
        UNAFFECTED,
        DRIED;
    }
}