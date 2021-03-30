package com.jamalam360.util;

//Allows entities that implement this interface to trail snow like a snow golem. This is a duck interface
public interface ISnowy {
    boolean isTrailingSnow();

    int getRemainingTrailSnowTicks();

    /**
     * @param shouldTrailSnow "Whether the entity should trail snow"
     * @param trailSnowTime   "How long the entity should trail snow for, ignored if shouldTrailSnow is false"
     */
    void setTrailingSnow(boolean shouldTrailSnow, int trailSnowTime);
}
