package com.jamalam360.mixin;

import com.jamalam360.ExcessEnchantmentsInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ThornsEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ThornsEnchantment.class)
public class ThornsEnchantmentMixin extends Enchantment {
    protected ThornsEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return other != ExcessEnchantmentsInit.FIRE_THORNS;
    }
}
