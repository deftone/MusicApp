package de.deftone.musicapp.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scales {

    private static List<KeyData> SCALE = Arrays.asList(
            KeyData.C,
            KeyData.DB, KeyData.D,
            KeyData.EB, KeyData.E,
            KeyData.F, KeyData.FIS,
            KeyData.G,
            KeyData.AB, KeyData.A,
            KeyData.BB, KeyData.B);
//todo: Bb hinzufuegen
    private static Map<KeyData, KeyData> EB_NOTIERT = new HashMap<>();
    private static Map<KeyData, KeyData> EB_KLINGEND = new HashMap<>();

    static {
        //key is klingender Ton, value is notierter Ton
        EB_NOTIERT.put(KeyData.C, KeyData.A);
        EB_NOTIERT.put(KeyData.DB, KeyData.BB);
        EB_NOTIERT.put(KeyData.D, KeyData.B);
        EB_NOTIERT.put(KeyData.EB, KeyData.C);
        EB_NOTIERT.put(KeyData.E, KeyData.DB);
        EB_NOTIERT.put(KeyData.F, KeyData.D);
        EB_NOTIERT.put(KeyData.FIS, KeyData.EB);
        EB_NOTIERT.put(KeyData.G, KeyData.E);
        EB_NOTIERT.put(KeyData.AB, KeyData.F);
        EB_NOTIERT.put(KeyData.A, KeyData.FIS);
        EB_NOTIERT.put(KeyData.BB, KeyData.G);
        EB_NOTIERT.put(KeyData.B, KeyData.AB);

        //key is notierter Ton, value is klingender Ton
        EB_KLINGEND.put(KeyData.A, KeyData.C);
        EB_KLINGEND.put(KeyData.BB, KeyData.DB);
        EB_KLINGEND.put(KeyData.B, KeyData.D);
        EB_KLINGEND.put(KeyData.C, KeyData.EB);
        EB_KLINGEND.put(KeyData.DB, KeyData.E);
        EB_KLINGEND.put(KeyData.D, KeyData.F);
        EB_KLINGEND.put(KeyData.EB, KeyData.FIS);
        EB_KLINGEND.put(KeyData.E, KeyData.G);
        EB_KLINGEND.put(KeyData.F, KeyData.AB);
        EB_KLINGEND.put(KeyData.FIS, KeyData.A);
        EB_KLINGEND.put(KeyData.G, KeyData.BB);
        EB_KLINGEND.put(KeyData.AB, KeyData.B);
    }

    public static KeyData getNotierterToneForEb(KeyData key) {
        return EB_NOTIERT.get(key);
    }

    public static KeyData getKlingenderToneForEb(KeyData key) {
        return EB_KLINGEND.get(key);
    }

    public static List<KeyData> getScale() {
        return SCALE;
    }
}
