package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.SlotArrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class VampireEnchantment extends Enchantment {
    public VampireEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, SlotArrays.BOTH_HANDS);
    }

    @Override
    public int getMinPower(int level) {
        return 25;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!target.isAlive()) {
            user.setHealth(user.getHealth() + (0.5f * level));
        }
    }
}
