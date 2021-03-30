package com.jamalam360.util.haphazard.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.explosion.Explosion;

public class ExplodeUserEvent extends HaphazardEvent {
    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel) {
        user.world.createExplosion(null, user.getX(), user.getY(), user.getZ(), 1.5f, Explosion.DestructionType.BREAK);
    }
}
