package com.jamalam360.mixin.entitygroup;

import com.jamalam360.util.CustomEntityGroup;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlazeEntity.class)
public abstract class BlazeEntityMixin extends HostileEntity {
    protected BlazeEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public EntityGroup getGroup() {
        return CustomEntityGroup.HURT_BY_WATER;
    }
}
