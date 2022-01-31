/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.lambdynlights.mixin;

import me.jellysquid.mods.sodium.client.model.light.EntityLighter;
import me.lambdaurora.lambdynlights.LambDynLights;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = EntityLighter.class)
public class EntityLighterMixin
{
    @Redirect(
            method = "getBlendedLight",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;getLightLevel(Lnet/minecraft/world/LightType;Lnet/minecraft/util/math/BlockPos;)I",
                    ordinal = 1
            )
    )
    private static int onGetWorldLight(World world, LightType type, BlockPos pos)
    {
        /*
            TO BE REMOVED IN FUTURE VERSIONS

            This is only here to keep compatibility with Sodium 0.1.0.
            In newer versions this is broken and use EntityRendererMixin instead (which is much simpler)
         */
        int vanilla = world.getLightLevel(type, pos);
        double luminance = LambDynLights.get().getDynamicLightLevel(pos);
        return (int) Math.max(vanilla, Math.round(luminance));
    }
}
