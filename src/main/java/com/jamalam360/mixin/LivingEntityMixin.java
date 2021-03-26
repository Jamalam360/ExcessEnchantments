package com.jamalam360.mixin;

import com.jamalam360.util.ISnowy;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements ISnowy {
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

    @Inject(at = @At("TAIL"), method = "tickMovement()V")
    public void tickMovement(CallbackInfo ci){
        if(isTrailingSnow()){
            if(this.trailSnowRemainingTicks <= 0){
                this.setTrailingSnow(false, 0);
                return;
            } else{
                trailSnowRemainingTicks--;
            }

            LivingEntity instance = ((LivingEntity) (Object) this);

            BlockState blockState = Blocks.SNOW.getDefaultState();

            int i = MathHelper.floor(instance.getX());
            int j = MathHelper.floor(instance.getY());
            int k = MathHelper.floor(instance.getZ());

            for(int l = 0; l < 4; ++l) {
                i = MathHelper.floor(instance.getX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.floor(instance.getY());
                k = MathHelper.floor(instance.getZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockPos = new BlockPos(i, j, k);
                if (instance.world.getBlockState(blockPos).isAir() && instance.world.getBiome(blockPos).getTemperature(blockPos) < 0.8F && blockState.canPlaceAt(instance.world, blockPos)) {
                    instance.world.setBlockState(blockPos, blockState);
                }
            }
        }
    }
}
