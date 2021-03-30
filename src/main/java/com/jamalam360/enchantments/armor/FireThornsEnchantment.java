package com.jamalam360.enchantments.armor;

import com.jamalam360.ExcessEnchantmentsInit;
import net.minecraft.enchantment.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class FireThornsEnchantment extends Enchantment {
    public FireThornsEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public int getMinPower(int level) {
        return 24;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return other != Enchantments.THORNS;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Random random = user.getRandom();
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(ExcessEnchantmentsInit.FIRE_THORNS, user);
        if (shouldDamageAttacker(level, random)) {
            if (attacker != null) {
                attacker.setOnFireFor(level);
            }

            if (entry != null) {
                (entry.getValue()).damage(2, user, (Consumer) ((livingEntity) -> ((LivingEntity) livingEntity).sendEquipmentBreakStatus(entry.getKey())));
            }
        }

    }

    public static boolean shouldDamageAttacker(int level, Random random) {
        if (level <= 0) {
            return false;
        } else {
            return random.nextFloat() < 0.15F * (float) level;
        }
    }
}
