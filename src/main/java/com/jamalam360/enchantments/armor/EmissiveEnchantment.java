package com.jamalam360.enchantments.armor;

import com.jamalam360.util.SlotArrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

public class EmissiveEnchantment extends Enchantment {
    public EmissiveEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_HEAD, SlotArrays.HEAD);
    }

    @Override
    public int getMinPower(int level) {
        return 12;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
