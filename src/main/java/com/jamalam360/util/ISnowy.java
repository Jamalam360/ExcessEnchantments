package com.jamalam360.util;

public interface ISnowy {
    boolean isTrailingSnow();
    int getRemainingTrailSnowTicks();
    void setTrailingSnow(boolean shouldTrailSnow, int trailSnowTime);
}
