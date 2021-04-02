package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

import java.util.Random;

public class DisarmEnchantment extends CustomEnchantment {
    private final Random random = new Random();

    public DisarmEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
    public void onTargetDamagedAlternate(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity){
            double r = random.nextDouble();

            if(r < 0.1){
                target.dropStack(((LivingEntity) target).getMainHandStack());
                ((LivingEntity) target).setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
            }
        }
    }
}
