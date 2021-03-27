package com.jamalam360.util.haphazard.events;

import com.jamalam360.ExcessEnchantmentsInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.apache.logging.log4j.Level;

public class SmiteUserEvent extends HaphazardEvent {
    private final SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_THUNDER;

    @Override
    public void onAttack(LivingEntity user, Entity target, int enchantLevel){
        if(!user.world.isClient) {
            BlockPos blockPos = user.getBlockPos();
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(user.world);
            try {
                lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
            } catch (Exception e) {
                ExcessEnchantmentsInit.log(Level.WARN, "Caught a NullPointerException handling SmiteUserEvent. In most cases this can be ignored");
            }
            if(user instanceof PlayerEntity){
                lightningEntity.setChanneler((ServerPlayerEntity) user);
            }

            user.world.spawnEntity(lightningEntity);

            target.playSound(soundEvent, 5.0F, 1.0F);
        }
    }
}
