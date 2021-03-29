package com.jamalam360.enchantments.weapon;

import com.jamalam360.enchantments.weapon.AquaAspectEnchantment;
import com.jamalam360.util.CustomEntityGroup;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;

public class ButcherEnchantment extends Enchantment {
    public ButcherEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level){
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxLevel(){
        return 5;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group){
        if(group == CustomEntityGroup.ANIMALS){
            System.out.println("YES");
            return (float)level * 2.5F;
        } else{
            return 0f;
        }
    }

    public boolean canAccept(Enchantment other) {
        if(other instanceof DamageEnchantment){
            return false;
        } else return !(other instanceof AquaAspectEnchantment);
    }
}
