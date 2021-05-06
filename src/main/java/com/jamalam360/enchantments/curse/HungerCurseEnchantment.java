package com.jamalam360.enchantments.curse;

import com.jamalam360.util.enchantment.LevelHelper;
import com.jamalam360.util.enchantment.SlotArrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class HungerCurseEnchantment extends Enchantment {
    public HungerCurseEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR, SlotArrays.ALL_ARMOR);
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
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 60, 1, false, false, false));
    }
}
