package com.jamalam360.util;

import com.jamalam360.ExcessEnchantmentsInit;
import com.jamalam360.enchantments.armor.FireThornsEnchantment;
import com.jamalam360.enchantments.armor.LastStandEnchantment;
import com.jamalam360.enchantments.armor.MarathonEnchantment;
import com.jamalam360.enchantments.armor.SwiftEnchantment;
import com.jamalam360.enchantments.curse.BluntCurseEnchantment;
import com.jamalam360.enchantments.curse.HungerCurseEnchantment;
import com.jamalam360.enchantments.curse.SlipperyCurseEnchantment;
import com.jamalam360.enchantments.curse.SnowCurseEnchantment;
import com.jamalam360.enchantments.weapon.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class EnchantmentRegistry {
    private static final String MOD_ID = ExcessEnchantmentsInit.MOD_ID;

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

    public static Enchantment LAST_STAND = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "last_stand"),
            new LastStandEnchantment()
    );

    public static Enchantment HUNGER_CURSE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "hunger_curse"),
            new HungerCurseEnchantment()
    );

    public static Enchantment FIRE_THORNS = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "fire_thorns"),
            new FireThornsEnchantment()
    );

    public static Enchantment AERIAL = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "aerial"),
            new AerialEnchantment()
    );

}
