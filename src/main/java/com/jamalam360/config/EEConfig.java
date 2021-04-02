package com.jamalam360.config;

import com.oroarmor.config.ConfigItem;
import com.oroarmor.config.ConfigItemGroup;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.util.List;

import static com.google.common.collect.ImmutableList.of;

public class EEConfig extends com.oroarmor.config.Config {
    public static final ConfigItemGroup mainGroup = new ConfigGroupEnabledEnchantments();

    public static final List<ConfigItemGroup> configs = of(mainGroup);

    public EEConfig() {
        super(configs, new File(FabricLoader.getInstance().getConfigDir().toFile(), "jamalam360_config_excessenchantments.json"), "jamalam360_config_excessenchantments");
    }

    public static class ConfigGroupEnabledEnchantments extends ConfigItemGroup {
        public static final ConfigItem<Boolean> aquaAspect = new ConfigItem<>("aquaAspect", true, "aquaAspectEnabled");

        public ConfigGroupEnabledEnchantments() {
            super(of(aquaAspect), "enchantments");
        }
    }
}
