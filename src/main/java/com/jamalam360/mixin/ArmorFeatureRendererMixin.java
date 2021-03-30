package com.jamalam360.mixin;

import com.jamalam360.util.IArmorInvisible;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("unused")
@Mixin(ArmorFeatureRenderer.class)
public class ArmorFeatureRendererMixin <T extends LivingEntity, M extends BipedEntityModel<T>, A extends BipedEntityModel<T>> implements IArmorInvisible {
    private boolean isVisible = true;

    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V", cancellable = true)
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci){
        if(!this.isVisible){
            ci.cancel();
        }
    }

    @Override
    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }
}
