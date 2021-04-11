package com.jamalam360.enchantments.tools;

import com.jamalam360.util.SlotArrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

public class BulldozerEnchantment extends Enchantment {
    public BulldozerEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, SlotArrays.BOTH_HANDS);
    }

    @Override
    public int getMinPower(int level) {
        return 26;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
