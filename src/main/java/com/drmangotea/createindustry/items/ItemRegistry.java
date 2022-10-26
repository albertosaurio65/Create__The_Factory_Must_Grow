package com.drmangotea.createindustry.items;

import com.drmangotea.createindustry.CreateIndustry;
import com.drmangotea.createindustry.ModCreativeModeTab;
import com.drmangotea.createindustry.items.custom.CoalCokeItem;
import com.drmangotea.createindustry.items.custom.quadpotatocannon.QuadPotatoCannonItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateIndustry.MOD_ID);

    //-------------------------------------------------------------------------------------------------------------------------------//

    public static final RegistryObject<Item> REBAR= ITEMS.register("rebar",
         () -> new Item( (
                   new Item.Properties()).tab(ModCreativeModeTab.CREATEINDUSTRY)));
    public static final RegistryObject<Item> COAL_COKE= ITEMS.register("coal_coke",
            () -> new CoalCokeItem( (
                    new Item.Properties()).tab(ModCreativeModeTab.CREATEINDUSTRY)));
    public static final RegistryObject<Item> STEEL_INGOT= ITEMS.register("steel_ingot",
            () -> new Item( (
                    new Item.Properties()).tab(ModCreativeModeTab.CREATEINDUSTRY)));

    public static final RegistryObject<Item> QUAD_POTATO_CANNON= ITEMS.register("quad_potato_cannon",
            () -> new QuadPotatoCannonItem( (
                    new Item.Properties()).durability(500).tab(ModCreativeModeTab.CREATEINDUSTRY)));










    //-------------------------------------------------------------------------------------------------------------------------------//
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
