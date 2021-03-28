package com.jamalam360.util.haphazard;

import com.jamalam360.util.haphazard.events.*;

import java.util.Random;

public class HaphazardEvents {
    private static final Random random = new Random();

    public static final HaphazardEvent EXPLODE_TARGET_EVENT = new ExplodeTargetEvent();
    public static final HaphazardEvent EXPLODE_USER_EVENT = new ExplodeUserEvent();
    public static final HaphazardEvent DAMAGE_USER_EVENT = new DamageUserEvent();
    public static final HaphazardEvent SMITE_USER_EVENT = new SmiteTargetEvent();
    public static final HaphazardEvent CREEPER_SOUND_EVENT = new CreeperSoundEvent();
    public static final HaphazardEvent GOLDEN_APPLE_EVENT = new GoldenAppleEvent();
    public static final HaphazardEvent PIG_EVENT = new CowEvent();

    public static final HaphazardEvent[] HAPHAZARD_EVENTS = {EXPLODE_TARGET_EVENT, EXPLODE_USER_EVENT, DAMAGE_USER_EVENT, SMITE_USER_EVENT, CREEPER_SOUND_EVENT, GOLDEN_APPLE_EVENT, PIG_EVENT};

    public static HaphazardEvent getRandomEvent() {
        int rnd = random.nextInt(HAPHAZARD_EVENTS.length);
        return HAPHAZARD_EVENTS[rnd];
    }
}
