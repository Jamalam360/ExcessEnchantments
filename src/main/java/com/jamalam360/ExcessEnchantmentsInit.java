package com.jamalam360;

import com.jamalam360.enchantments.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
public class ExcessEnchantmentsInit implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "excessenchantmentsfabric";
    public static final String MOD_NAME = "Excess Enchantments";

    public static Enchantment AQUA_ASPECT = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "aqua_aspect"),
            new AquaAspectEnchantment()
    );

    public static Enchantment MARATHON = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "marathon"),
            new MarathonEnchantment()
    );

    public static Enchantment FROST = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "frost"),
            new FrostEnchantment()
    );

    public static Enchantment SNOW_CURSE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "snow_curse"),
            new SnowCurseEnchantment()
    );

    public static Enchantment BLUNT_CURSE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "blunt_curse"),
            new BluntCurseEnchantment()
    );

    public static Enchantment BUTCHER = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "butcher"),
            new ButcherEnchantment()
    );

    public static Enchantment WARP = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "warp"),
            new WarpEnchantment()
    );

    public static Enchantment SLIPPERY_CURSE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "slippery_curse"),
            new SlipperyCurseEnchantment()
    );

    public static Enchantment HAPHAZARD = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "haphazard"),
            new HaphazardEnchantment()
    );

    public static Enchantment SWIFT = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "swift"),
            new SwiftEnchantment()
    );

    public static Enchantment VAMPIRE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "vampire"),
            new VampireEnchantment()
    );

    public static Enchantment ADRENALIN = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "adrenalin"),
            new AdrenalinEnchantment()
    );

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}