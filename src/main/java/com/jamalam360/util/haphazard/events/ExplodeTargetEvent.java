package com.jamalam360.util.haphazard.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.explosion.Explosion;

public class ExplodeTargetEvent extends HaphazardEvent {
    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel) {
        target.world.createExplosion(user, target.getX(), target.getY(), target.getZ(), 1.5f, Explosion.DestructionType.BREAK);
    }
}
