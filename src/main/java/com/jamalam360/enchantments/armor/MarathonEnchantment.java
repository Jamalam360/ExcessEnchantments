package com.jamalam360.enchantments.armor;

import com.jamalam360.util.enchantment.LevelHelper;
import com.jamalam360.util.enchantment.SlotArrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

public class MarathonEnchantment extends Enchantment {
    public MarathonEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_FEET, SlotArrays.FEET);
    }

    @Override
    public int getMinPower(int level) {
        return LevelHelper.getFeatherFallingLevel(level);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
