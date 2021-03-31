package com.jamalam360;

import com.jamalam360.util.EnchantmentRegistry;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
public class ExcessEnchantmentsInit implements ModInitializer {
    public static boolean isHaphazardDebugMode = false;

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "excessenchantmentsfabric";
    public static final String MOD_NAME = "Excess Enchantments";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Starting up ExcessEnchantments");
        new EnchantmentRegistry();
        log(Level.INFO, "Registered Enchantments Successfully");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

}