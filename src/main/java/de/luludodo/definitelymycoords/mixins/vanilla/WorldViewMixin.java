package de.luludodo.definitelymycoords.mixins.vanilla;

import de.luludodo.definitelymycoords.api.DMCApi;
import de.luludodo.definitelymycoords.config.ConfigAPI;
import de.luludodo.definitelymycoords.reflection.ReflectionHelper;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldView.class)
public interface WorldViewMixin {
    @Shadow DynamicRegistryManager getRegistryManager();
    @Shadow BiomeAccess getBiomeAccess();

    @Redirect(
            method = "getBiome",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/source/BiomeAccess;getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/registry/entry/RegistryEntry;",
                    ordinal = 0
            )
    )
    default RegistryEntry<Biome> definitelymycoords$getBiome(BiomeAccess instance, BlockPos pos) {
        if (ConfigAPI.getSpoofBiome()) {
            if (DMCApi.isValidBiome((WorldView) this, ConfigAPI.getBiome())) {
                return definitelymycoords$toEntry(ConfigAPI.getBiome());
            } else {
                return definitelymycoords$toEntry(BiomeKeys.THE_VOID);
            }
        } else {
            return getBiomeAccess().getBiome(pos);
        }
    }

    @Unique
    private RegistryEntry<Biome> definitelymycoords$toEntry(RegistryKey<Biome> biome) {
        return definitelymycoords$toEntry(biome.getValue());
    }

    // Sorry for the scuffed code, but minecraft changed how Registries worked and only some methods work in both versions
    @Unique
    private RegistryEntry<Biome> definitelymycoords$toEntry(Identifier biome) {
        Registry<Biome> registry = getRegistryManager().get(RegistryKeys.BIOME);
        return registry.getEntry(registry.getOrEmpty(biome).orElseThrow());
    }
}
