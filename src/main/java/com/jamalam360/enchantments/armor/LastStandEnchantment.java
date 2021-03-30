package com.jamalam360.enchantments.armor;

import com.jamalam360.util.ITeleportRandom;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LastStandEnchantment extends Enchantment {
    public LastStandEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    @Override
    public int getMinPower(int level) {
        return 26;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user.getHealth() <= 2f) { //If lower than or equal to 1 heart
            ((ITeleportRandom) user).teleport();
        }
    }
}
