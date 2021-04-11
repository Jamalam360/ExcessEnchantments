package com.jamalam360.util;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class JeffHelper {
    public static ZombieEntity getJeff(World world){
        ZombieEntity jeff = new ZombieEntity(world);

        ItemStack head = new ItemStack(Items.DIAMOND_HELMET);
        head.addEnchantment(Enchantments.PROTECTION, 4);
        head.addEnchantment(Enchantments.MENDING, 1);
        head.addEnchantment(Enchantments.UNBREAKING, 3);
        head.addEnchantment(Enchantments.THORNS, 3);

        head.addEnchantment(Enchantments.RESPIRATION, 3);
        head.addEnchantment(Enchantments.AQUA_AFFINITY, 1);

        ItemStack chest = new ItemStack(Items.DIAMOND_CHESTPLATE);
        head.addEnchantment(Enchantments.PROTECTION, 4);
        head.addEnchantment(Enchantments.MENDING, 1);
        head.addEnchantment(Enchantments.UNBREAKING, 3);
        head.addEnchantment(Enchantments.THORNS, 3);

        ItemStack legs = new ItemStack(Items.DIAMOND_LEGGINGS);
        head.addEnchantment(Enchantments.PROTECTION, 4);
        head.addEnchantment(Enchantments.MENDING, 1);
        head.addEnchantment(Enchantments.UNBREAKING, 3);
        head.addEnchantment(Enchantments.THORNS, 3);

        ItemStack feet = new ItemStack(Items.DIAMOND_BOOTS);
        head.addEnchantment(Enchantments.PROTECTION, 4);
        head.addEnchantment(Enchantments.MENDING, 1);
        head.addEnchantment(Enchantments.UNBREAKING, 3);
        head.addEnchantment(Enchantments.THORNS, 3);

        head.addEnchantment(Enchantments.DEPTH_STRIDER, 3);
        head.addEnchantment(Enchantments.FROST_WALKER, 2);
        head.addEnchantment(Enchantments.FEATHER_FALLING, 4);


        ItemStack mainhand = new ItemStack(Items.DIAMOND_SWORD);
        head.addEnchantment(Enchantments.SHARPNESS, 5);
        head.addEnchantment(Enchantments.SWEEPING, 3);
        head.addEnchantment(Enchantments.LOOTING, 3);
        head.addEnchantment(Enchantments.UNBREAKING, 3);
        head.addEnchantment(Enchantments.MENDING, 1);
        head.addEnchantment(Enchantments.FIRE_ASPECT, 2);

        ItemStack offhand = new ItemStack(Items.SHIELD);
        head.addEnchantment(Enchantments.UNBREAKING, 3);
        head.addEnchantment(Enchantments.MENDING, 1);


        jeff.equipStack(EquipmentSlot.HEAD, head);
        jeff.equipStack(EquipmentSlot.CHEST, chest);
        jeff.equipStack(EquipmentSlot.LEGS, legs);
        jeff.equipStack(EquipmentSlot.FEET, feet);
        jeff.equipStack(EquipmentSlot.MAINHAND, mainhand);
        jeff.equipStack(EquipmentSlot.OFFHAND, offhand);

        return jeff;
    }
}
