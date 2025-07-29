package de.luludodo.definitelymycoords.config;

import de.luludodo.definitelymycoords.api.config.JsonMapConfig;
import de.luludodo.definitelymycoords.config.serializer.ConfigSerializer;
import de.luludodo.definitelymycoords.modes.Mode;
import net.minecraft.util.Identifier;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

public class Config extends JsonMapConfig<String, Object> {
    public Config() {
        super("definitelymycoords/config", new ConfigSerializer(), "dmc/config");
    }

    @Override
    protected Map<String, Object> getDefaults() {
        Map.Entry<String, Object> e1 = new AbstractMap.SimpleEntry<String, Object>("mode", Mode.VANILLA);
        Map.Entry<String, Object> e2 = new AbstractMap.SimpleEntry<String, Object>("offset-x", 0L);
        Map.Entry<String, Object> e3 = new AbstractMap.SimpleEntry<String, Object>("offset-y", 0L);
        Map.Entry<String, Object> e4 = new AbstractMap.SimpleEntry<String, Object>("offset-z", 0L);
        Map.Entry<String, Object> e5 = new AbstractMap.SimpleEntry<String, Object>("obscure-rotations", true);
        Map.Entry<String, Object> e6 = new AbstractMap.SimpleEntry<String, Object>("spoof-biome", false);
        Map.Entry<String, Object> e7 = new AbstractMap.SimpleEntry<String, Object>("biome", Objects.requireNonNull(Identifier.of("minecraft", "plains")));
        Map.Entry<String, Object> e8 = new AbstractMap.SimpleEntry<String, Object>("offset-boundary-x1", 0L);
        Map.Entry<String, Object> e9 = new AbstractMap.SimpleEntry<String, Object>("offset-boundary-x2", 0L);
        Map.Entry<String, Object> e10 = new AbstractMap.SimpleEntry<String, Object>("offset-boundary-z1", 0L);
        Map.Entry<String, Object> e11 = new AbstractMap.SimpleEntry<String, Object>("offset-boundary-z2", 0L);
        Map.Entry<String, Object> e12 = new AbstractMap.SimpleEntry<String, Object>("dimension", "minecraft:overworld");

        return Map.ofEntries(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
    }
}
