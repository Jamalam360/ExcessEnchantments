package com.jamalam360.util.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

//Used when you want an enchantment where onTargetDamaged is only called once
public abstract class CustomEnchantment extends Enchantment {
    private boolean mojankFix = false;

    protected CustomEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        mojankFix = !mojankFix;

        if (mojankFix) {
            onTargetDamagedAlternate(user, target, level);
        }
    }

    public abstract void onTargetDamagedAlternate(LivingEntity user, Entity target, int level);
}
