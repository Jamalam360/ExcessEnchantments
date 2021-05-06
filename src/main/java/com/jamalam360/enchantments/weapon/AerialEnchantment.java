package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.enchantment.LevelHelper;
import com.jamalam360.util.enchantment.SlotArrays;
import com.jamalam360.util.enchantment.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class AerialEnchantment extends CustomEnchantment {
    public AerialEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, SlotArrays.BOTH_HANDS);
    }

    @Override
    public int getMinPower(int level) {
        return LevelHelper.getSharpnesLevel(level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onTargetDamagedAlternate(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity){
            LivingEntity livingTarget = (LivingEntity) target;

            livingTarget.setVelocity(livingTarget.getVelocity().x, 0.25 * level,livingTarget.getVelocity().z);
        }
    }
}
