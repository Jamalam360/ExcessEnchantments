package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.SlotArrays;
import com.jamalam360.util.SmiteHelper;
import com.jamalam360.util.enchantment.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import java.util.Random;

public class StrikeEnchantment extends CustomEnchantment {
    private final Random random = new Random();

    public StrikeEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, SlotArrays.BOTH_HANDS);
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
    public void onTargetDamagedAlternate(LivingEntity user, Entity target, int level) {
        double r = random.nextDouble();

        if(r < 0.08 * level){
            SmiteHelper.smiteTarget(user, target);
        }
    }
}
