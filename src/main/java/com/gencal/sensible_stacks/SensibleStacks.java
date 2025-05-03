package com.gencal.sensible_stacks;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(SensibleStacks.MODID)
public class SensibleStacks
{
    public static final String MODID = "sensible_stacks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SensibleStacks()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // Code inspired by "Why stacks of 16?"
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> ForgeRegistries.ITEMS.getValues().forEach((item) -> {
            if (Config.enablePotionStacking && item instanceof PotionItem) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, Config.potionStackSize, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }

            else if (Config.enableGoldenAppleNerf && (item == Items.GOLDEN_APPLE || item == Items.ENCHANTED_GOLDEN_APPLE)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }

            else if (Config.enableHoneybottleStacking && (item == Items.HONEY_BOTTLE)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 64, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }

            else if (Config.enableSnowballStacking && (item == Items.SNOWBALL)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 64, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
            else if (Config.enableSaddleStacking && (item instanceof SaddleItem)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
            else if (Config.enableMinecartStacking && (item instanceof MinecartItem)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
            else if (Config.enableBoatStacking && (item instanceof BoatItem)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
            else if (Config.enableEnchantedBookStacking && (item instanceof EnchantedBookItem)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
            else if (Config.enableBedStacking && (item instanceof BedItem)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
        }));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("The minecraft server has started!");
        TagKey<Item> EGGS_TAG = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("forge", "eggs"));
        TagKey<Item> PEARLS_TAG = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("forge", "ender_pearls"));
        TagKey<Item> MUSIC_DISCS_TAG = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("minecraft", "music_discs"));

        ForgeRegistries.ITEMS.getValues().forEach((item) ->
        {
            if (Config.enableEggsStacking && item.builtInRegistryHolder().containsTag(EGGS_TAG)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 64, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
            else if (Config.enablePearlStacking && item.builtInRegistryHolder().containsTag(PEARLS_TAG)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 64, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
            else if (Config.enableMusicDiscStacking && item.builtInRegistryHolder().containsTag(MUSIC_DISCS_TAG)) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
                } catch (Exception e) {
                    LOGGER.error("Could not change the max stack-size of " + item + ", exception: " + e);
                }
            }
        });
    }

}
