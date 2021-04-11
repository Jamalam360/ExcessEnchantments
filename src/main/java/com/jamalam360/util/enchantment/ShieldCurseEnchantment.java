package com.jamalam360.util.enchantment;

import me.crimsondawn45.fabricshieldlib.lib.event.ShieldEvent;
import me.crimsondawn45.fabricshieldlib.lib.object.ShieldEnchantment;

public class ShieldCurseEnchantment extends ShieldEnchantment {
    public ShieldCurseEnchantment(Rarity weight, ShieldEvent event) {
        super(weight, event);
    }

    @Override
    public boolean isCursed(){
        return true;
    }

    @Override
    public boolean isTreasure(){
        return true;
    }
}
