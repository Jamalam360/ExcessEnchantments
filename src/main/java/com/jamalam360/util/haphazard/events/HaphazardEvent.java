package com.jamalam360.util.haphazard.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public abstract class HaphazardEvent {
    public void onAttack(LivingEntity user, Entity target, int enchantLevel) {
    }
}
