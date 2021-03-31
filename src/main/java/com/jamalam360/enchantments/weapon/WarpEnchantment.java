package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.interfaces.ITeleportRandom;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

import java.util.Random;

public class WarpEnchantment extends Enchantment {
    Random random = new Random();

    public WarpEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            double r = random.nextDouble();

            if (r < 0.25) {
                ((ITeleportRandom) target).teleport();
            }
        }
    }
}
