package com.jamalam360.util.haphazard;

import com.jamalam360.util.haphazard.events.*;

import java.util.Random;

public class HaphazardEvents {
    public static final HaphazardEvent EXPLODE_TARGET_EVENT = new ExplodeTargetEvent();
    public static final HaphazardEvent EXPLODE_USER_EVENT = new ExplodeUserEvent();
    public static final HaphazardEvent DAMAGE_USER_EVENT = new DamageUserEvent();
    public static final HaphazardEvent SMITE_USER_EVENT = new SmiteUserEvent();
    public static final HaphazardEvent CREEPER_SOUND_EVENT = new CreeperSoundEvent();

    public static final HaphazardEvent[] HAPHAZARD_EVENTS = {EXPLODE_TARGET_EVENT, EXPLODE_USER_EVENT, DAMAGE_USER_EVENT, SMITE_USER_EVENT, CREEPER_SOUND_EVENT};

    public static HaphazardEvent getRandomEvent() {
        int rnd = new Random().nextInt(HAPHAZARD_EVENTS.length);
        return HAPHAZARD_EVENTS[rnd];
    }
}
