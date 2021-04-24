package com.jamalam360.config;

import com.google.common.collect.ImmutableList;
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
        public static final ConfigItem<Boolean> AQUA_ASPECT_ENABLED = new ConfigItem<>("aquaAspect", true, "Aqua Aspect Enabled");
        public static final ConfigItem<Boolean> MARATHON_ENABLED = new ConfigItem<>("marathon", true, "Marathon Enabled");
        public static final ConfigItem<Boolean> FROST_ENABLED = new ConfigItem<>("frost", true, "Frost Enabled");
        public static final ConfigItem<Boolean> SNOW_CURSE_ENABLED = new ConfigItem<>("snowCurse", true, "Snow Curse Enabled");
        public static final ConfigItem<Boolean> BLUNT_CURSE_ENABLED = new ConfigItem<>("bluntCurse", true, "Blunt Curse Enabled");
        public static final ConfigItem<Boolean> BUTCHER_ENABLED = new ConfigItem<>("butcher", true, "Butcher Enabled");
        public static final ConfigItem<Boolean> WARP_ENABLED = new ConfigItem<>("warp", true, "Warp Enabled");
        public static final ConfigItem<Boolean> SLIPPERY_CURSE_ENABLED = new ConfigItem<>("slipperyCurse", true, "Slippery Curse Enabled");
        public static final ConfigItem<Boolean> HAPHAZARD_ENABLED = new ConfigItem<>("haphazard", true, "Haphazard Enabled");
        public static final ConfigItem<Boolean> SWIFT_ENABLED = new ConfigItem<>("swift", true, "Swift Enabled");
        public static final ConfigItem<Boolean> VAMPIRE_ENABLED = new ConfigItem<>("vampire", true, "Vampire Enabled");
        public static final ConfigItem<Boolean> ADRENALIN_ENABLED = new ConfigItem<>("adrenalin", true, "Adrenalin Enabled");
        public static final ConfigItem<Boolean> LAST_STAND_ENABLED = new ConfigItem<>("lastStand", true, "Last Stand Enabled");
        public static final ConfigItem<Boolean> HUNGER_CURSE_ENABLED = new ConfigItem<>("hungerCurse", true, "Hunger Curse Enabled");
        public static final ConfigItem<Boolean> FIRE_THORNS_ENABLED = new ConfigItem<>("fireThorns", true, "Fire Thorns Enabled");
        public static final ConfigItem<Boolean> AERIAL_ENABLED = new ConfigItem<>("aerial", true, "Aerial Enabled");
        public static final ConfigItem<Boolean> DISARM_ENABLED = new ConfigItem<>("disarm", true, "Disarm Enabled");
        public static final ConfigItem<Boolean> EMISSIVE_ENABLED = new ConfigItem<>("emissive", true, "Emissive Enabled");
        public static final ConfigItem<Boolean> STRIKE_ENABLED = new ConfigItem<>("strike", true, "Strike Enabled");
        public static final ConfigItem<Boolean> PUSHBACK_ENABLED = new ConfigItem<>("pushback", true, "Pushback Enabled");
        public static final ConfigItem<Boolean> BULLDOZER_ENABLED = new ConfigItem<>("bulldozer", true, "Bulldozer Enabled");

        public ConfigGroupEnabledEnchantments() {
            super(ImmutableList.of(AQUA_ASPECT_ENABLED, MARATHON_ENABLED, FROST_ENABLED, SNOW_CURSE_ENABLED, BLUNT_CURSE_ENABLED, BUTCHER_ENABLED,
                    WARP_ENABLED, SLIPPERY_CURSE_ENABLED, HAPHAZARD_ENABLED, SWIFT_ENABLED, VAMPIRE_ENABLED, ADRENALIN_ENABLED,
                    LAST_STAND_ENABLED, HUNGER_CURSE_ENABLED, FIRE_THORNS_ENABLED, AERIAL_ENABLED, DISARM_ENABLED, EMISSIVE_ENABLED, STRIKE_ENABLED,
                    BULLDOZER_ENABLED), "enchantments");
        }
    }
}
