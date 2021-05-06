package com.jamalam360.util.enchantment;

/**
 * @author Jamalam360
 */
public class LevelHelper {
    public static int getSharpnesLevel(int level){
        return 1 + (level - 1) * 11;
    }

    public static int getProtLevel(int level){
        return 3 + (level - 1) * 6;
    }

    public static int getThornsLevel(int level){
        return 10 + 20 * (level - 1);
    }

    public static int getFeatherFallingLevel(int level){
        return 5 + (level - 1) * 6;
    }

    public static int getCurseLevel(int level){
        return 25;
    }

    public static int getEfficiencyLevel(int level){
        return 1 + 10 * (level - 1);
    }
}
