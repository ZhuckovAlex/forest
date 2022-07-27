package net.magforest.magforest;

import com.google.common.collect.ImmutableMap;
import net.magforest.magforest.block.ModBlocks;
import net.magforest.magforest.block.ModWoodTypes;
import net.magforest.magforest.container.ModContainers;
import net.magforest.magforest.data.recipes.ModLightningRodRecipeTypes;
import net.magforest.magforest.entity.ModCianEntityTypes;
import net.magforest.magforest.entity.ModDarkBirchEntityTypes;
import net.magforest.magforest.entity.ModEntityTypes;
import net.magforest.magforest.entity.render.EntityFrostShardRenderer;
import net.magforest.magforest.entity.render.MoonMothRender;
import net.magforest.magforest.entity.renderer.ModCianBoatRenderer;
import net.magforest.magforest.entity.renderer.ModDarkBirchBoatRenderer;
import net.magforest.magforest.entity.villager.ModVillager;
import net.magforest.magforest.events.ClientEvents;
import net.magforest.magforest.events.PacketHandler;
import net.magforest.magforest.item.ModItems;
import net.magforest.magforest.entity.render.EntityEmberRenderer;
import net.magforest.magforest.screen.AlchemyTableScreen;
import net.magforest.magforest.screen.LightingMachineScreen;
import net.magforest.magforest.screen.SolarConverterScreen;
import net.magforest.magforest.tileentity.ModTileEntities;
import net.magforest.magforest.item.custom.util.ModSoundEvents;
import net.magforest.magforest.world.biome.MagicForest;
import net.magforest.magforest.world.structure.ModStructures;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.WoodType;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(magforest.MOD_ID)
public class magforest
{


    public static final String MOD_ID = "magforest";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public magforest() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MagicForest.BIOMES.register(eventBus);
        MagicForest.registerBiomes();
        PacketHandler.init();
        ModTileEntities.register(eventBus);
        ModContainers.register(eventBus);

        ModStructures.register(eventBus);
        ModLightningRodRecipeTypes.register(eventBus);


        ModCianEntityTypes.register(eventBus);
        ModDarkBirchEntityTypes.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModItems.register(eventBus);

        ModBlocks.register(eventBus);

        ModSoundEvents.register(eventBus);

        eventBus.addListener(this::setup);

        eventBus.addListener(this::enqueueIMC);

        eventBus.addListener(this::processIMC);

        eventBus.addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ModVillager.VILLAGER_PROFESSIONS.register(eventBus);
        ModVillager.POINT_OF_INTEREST_TYPES.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.KARAMBOLA_FRUIT.get(), 0.50f);
        });
event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.KARAMBOLA.get(), 0.35f);
        });
event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.CIAN_LEAVES.get(), 0.65f);
        });
event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.CIAN_SAPLING.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.CRIMSON_SAPLING.get(), 0.15f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.WARPED_SAPLING.get(), 0.25f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.DARK_BIRCH_LEAVES.get(), 0.65f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.DARK_BIRCH_SAPLING.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.WARPED_WART.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.HYACINTH.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.BLACK_TOADSTOOL.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.THE_CALL_OF_THE_ANCESTORS.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.SEEDS_OF_THE_CALL_OF_THE_ANCESTORS.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.ACORN.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.SILVER_SAGE.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.ICY_YAWN.get(), 0.35f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.SLEEPY_LEAF.get(), 0.35f);
        });

event.enqueueWork(() -> {
    AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
            .put(ModBlocks.CIAN_LOG.get(), ModBlocks.STRIPPED_CIAN_LOG.get())
            .put(ModBlocks.CIAN_WOOD.get(), ModBlocks.STRIPPED_CIAN_WOOD.get()).build();
    WoodType.register(ModWoodTypes.CIAN);
    AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
            .put(ModBlocks.DARK_BIRCH_LOG.get(), ModBlocks.STRIPPED_DARK_BIRCH_LOG.get())
            .put(ModBlocks.DARK_BIRCH_WOOD.get(), ModBlocks.STRIPPED_DARK_BIRCH_WOOD.get()).build();
    WoodType.register(ModWoodTypes.DARK_BIRCH);

    ModStructures.setupStructures();

});

event.enqueueWork(() -> registerRecipes());
    }




    private void registerRecipes(){

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER)),
                Ingredient.fromItems(ModItems.WARPED_WART.get()),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION),Potions.AWKWARD)
        ));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), Potions.WATER)),
                Ingredient.fromItems(ModItems.WARPED_WART.get()),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION),Potions.AWKWARD)
        ));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.WATER)),
                Ingredient.fromItems(ModItems.WARPED_WART.get()),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION),Potions.AWKWARD)
        ));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.fromItems(Items.CHORUS_FRUIT),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.DRAGON_BREATH),null)
        ));
    }


    private void doClientStuff(final FMLClientSetupEvent event)
    {
        ScreenManager.registerFactory(ModContainers.LIGHTING_MACHINE_CONTAINER.get(),
                LightingMachineScreen::new);
        ScreenManager.registerFactory(ModContainers.SOLAR_CONVERTER_CONTAINER.get(),
                SolarConverterScreen::new);
        ScreenManager.registerFactory(ModContainers.ALCHEMY_TABLE_CONTAINER.get(),
                AlchemyTableScreen::new);
        RenderTypeLookup.setRenderLayer(ModBlocks.CIAN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CIAN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CIAN_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ELF_GLASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ELF_GLASS_PANE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CIAN_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DARK_BIRCH_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DARK_BIRCH_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.HYACINTH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_TOADSTOOL.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SILVER_SAGE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ICY_YAWN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SLEEPY_LEAF.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.THE_CALL_OF_THE_ANCESTORS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SEEDS_OF_THE_CALL_OF_THE_ANCESTORS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.THISTLE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.KARAMBOLA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DARK_BIRCH_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CRIMSON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.WARPED_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.WARPED_WART.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DARK_BIRCH_LEAVES.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MOON_MOTH.get(), MoonMothRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EMBER.get(), EntityEmberRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FROST_SHARD.get(), EntityFrostShardRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(),
                SignTileEntityRenderer::new);
        Atlases.addWoodType(ModWoodTypes.BIG_CIAN);
        Atlases.addWoodType(ModWoodTypes.BEE_CIAN);
        Atlases.addWoodType(ModWoodTypes.CIAN);
        Atlases.addWoodType(ModWoodTypes.DARK_BIRCH);

        RenderingRegistry.registerEntityRenderingHandler(ModCianEntityTypes.CIAN_BOAT.get(), ModCianBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModDarkBirchEntityTypes.DARK_BIRCH_BOAT.get(), ModDarkBirchBoatRenderer::new);
        ClientRegistry.registerKeyBinding(ClientEvents.keyF);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }

    }
}
