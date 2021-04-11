package com.jamalam360.enchantments.shield;

import me.crimsondawn45.fabricshieldlib.lib.event.ShieldEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

public class PushbackEvent extends ShieldEvent {
    public PushbackEvent(){
        super(true, false, false);
    }

    @Override
    public void onBlockDamage(LivingEntity defender, DamageSource source, float amount, int level, Hand hand, ItemStack shield){

        //When shield blocks damage reflect 50% of the damage back to the attacker
        Entity attacker = source.getAttacker();

        if(attacker instanceof LivingEntity && !(attacker.getType().equals(EntityType.SKELETON))) {
            LivingEntity attackerLiving = (LivingEntity) attacker;
            double h = defender.getX() - attackerLiving.getX();

            double i;
            for(i = defender.getZ() - attackerLiving.getZ(); h * h + i * i < 1.0E-4D; i = (Math.random() - Math.random()) * 0.01D) {
                h = (Math.random() - Math.random()) * 0.01D;
            }

            attackerLiving.knockbackVelocity = (float)(MathHelper.atan2(i, h) * 57.2957763671875D - (double)attackerLiving.yaw);
            attackerLiving.takeKnockback(0.6F, h, i);
        }
    }
}
