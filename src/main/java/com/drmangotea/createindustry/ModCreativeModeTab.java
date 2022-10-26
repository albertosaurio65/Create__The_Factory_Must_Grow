package com.drmangotea.createindustry;

import com.drmangotea.createindustry.blocks.BlockRegistry;

import com.drmangotea.createindustry.items.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CREATEINDUSTRY = new CreativeModeTab("createindustry") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.STEEL_INGOT.get());
        }
    };
}