package com.jamalam360.util.haphazard;

import com.jamalam360.ExcessEnchantmentsInit;
import com.jamalam360.util.haphazard.events.*;
import net.minecraft.text.LiteralText;
import org.apache.logging.log4j.Level;

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

        if(ExcessEnchantmentsInit.isHaphazardDebugMode){
            ExcessEnchantmentsInit.log(Level.INFO, new LiteralText("The selected haphazard event is " + HAPHAZARD_EVENTS[rnd].toString() + ". You are seeing this message because you have enabled Haphazard debug mode using /haphazarddebug true").getString());
        }

        return HAPHAZARD_EVENTS[rnd];
    }
}
