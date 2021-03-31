package com.jamalam360.enchantments.armor;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class SwiftEnchantment extends Enchantment {
    public SwiftEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMinPower(int level) {
        return 25;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
