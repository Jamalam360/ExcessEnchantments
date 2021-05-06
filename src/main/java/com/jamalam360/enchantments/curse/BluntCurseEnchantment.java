package com.jamalam360.enchantments.curse;

import com.jamalam360.util.enchantment.LevelHelper;
import com.jamalam360.util.enchantment.SlotArrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;

public class BluntCurseEnchantment extends Enchantment {
    public BluntCurseEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, SlotArrays.BOTH_HANDS);
    }

    @Override
    public int getMinPower(int level) {
        return LevelHelper.getCurseLevel(level);
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return -5f;
    }
}
