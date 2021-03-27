package com.jamalam360.util.haphazard.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;

public class CreeperSoundEvent extends HaphazardEvent {
    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel){
        user.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 10f, 1.0f);
    }
}
