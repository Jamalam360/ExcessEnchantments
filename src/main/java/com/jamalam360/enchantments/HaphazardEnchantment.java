package com.jamalam360.enchantments;

import com.jamalam360.util.haphazard.HaphazardEvents;
import com.jamalam360.util.haphazard.events.HaphazardEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class HaphazardEnchantment extends Enchantment {
    public HaphazardEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 25;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        HaphazardEvent event = HaphazardEvents.getRandomEvent();

        event.onAttack(user, target, level);

        super.onTargetDamaged(user, target, level);
    }
}
