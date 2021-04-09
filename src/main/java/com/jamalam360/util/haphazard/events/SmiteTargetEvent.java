package com.jamalam360.util.haphazard.events;

import com.jamalam360.util.SmiteHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class SmiteTargetEvent extends HaphazardEvent {
    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel) {
        SmiteHelper.smiteTarget(user, target);
    }
}
