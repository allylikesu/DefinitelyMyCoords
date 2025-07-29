package de.luludodo.definitelymycoords.mixins.old_xaerominimap;

import de.luludodo.definitelymycoords.api.DMCApi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import xaero.common.minimap.info.BuiltInInfoDisplays;
import xaero.common.minimap.info.InfoDisplay;
import xaero.common.minimap.info.render.compile.InfoDisplayOnCompile;

import java.util.Objects;

@Deprecated
@Mixin(value = InfoDisplay.class, remap = false)
public class InfoDisplayMixin {
    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            index = 6,
            argsOnly = true,
            remap = true
    )
    @Deprecated
    private static <T> InfoDisplayOnCompile<T> definitelymycoords$init(final InfoDisplayOnCompile<T> value) {
        return (
                displayInfo,
                compiler,
                session,
                processor,
                x,
                y,
                w,
                h,
                scale,
                size,
                playerBlockX,
                playerBlockY,
                playerBlockZ,
                playerPos
        ) -> {
            boolean shouldOffset =
                    Objects.equals(displayInfo.getId(), BuiltInInfoDisplays.COORDINATES.getId()) ||
                    Objects.equals(displayInfo.getId(), BuiltInInfoDisplays.OVERWORLD_COORDINATES.getId()) ||
                    Objects.equals(displayInfo.getId(), BuiltInInfoDisplays.CHUNK_COORDINATES.getId());
            value.onCompile(
                    displayInfo,
                    compiler,
                    session,
                    processor,
                    x,
                    y,
                    w,
                    h,
                    scale,
                    size,
                    shouldOffset ? (int) DMCApi.getOffsetBlockX(playerBlockX) : playerBlockX,
                    shouldOffset ? (int) DMCApi.getOffsetBlockY(playerBlockY) : playerBlockY,
                    shouldOffset ? (int) DMCApi.getOffsetBlockZ(playerBlockZ) : playerBlockZ,
                    shouldOffset ? DMCApi.getOffsetBlock(playerPos) : playerPos
            );
        };
    }
}
