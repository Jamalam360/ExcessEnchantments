package com.jamalam360.enchantments.weapon;

import com.jamalam360.util.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Random;

public class BeheadingEnchantment extends CustomEnchantment {
    private final Random random = new Random();

    public BeheadingEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 16;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onTargetDamagedAlternate(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity && !target.isAlive()){
            double r = random.nextDouble();

            if(r < 0.08){
                ItemEntity itemEntity = new ItemEntity(target.world, target.getX(), target.getEyeY(), target.getZ(), new ItemStack(Items));
                target.world.spawnEntity(itemEntity);
            }
        }
    }
}
