package de.luludodo.definitelymycoords.config;

import de.luludodo.definitelymycoords.DefinitelyMyCoords;
import de.luludodo.definitelymycoords.modes.Mode;
import net.minecraft.util.Identifier;

public class ConfigAPI {

    public static Mode getMode() {
        return (Mode) DefinitelyMyCoords.CONFIG.get("mode");
    }

    public static long getOffsetX() {
        return (long) DefinitelyMyCoords.CONFIG.get("offset-x");
    }

    public static long getOffsetY() {
        return (long) DefinitelyMyCoords.CONFIG.get("offset-y");
    }

    public static long getOffsetZ() {
        return (long) DefinitelyMyCoords.CONFIG.get("offset-z");
    }

    public static long[] getOffsetBoundaryX() {
        long x1 = (long) DefinitelyMyCoords.CONFIG.get("offset-boundary-x1");
        long x2 = (long) DefinitelyMyCoords.CONFIG.get("offset-boundary-x2");
        return new long[]{x1, x2};
    }
    public static long[] getOffsetBoundaryZ() {
        long z1 = (long) DefinitelyMyCoords.CONFIG.get("offset-boundary-z1");
        long z2 = (long) DefinitelyMyCoords.CONFIG.get("offset-boundary-z2");
        return new long[]{z1, z2};
    }
    public static String getDimension() {
        return (String) DefinitelyMyCoords.CONFIG.get("dimension");
    }

    public static long getOffsetBoundaryX2() { return (long) DefinitelyMyCoords.CONFIG.get("offset-boundary-x1"); }

    public static long getOffsetBoundaryZ1() { return (long) DefinitelyMyCoords.CONFIG.get("offset-boundary-x1"); }

    public static long getOffsetBoundaryZ2() { return (long) DefinitelyMyCoords.CONFIG.get("offset-boundary-x1"); }

    public static boolean getObscureRotations() {
        return (boolean) DefinitelyMyCoords.CONFIG.get("obscure-rotations");
    }

    public static boolean getSpoofBiome() {
        return (boolean) DefinitelyMyCoords.CONFIG.get("spoof-biome");
    }

    public static Identifier getBiome() {
        return (Identifier) DefinitelyMyCoords.CONFIG.get("biome");
    }

    public static void setMode(Mode mode) {
        DefinitelyMyCoords.CONFIG.set("mode", mode);
    }

    public static void setOffsetX(long offsetX) {
        DefinitelyMyCoords.CONFIG.set("offset-x", offsetX);
    }

    public static void setOffsetY(long offsetY) {
        DefinitelyMyCoords.CONFIG.set("offset-y", offsetY);
    }

    public static void setOffsetZ(long offsetZ) {
        DefinitelyMyCoords.CONFIG.set("offset-z", offsetZ);
    }

    public static void setObscureRotations(boolean obscureRotations) {
        DefinitelyMyCoords.CONFIG.set("obscure-rotations", obscureRotations);
    }

    public static void setSpoofBiome(boolean spoofBiome) {
        DefinitelyMyCoords.CONFIG.set("spoof-biome", spoofBiome);
    }

    public static void setBiome(Identifier biome) {
        DefinitelyMyCoords.CONFIG.set("biome", biome);
    }
}
