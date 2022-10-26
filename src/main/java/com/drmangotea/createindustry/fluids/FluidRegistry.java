package com.drmangotea.createindustry.fluids;


import com.drmangotea.createindustry.CreateIndustry;
import com.drmangotea.createindustry.blocks.BlockRegistry;
import com.drmangotea.createindustry.blocks.custom.LimesandBlock;
import com.drmangotea.createindustry.items.ItemRegistry;
import com.simibubi.create.AllTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidRegistry {
    public static final ResourceLocation LIQUID_CONCRETE_FLUID_STILL = new ResourceLocation("createindustry:fluid/liquid_concrete_fluid");

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, CreateIndustry.MOD_ID);


    public static final RegistryObject<ForgeFlowingFluid> LIQUID_CONCRETE_FLUID
            = FLUIDS.register("liquid_concrete_fluid", () -> new ForgeFlowingFluid.Source(FluidRegistry.LIQUID_CONCRETE_PROPERTIES));

    public static final RegistryObject<ForgeFlowingFluid> LIQUID_CONCRETE_FLOWING
            = FLUIDS.register("liquid_concrete_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.LIQUID_CONCRETE_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIQUID_CONCRETE_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_CONCRETE_FLUID.get(), () -> LIQUID_CONCRETE_FLOWING.get(), FluidAttributes.builder(LIQUID_CONCRETE_FLUID_STILL, null)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.HONEY_DRINK)
            ).slopeFindDistance(2).levelDecreasePerBlock(2);





    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}