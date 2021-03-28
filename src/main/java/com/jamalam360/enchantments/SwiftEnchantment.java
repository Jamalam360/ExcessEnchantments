package com.jamalam360.enchantments;

import com.jamalam360.util.haphazard.HaphazardEvents;
import com.jamalam360.util.haphazard.events.HaphazardEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class SwiftEnchantment extends Enchantment {
    public SwiftEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
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
