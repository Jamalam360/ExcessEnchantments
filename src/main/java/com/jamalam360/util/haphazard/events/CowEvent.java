package com.jamalam360.util.haphazard.events;

import com.jamalam360.ExcessEnchantmentsInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import org.apache.logging.log4j.Level;

public class CowEvent extends HaphazardEvent {
    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel){
        for (int i = 0; i < 5; i++) {
            CowEntity cow = EntityType.COW.create(user.world);
            try {
                cow.teleport(user.getX(), user.getY(), user.getZ());
            } catch (Exception e) {
                ExcessEnchantmentsInit.log(Level.WARN, "Caught a NullPointerException handling CowEvent. In most cases this can be ignored");
            }
        }
    }
}
