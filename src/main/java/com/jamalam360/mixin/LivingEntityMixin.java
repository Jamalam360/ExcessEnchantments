package com.jamalam360.mixin;

import com.jamalam360.util.IArmorInvisible;
import com.jamalam360.util.ISnowy;
import com.jamalam360.util.ITeleportRandom;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ISnowy, ITeleportRandom {
    @Shadow private boolean effectsChanged;
    private boolean isTrailingSnow = false;
    private int trailSnowRemainingTicks;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

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

    @Inject(at = @At("HEAD"), method = "onEquipStack(Lnet/minecraft/item/ItemStack;)V")
    public void onEquipStack(ItemStack stack, CallbackInfo ci){
        LivingEntity instance = ((LivingEntity) (Object) this);

        System.out.println("onEquipStack");
        if(!instance.world.isClient) {
            if (stack.getItem() instanceof ArmorItem) {
                ((IArmorInvisible) instance).setVisible(true);
                System.out.println("LIVING ENTITY");
            } else if (stack.isEmpty()) {
                ((IArmorInvisible) instance).setVisible(false);
            }
        }
    }

    @Inject(at = @At("TAIL"), method = "tickMovement()V")
    public void tickMovement(CallbackInfo ci) {
        if (isTrailingSnow()) {
            if (this.trailSnowRemainingTicks <= 0) {
                this.setTrailingSnow(false, 0);
                return;
            } else {
                trailSnowRemainingTicks--;
            }

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

    @Override
    public void teleport() {
        this.teleportRandomly();
    }

    private boolean teleportRandomly() {
        LivingEntity instance = ((LivingEntity) (Object) this);

        if (!this.world.isClient() && this.isAlive()) {
            double d = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
            double e = this.getY() + (double) (this.random.nextInt(64) - 32);
            double f = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
            return this.teleportTo(d, e, f);
        } else {
            return false;
        }
    }

    private boolean teleportTo(double x, double y, double z) {
        BlockPos.Mutable mutable = new BlockPos.Mutable(x, y, z);

        while (mutable.getY() > 0 && !this.world.getBlockState(mutable).getMaterial().blocksMovement()) {
            mutable.move(Direction.DOWN);
        }

        BlockState blockState = this.world.getBlockState(mutable);
        boolean bl = blockState.getMaterial().blocksMovement();
        boolean bl2 = blockState.getFluidState().isIn(FluidTags.WATER);
        if (bl && !bl2) {
            boolean bl3 = this.teleport(x, y, z, true);
            if (bl3 && !this.isSilent()) {
                this.world.playSound((PlayerEntity) null, this.prevX, this.prevY, this.prevZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
                this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return bl3;
        } else {
            return false;
        }
    }

    public boolean teleport(double x, double y, double z, boolean particleEffects) {
        LivingEntity instance = ((LivingEntity) (Object) this);

        double d = this.getX();
        double e = this.getY();
        double f = this.getZ();
        double g = y;
        boolean bl = false;
        BlockPos blockPos = new BlockPos(x, y, z);
        World world = this.world;
        if (world.isChunkLoaded(blockPos)) {
            boolean bl2 = false;

            while (!bl2 && blockPos.getY() > 0) {
                BlockPos blockPos2 = blockPos.down();
                BlockState blockState = world.getBlockState(blockPos2);
                if (blockState.getMaterial().blocksMovement()) {
                    bl2 = true;
                } else {
                    --g;
                    blockPos = blockPos2;
                }
            }

            if (bl2) {
                this.requestTeleport(x, g, z);
                if (world.isSpaceEmpty(this) && !world.containsFluid(this.getBoundingBox())) {
                    bl = true;
                }
            }
        }

        if (!bl) {
            this.requestTeleport(d, e, f);
            return false;
        } else {
            if (particleEffects) {
                world.sendEntityStatus(this, (byte) 46);
            }

            if (instance instanceof PathAwareEntity) {
                ((PathAwareEntity) instance).getNavigation().stop();
            }

            return true;
        }
    }
}
