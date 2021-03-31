package com.jamalam360.mixin;

import com.jamalam360.util.CustomEnchantmentHelper;
import com.jamalam360.util.EnchantmentRegistry;
import com.jamalam360.util.interfaces.ISnowy;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements ISnowy {
    private boolean isTrailingSnow = false;
    private int trailSnowRemainingTicks;

    @Override
    public boolean isTrailingSnow() {
        return this.isTrailingSnow;
    }

    @Override
    public int getRemainingTrailSnowTicks() {
        return this.trailSnowRemainingTicks;
    }

    @Override
    public void setTrailingSnow(boolean shouldTrailSnow, int time) {
        this.isTrailingSnow = shouldTrailSnow;
        if (shouldTrailSnow) {
            this.trailSnowRemainingTicks = time;
        }
    }

    @ModifyArg(
            slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSprinting()Z")),
            method = "increaseTravelMotionStats(DDD)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addExhaustion(F)V", ordinal = 0),
            index = 0
    )
    private float increaseTravelMotionStatsMixin(float output) {
        Iterable<ItemStack> armorFeetIterable = ((PlayerEntity) (Object) this).getArmorItems();
        @Nullable ItemStack armorFeet = CustomEnchantmentHelper.getArmorItemFromIterable(armorFeetIterable, EquipmentSlot.FEET);

        if (armorFeet != null) {
            if (CustomEnchantmentHelper.hasMarathon(armorFeet)) {
                return output / 2f;
            }
        }

        return output;
    }

    @Inject(at = @At("TAIL"), method = "tickMovement()V")
    public void tickMovement(CallbackInfo ci) {
        Iterable<ItemStack> armorIterable = ((PlayerEntity) (Object) this).getArmorItems();
        if (CustomEnchantmentHelper.hasSnowCurse(CustomEnchantmentHelper.getArmorItemFromIterable(armorIterable, EquipmentSlot.FEET))) {
            this.setTrailingSnow(true, 10);
        }

        if (CustomEnchantmentHelper.hasSwift(CustomEnchantmentHelper.getArmorItemFromIterable(armorIterable, EquipmentSlot.FEET))) {
            ((PlayerEntity) (Object) this).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, CustomEnchantmentHelper.getLevel(EnchantmentRegistry.SWIFT, CustomEnchantmentHelper.getArmorItemFromIterable(armorIterable, EquipmentSlot.FEET)) - 1, true, false, false));
        }

        if (this.isTrailingSnow()) {
            LivingEntity instance = ((LivingEntity) (Object) this);

            BlockState blockState = Blocks.SNOW.getDefaultState();

            int i = MathHelper.floor(instance.getX());
            int j = MathHelper.floor(instance.getY());
            int k = MathHelper.floor(instance.getZ());

            for (int l = 0; l < 4; ++l) {
                i = MathHelper.floor(instance.getX() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.floor(instance.getY());
                k = MathHelper.floor(instance.getZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockPos = new BlockPos(i, j, k);
                if (instance.world.getBlockState(blockPos).isAir() && instance.world.getBiome(blockPos).getTemperature(blockPos) < 0.8F && blockState.canPlaceAt(instance.world, blockPos)) {
                    instance.world.setBlockState(blockPos, blockState);
                }
            }
        }
    }
}
