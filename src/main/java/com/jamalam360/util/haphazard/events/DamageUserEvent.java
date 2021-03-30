package com.jamalam360.util.haphazard.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import java.util.Random;

public class DamageUserEvent extends HaphazardEvent {
    private final Random random = new Random();

    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel) {
        user.damage(DamageSource.GENERIC, random.nextInt(10));
    }
}
