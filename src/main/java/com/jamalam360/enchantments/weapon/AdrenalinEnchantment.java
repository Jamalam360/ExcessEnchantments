package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class AdrenalinEnchantment extends CustomEnchantment {
    public AdrenalinEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level){
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxLevel(){
        return 3;
    }

    @Override
    public void onTargetDamagedAlternate(LivingEntity user, Entity target, int level) {
            if (user.getHealth() < user.getMaxHealth() * 0.3) { //If user has less than 30% of their full health
                target.damage(DamageSource.GENERIC, this.getAttackDamage(level, ((LivingEntity) target).getGroup()) * 1.5f);
                System.out.println("TEST");
            }
    }
}
