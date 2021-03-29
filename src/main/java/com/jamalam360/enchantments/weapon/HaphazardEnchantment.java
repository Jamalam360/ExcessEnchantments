package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.CustomEnchantment;
import com.jamalam360.util.haphazard.HaphazardEvents;
import com.jamalam360.util.haphazard.events.HaphazardEvent;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class HaphazardEnchantment extends CustomEnchantment {
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
    public void onTargetDamagedAlternate(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            System.out.println("Server");
            HaphazardEvent eventServerSide = HaphazardEvents.getRandomEvent();
            eventServerSide.onAttack(user, target, level);
        }
    }
}
