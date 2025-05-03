package com.gencal.sensible_stacks;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = SensibleStacks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue ENABLE_POTION_STACKING = BUILDER
            .comment("Make potions stack up to 3 (Configurable)")
            .define("enablePotionStacking", true);

    public static final ForgeConfigSpec.IntValue POTION_STACK_SIZE = BUILDER
            .comment("Potions will stack up to this size")
            .defineInRange("potionStackSize", 3, 1, 64);

    public static final ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_APPLE_NERF = BUILDER
            .comment("Make Golden Apples and Enchanted Golden Apples stack up to 16")
            .define("enableGoldenAppleNerf", false);

    public static final ForgeConfigSpec.BooleanValue ENABLE_EGGS_STACKING = BUILDER
            .comment("Make eggs (items with tag forge:eggs) stack up to 64")
            .define("enableEggsStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_PEARL_STACKING = BUILDER
            .comment("Make ender pearls stack up to 64")
            .define("enablePearlStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_SNOWBALL_STACKING = BUILDER
            .comment("Make snowballs stack up to 64")
            .define("enableSnowballStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_HONEYBOTTLE_STACKING = BUILDER
            .comment("Make bottles of honey stack up to 64")
            .define("enableHoneybottleStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_SADDLE_STACKING = BUILDER
            .comment("Make saddles stack up to 16")
            .define("enableSaddleStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_MINECART_STACKING = BUILDER
            .comment("Make all sorts of minecarts stack up to 16")
            .define("enableMinecartStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_BOAT_STACKING = BUILDER
            .comment("Make all sorts of boats stack up to 16")
            .define("enableBoatStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_ENCHANTED_BOOK_STACKING = BUILDER
            .comment("Make all Enchanted Books stack up to 16")
            .define("enableEnchantedBookStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_BED_STACKING = BUILDER
            .comment("Make all sorts of beds stack up to 16")
            .define("enableBedStacking", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_MUSIC_DISC_STACKING = BUILDER
            .comment("Make all Music Discs stack up to 16")
            .define("enableMusicDiscStacking", true);


    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean enablePotionStacking;
    public static int potionStackSize;
    public static boolean enableGoldenAppleNerf;
    public static boolean enableEggsStacking;
    public static boolean enablePearlStacking;
    public static boolean enableSnowballStacking;
    public static boolean enableHoneybottleStacking;
    public static boolean enableSaddleStacking;
    public static boolean enableMinecartStacking;
    public static boolean enableBoatStacking;
    public static boolean enableEnchantedBookStacking;
    public static boolean enableBedStacking;
    public static boolean enableMusicDiscStacking;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enablePotionStacking = ENABLE_POTION_STACKING.get();
        potionStackSize = POTION_STACK_SIZE.get();
        enableGoldenAppleNerf = ENABLE_GOLDEN_APPLE_NERF.get();
        enableEggsStacking = ENABLE_EGGS_STACKING.get();
        enablePearlStacking = ENABLE_PEARL_STACKING.get();
        enableSnowballStacking = ENABLE_SNOWBALL_STACKING.get();
        enableHoneybottleStacking = ENABLE_HONEYBOTTLE_STACKING.get();
        enableSaddleStacking = ENABLE_SADDLE_STACKING.get();
        enableMinecartStacking = ENABLE_MINECART_STACKING.get();
        enableBoatStacking = ENABLE_BOAT_STACKING.get();
        enableEnchantedBookStacking = ENABLE_ENCHANTED_BOOK_STACKING.get();
        enableBedStacking = ENABLE_BED_STACKING.get();
        enableMusicDiscStacking = ENABLE_MUSIC_DISC_STACKING.get();
    }
}
