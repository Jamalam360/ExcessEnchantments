package com.jamalam360.enchantments.tools;

import com.jamalam360.util.SlotArrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

public class MoltenEnchantment extends Enchantment {
    public MoltenEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.DIGGER, SlotArrays.BOTH_HANDS);
    }

    @Override
    public int getMinPower(int level) {
        return 16;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
