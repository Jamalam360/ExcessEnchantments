package com.jamalam360.enchantments.curse;

import com.jamalam360.util.SlotArrays;
import com.jamalam360.util.enchantment.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;

import java.util.Random;

public class JeffCurseEnchantment extends CustomEnchantment {
    private final Random random = new Random();

    public JeffCurseEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.BREAKABLE, SlotArrays.ALL);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public void onTargetDamagedAlternate(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            if (user instanceof PlayerEntity) {
                double r = random.nextDouble();

                if (r < 0.01) {
                    ((PlayerEntity) user).sendMessage(new LiteralText("The sun fades as Jeff wakes from his slumber..."), false);

                    for (ServerWorld serverWorld : user.world.getServer().getWorlds()) {
                        serverWorld.setTimeOfDay(18000);
                    }
                }
            }
        }
    }
}
