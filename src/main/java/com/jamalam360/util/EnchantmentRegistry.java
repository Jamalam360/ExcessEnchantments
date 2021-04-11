package com.jamalam360.util;

import com.jamalam360.ExcessEnchantmentsInit;
import com.jamalam360.enchantments.armor.*;
import com.jamalam360.enchantments.curse.BluntCurseEnchantment;
import com.jamalam360.enchantments.curse.HungerCurseEnchantment;
import com.jamalam360.enchantments.curse.SlipperyCurseEnchantment;
import com.jamalam360.enchantments.curse.SnowCurseEnchantment;
import com.jamalam360.enchantments.shield.PushbackEvent;
import com.jamalam360.enchantments.tools.BulldozerEnchantment;
import com.jamalam360.enchantments.weapon.*;
import com.oroarmor.config.Config;
import com.oroarmor.config.ConfigItem;
import me.crimsondawn45.fabricshieldlib.lib.object.ShieldEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import static net.minecraft.util.registry.Registry.ENCHANTMENT;
import static net.minecraft.util.registry.Registry.register;
import static com.jamalam360.config.EEConfig.ConfigGroupEnabledEnchantments;

public class EnchantmentRegistry {
    private static final String MOD_ID = ExcessEnchantmentsInit.MOD_ID;
    private final Config CONFIG = ExcessEnchantmentsInit.CONFIG;

    public static Enchantment AQUA_ASPECT;
    public static Enchantment MARATHON;
    public static Enchantment FROST;
    public static Enchantment SNOW_CURSE;
    public static Enchantment BLUNT_CURSE;
    public static Enchantment BUTCHER;
    public static Enchantment WARP;
    public static Enchantment SLIPPERY_CURSE;
    public static Enchantment HAPHAZARD;
    public static Enchantment SWIFT;
    public static Enchantment VAMPIRE;
    public static Enchantment ADRENALIN;
    public static Enchantment LAST_STAND;
    public static Enchantment HUNGER_CURSE;
    public static Enchantment FIRE_THORNS;
    public static Enchantment AERIAL;
    public static Enchantment DISARM;
    public static Enchantment EMISSIVE;
    public static Enchantment STRIKE;
    public static Enchantment PUSHBACK;
    public static Enchantment BULLDOZER;

    public void registerEnchantments() {
        CONFIG.readConfigFromFile();

        if(getValue(ConfigGroupEnabledEnchantments.AQUA_ASPECT_ENABLED)) {
            AQUA_ASPECT = register(
                    ENCHANTMENT,
                    idOf("aqua_aspect"),
                    new AquaAspectEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.MARATHON_ENABLED)) {
            MARATHON = register(
                    ENCHANTMENT,
                    idOf("marathon"),
                    new MarathonEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.FROST_ENABLED)) {
            FROST = register(
                    ENCHANTMENT,
                    idOf("frost"),
                    new FrostEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.SNOW_CURSE_ENABLED)) {
            SNOW_CURSE = register(
                    ENCHANTMENT,
                    idOf("snow_curse"),
                    new SnowCurseEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.BLUNT_CURSE_ENABLED)) {
            BLUNT_CURSE = register(
                    ENCHANTMENT,
                    idOf("blunt_curse"),
                    new BluntCurseEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.BUTCHER_ENABLED)) {
            BUTCHER = register(
                    ENCHANTMENT,
                    idOf("butcher"),
                    new ButcherEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.WARP_ENABLED)) {
            WARP = register(
                    ENCHANTMENT,
                    idOf("warp"),
                    new WarpEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.SLIPPERY_CURSE_ENABLED)) {
            SLIPPERY_CURSE = register(
                    ENCHANTMENT,
                    idOf("slippery_curse"),
                    new SlipperyCurseEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.HAPHAZARD_ENABLED)) {
            HAPHAZARD = register(
                    ENCHANTMENT,
                    idOf("haphazard"),
                    new HaphazardEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.SWIFT_ENABLED)) {
            SWIFT = register(
                    ENCHANTMENT,
                    idOf("swift"),
                    new SwiftEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.VAMPIRE_ENABLED)) {
            VAMPIRE = register(
                    ENCHANTMENT,
                    idOf("vampire"),
                    new VampireEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.ADRENALIN_ENABLED)) {
            ADRENALIN = register(
                    ENCHANTMENT,
                    idOf("adrenalin"),
                    new AdrenalinEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.LAST_STAND_ENABLED)) {
            LAST_STAND = register(
                    ENCHANTMENT,
                    idOf("last_stand"),
                    new LastStandEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.HUNGER_CURSE_ENABLED)) {
            HUNGER_CURSE = register(
                    ENCHANTMENT,
                    idOf("hunger_curse"),
                    new HungerCurseEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.FIRE_THORNS_ENABLED)) {
            FIRE_THORNS = register(
                    ENCHANTMENT,
                    idOf("fire_thorns"),
                    new FireThornsEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.AERIAL_ENABLED)) {
            AERIAL = register(
                    ENCHANTMENT,
                    idOf("aerial"),
                    new AerialEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.AERIAL_ENABLED)) {
            DISARM = register(
                    ENCHANTMENT,
                    idOf("disarm"),
                    new DisarmEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.EMISSIVE_ENABLED)) {
            EMISSIVE = register(
                    ENCHANTMENT,
                    idOf("emissive"),
                    new EmissiveEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.STRIKE_ENABLED)) {
            STRIKE = register(
                    ENCHANTMENT,
                    idOf("strike"),
                    new StrikeEnchantment()
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.PUSHBACK_ENABLED)) {
            PUSHBACK = register(
                    ENCHANTMENT,
                    idOf("pushback"),
                    new ShieldEnchantment(Enchantment.Rarity.UNCOMMON, new PushbackEvent(), Items.SHIELD)
            );
        }

        if(getValue(ConfigGroupEnabledEnchantments.BULLDOZER_ENABLED)) {
            BULLDOZER = register(
                    ENCHANTMENT,
                    idOf("bulldozer"),
                    new BulldozerEnchantment()
            );
        }
    }

    public Identifier idOf(String name){
        return new Identifier(MOD_ID, name);
    }

    public boolean getValue(ConfigItem<Boolean> item){
        return item.getValue();
    }
}
