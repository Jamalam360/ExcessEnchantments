package com.jamalam360.util.enchantment;

import me.crimsondawn45.fabricshieldlib.lib.event.ShieldEvent;
import me.crimsondawn45.fabricshieldlib.lib.object.ShieldEnchantment;
import net.minecraft.item.Item;

public class ShieldCurseEnchantment extends ShieldEnchantment {
    public ShieldCurseEnchantment(Rarity weight, ShieldEvent event, Item item) {
        super(weight, event, item);
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
