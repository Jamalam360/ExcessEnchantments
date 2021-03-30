package com.jamalam360.util;

import com.jamalam360.ExcessEnchantmentsInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

public class CustomEnchantmentHelper {
    public static int getLevel(Enchantment enchantment, @Nullable ItemStack stack) {
        if (stack != null) {
            if (stack.isEmpty()) {
                return 0;
            } else {
                Identifier identifier = Registry.ENCHANTMENT.getId(enchantment);
                ListTag listTag = stack.getEnchantments();

                for (int i = 0; i < listTag.size(); ++i) {
                    CompoundTag compoundTag = listTag.getCompound(i);
                    Identifier identifier2 = Identifier.tryParse(compoundTag.getString("id"));
                    if (identifier2 != null && identifier2.equals(identifier)) {
                        return MathHelper.clamp(compoundTag.getInt("lvl"), 0, 255);
                    }
                }

                return 0;
            }
        } else {
            return 0;
        }
    }

    @Nullable
    public static ItemStack getArmorItemFromIterable(Iterable<ItemStack> stackList, EquipmentSlot target) {
        for (ItemStack stack : stackList) {
            if (stack.getItem() instanceof ArmorItem) {
                if (((ArmorItem) stack.getItem()).getSlotType() == target) {
                    return stack;
                }
            }
        }

        return null;
    }

    public static boolean hasAquaAspect(ItemStack stack) {
        return getLevel(ExcessEnchantmentsInit.AQUA_ASPECT, stack) > 0;
    }

    public static boolean hasMarathon(ItemStack stack) {
        return getLevel(ExcessEnchantmentsInit.MARATHON, stack) > 0;
    }

    public static boolean hasSnowCurse(ItemStack stack) {
        return getLevel(ExcessEnchantmentsInit.SNOW_CURSE, stack) > 0;
    }

    public static boolean hasSwift(ItemStack stack) {
        return getLevel(ExcessEnchantmentsInit.SWIFT, stack) > 0;
    }
}
