package com.jamalam360;

import com.jamalam360.util.EnchantmentRegistry;
import com.jamalam360.util.githubversionchecker.VersionChecker;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
public class ExcessEnchantmentsInit implements ModInitializer {
    public static boolean isHaphazardDebugMode = false;

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "excessenchantmentsfabric";
    public static final String MOD_NAME = "Excess Enchantments";
    public static final String MOD_VERSION = "1.0.0";

    public static boolean versionCorrect = true;

    @Override
    public void onInitialize() {
        try {
            String strRemote = VersionChecker.getGithubResponse();

            versionCorrect = strRemote.trim().equals(MOD_VERSION);

            if(versionCorrect){
                log(Level.INFO, "Excess Enchantments version is up to date!");
            } else {
                log(Level.WARN, "Excess Enchantments is out of date. Latest version is " + strRemote + " while you have version " + MOD_VERSION);
            }
        } catch (Throwable throwable) {
            log(Level.WARN, throwable.toString());
        }

        log(Level.INFO, "Starting up ExcessEnchantments");

        EnchantmentRegistry enchantmentRegistry = new EnchantmentRegistry();
        Class enchantmentRegistryClass = enchantmentRegistry.getClass();
        Field[] fieldList=enchantmentRegistryClass.getDeclaredFields();


        log(Level.INFO, "Registered " + fieldList.length + " Enchantments Successfully");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

}