package com.jamalam360.mixin;

import com.jamalam360.util.CustomEnchantmentHelper;
import com.jamalam360.util.registry.EnchantmentRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Inject(at = @At("HEAD"), method = "afterBreak(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/item/ItemStack;)V")
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack, CallbackInfo ci){
        if(CustomEnchantmentHelper.hasBulldozer(stack) && player.isSneaking() && stack.isEffectiveOn(state)){
            int i = CustomEnchantmentHelper.getLevel(EnchantmentRegistry.BULLDOZER, stack);
            ArrayList<BlockPos> posArrayList = new ArrayList<>();
            Direction dir;

            switch (i){ //Yes officer this code right here is the bit I want you to arrest and lock away forever. Yes i could have used math.box or something but the past is in the past and the code is finished and works
                case 1:
                    dir = Direction.getEntityFacingOrder(player)[0];
                    switch (dir){
                        case SOUTH: case NORTH:
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY() + 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY() + 1,  pos.getZ())));
                            break;
                        case EAST: case WEST:
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ()  + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ() - 1)));
                            break;
                        case UP: case DOWN:
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ()  + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ() - 1)));
                            break;
                    }
                    break;
                case 2:
                    dir = Direction.getEntityFacingOrder(player)[0];
                    switch (dir){
                        case SOUTH: case NORTH:
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY() + 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY() + 1,  pos.getZ())));

                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY() + 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY() + 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY() + 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY() + 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY() + 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY() - 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY() - 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY() - 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY() - 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY() + 1,  pos.getZ())));

                            break;
                        case EAST: case WEST:
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ()  + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ() - 1)));

                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 2,  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 2,  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 2,  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 2,  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 2,  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 2,  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 2,  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 2,  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 2,  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() - 1,  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY() + 1,  pos.getZ() - 2)));

                            break;
                        case UP: case DOWN:
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ()  + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ() - 1)));

                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY(),  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 2,  pos.getY(),  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY(),  pos.getZ() + 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY(),  pos.getZ() + 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY(),  pos.getZ())));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY(),  pos.getZ() - 1)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 2,  pos.getY(),  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() - 1,  pos.getY(),  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX(),  pos.getY(),  pos.getZ() - 2)));
                            posArrayList.add(new BlockPos(new Vec3d(pos.getX() + 1,  pos.getY(),  pos.getZ() - 2)));

                            break;
                    }
                    break;
            }

            stack.damage(posArrayList.size(), world.random, (ServerPlayerEntity)player);

            for(BlockPos blockPos : posArrayList){
                if(stack.isEffectiveOn(world.getBlockState(blockPos))) {
                    world.breakBlock(blockPos, true, player);
                }
            }
        }
    }
}
