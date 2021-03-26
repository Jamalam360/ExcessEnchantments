package com.jamalam360.mixin;

import com.jamalam360.util.CustomEntityGroup;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MagmaCubeEntity.class)
public abstract class MagmaCubeEntityMixin extends SlimeEntity {
    public MagmaCubeEntityMixin(EntityType<? extends SlimeEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public EntityGroup getGroup() {
        return CustomEntityGroup.HURT_BY_WATER;
    }
}
