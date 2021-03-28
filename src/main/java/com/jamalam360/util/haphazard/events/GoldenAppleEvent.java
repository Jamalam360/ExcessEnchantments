package com.jamalam360.util.haphazard.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class GoldenAppleEvent extends HaphazardEvent{
    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel){
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 5, 1, false, false, false));
    }
}
