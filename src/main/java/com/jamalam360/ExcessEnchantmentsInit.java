package com.jamalam360;

import com.jamalam360.config.EEConfig;
import com.jamalam360.util.EnchantmentRegistry;
import com.jamalam360.util.githubversionchecker.VersionChecker;
import com.oroarmor.config.Config;
import com.oroarmor.config.command.ConfigCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
public class ExcessEnchantmentsInit implements ModInitializer {
    public static boolean isHaphazardDebugMode = false;

    public static Config CONFIG = new EEConfig();
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "excessenchantmentsfabric";
    public static final String MOD_NAME = "Excess Enchantments";
    public static final String MOD_VERSION = "1.1.0";
    public static String remoteModVersion;

    public static boolean versionCorrect = true;

    @Override
    public void onInitialize() {
        try {
            remoteModVersion = VersionChecker.getGithubResponse();

            versionCorrect = remoteModVersion.trim().equals(MOD_VERSION);

            if(versionCorrect){
                log(Level.INFO, "Excess Enchantments version is up to date!");
            } else {
                log(Level.WARN, "Excess Enchantments is out of date. Latest version is " + remoteModVersion + " while you have version " + MOD_VERSION);
            }
        } catch (Throwable throwable) {
            log(Level.WARN, throwable.toString());
        }

        log(Level.INFO, "Starting up ExcessEnchantments");

        EnchantmentRegistry enchantmentRegistry = new EnchantmentRegistry();
        Class enchantmentRegistryClass = enchantmentRegistry.getClass();
        Field[] fieldList=enchantmentRegistryClass.getDeclaredFields();

        CONFIG.readConfigFromFile();
        ServerLifecycleEvents.SERVER_STOPPED.register(instance -> CONFIG.saveConfigToFile());
        CommandRegistrationCallback.EVENT.register(new ConfigCommand(CONFIG)::register);

        log(Level.INFO, "Registered " + fieldList.length + " Enchantments Successfully");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

}