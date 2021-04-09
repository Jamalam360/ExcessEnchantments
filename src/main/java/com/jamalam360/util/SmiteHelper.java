package com.jamalam360.util;

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

public class SmiteHelper {
    private static final SoundEvent SOUND_EVENT = SoundEvents.ITEM_TRIDENT_THUNDER;

    public static void smiteTarget(LivingEntity user, Entity target) {
        if (!user.world.isClient) {
            BlockPos blockPos = target.getBlockPos();
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(target.world);
            try {
                lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
            } catch (Exception e) {
                ExcessEnchantmentsInit.log(Level.WARN, "Caught a NullPointerException handling SmiteUserEvent. In most cases this can be ignored");
            }
            if (user instanceof PlayerEntity) {
                lightningEntity.setChanneler((ServerPlayerEntity) user);
            }

            target.world.spawnEntity(lightningEntity);

            target.playSound(SOUND_EVENT, 5.0F, 1.0F);
        }
    }
}
