package com.drmangotea.createindustry.blocks;


        import com.drmangotea.createindustry.CreateIndustry;
        import com.drmangotea.createindustry.ModCreativeModeTab;
        import com.drmangotea.createindustry.SpriteShifts;
        import com.drmangotea.createindustry.blocks.custom.*;
        import com.drmangotea.createindustry.blocks.custom.concrete.DriedConcreteBlock;
        import com.drmangotea.createindustry.blocks.custom.concrete.DryingConcrete;
        import com.drmangotea.createindustry.blocks.custom.concrete.DryingConcreteBlock;
        import com.drmangotea.createindustry.blocks.custom.concrete.RebarCageBlock;
        import com.drmangotea.createindustry.items.ItemRegistry;

        import com.simibubi.create.AllTags;
        import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock;
        import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
        import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
        import com.simibubi.create.foundation.data.BlockStateGen;
        import com.simibubi.create.foundation.data.CreateRegistrate;
        import com.tterrag.registrate.util.entry.BlockEntry;
        import net.minecraft.client.renderer.RenderType;
        import net.minecraft.data.loot.BlockLoot;
        import net.minecraft.network.chat.Component;
        import net.minecraft.network.chat.TranslatableComponent;
        import net.minecraft.sounds.SoundEvents;
        import net.minecraft.world.item.*;
        import net.minecraft.world.level.Level;
        import net.minecraft.world.level.block.Block;
        import net.minecraft.world.level.block.Blocks;
        import net.minecraft.world.level.block.SoundType;
        import net.minecraft.world.level.block.state.BlockBehaviour;
        import net.minecraft.world.level.material.Material;
        import net.minecraftforge.eventbus.api.IEventBus;
        import net.minecraftforge.registries.DeferredRegister;
        import net.minecraftforge.registries.ForgeRegistries;
        import net.minecraftforge.registries.RegistryObject;


        import javax.annotation.Nullable;
        import java.util.List;
        import java.util.function.Supplier;

        import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;


public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateIndustry.MOD_ID);
    private static final CreateRegistrate REGISTRATE = CreateIndustry.registrate().creativeModeTab(() -> ModCreativeModeTab.CREATEINDUSTRY);
    //---------------------------------------------------------------------------------//
    public static final RegistryObject<Block> CONCRETE = registerBlock("concrete",
            () -> new DriedConcreteBlock(DryingConcrete.DryingState.DRIED,BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops()
            ), ModCreativeModeTab.CREATEINDUSTRY);



    public static final RegistryObject<Block> REBAR_CONCRETE = registerBlock("rebar_concrete",
            () -> new DriedConcreteBlock(DryingConcrete.DryingState.DRIED,BlockBehaviour.Properties.of(Material.STONE)
                    .strength(40.0F, 1200.0F)
            ), ModCreativeModeTab.CREATEINDUSTRY);
    public static final RegistryObject<Block> LIQUID_CONCRETE = registerConcreteBucketBlockItem("liquid_concrete",
           () -> new DryingConcreteBlock(DryingConcrete.DryingState.UNAFFECTED,BlockBehaviour.Properties.of(Material.SNOW)
                   .strength(2f)
                   .requiresCorrectToolForDrops()
                   .sound(SoundType.SOUL_SOIL)
                  ), ModCreativeModeTab.CREATEINDUSTRY, "tooltip.createindustry.block.concrete");

    public static final RegistryObject<Block> LIQUID_REBAR_CONCRETE = registerConcreteBucketBlockItem("liquid_rebar_concrete",
            () -> new DryingConcreteBlock(DryingConcrete.DryingState.UNAFFECTED,BlockBehaviour.Properties.of(Material.SNOW)
                    .strength(6f)
                    .sound(SoundType.SOUL_SOIL)
            ), ModCreativeModeTab.CREATEINDUSTRY, "tooltip.createindustry.block.concrete");

    public static final RegistryObject<Block> LIMESAND = registerBlock("limesand",
            () -> new LimesandBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(0.5f)
                    .sound(SoundType.SAND)
            ), ModCreativeModeTab.CREATEINDUSTRY);

    public static final RegistryObject<Block> CEMENT = registerBlock("cement",
            () -> new LimesandBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(0.5f)
                    .sound(SoundType.SAND)
            ), ModCreativeModeTab.CREATEINDUSTRY);

    public static final RegistryObject<Block> REBAR_CAGE = registerBlock("rebar_cage",
            () -> new RebarCageBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1.5f)
                    .sound(SoundType.COPPER)
            ), null
            //ModCreativeModeTab.CREATEINDUSTRY
            );


   public static BlockEntry<SteelBlock> steelblock(String name, Supplier<ConnectedTextureBehaviour> behaviour) {
       return REGISTRATE.block(name, SteelBlock::new).onRegister(connectedTextures(behaviour)).properties(p -> p.requiresCorrectToolForDrops()).properties(p -> p.strength(6.0F)).addLayer(() -> RenderType::cutout).initialProperties(() -> Blocks.COPPER_BLOCK).item().build().register();}

    public static final BlockEntry<SteelBlock>
            STEEL_BLOCK = steelblock("steel_block",
            () -> new SimpleCTBehaviour(SpriteShifts.STEEL_BLOCK));




    //---------------------------------------------------------------------------------//
    private static <T extends Block> RegistryObject<T> registerConcreteBucketBlockItem(String name, Supplier<T> block,
                                                                                       CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBucketBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBucketBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ItemRegistry.ITEMS.register(name+"_bucket",
                () -> new SolidBucketItem(block.get(), SoundEvents.BUCKET_EMPTY,
                        new Item.Properties()
                        .tab(ModCreativeModeTab.CREATEINDUSTRY)
                        .craftRemainder(Items.BUCKET)
                        .stacksTo(1)) {
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                        pTooltip.add(new TranslatableComponent(tooltipKey));
                    }
                });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
