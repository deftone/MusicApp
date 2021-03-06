package de.deftone.musicapp.model;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

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

    private static BiMap<KeyData, KeyData> EB_NOTIERT = HashBiMap.create();
    private static BiMap<KeyData, KeyData> BB_NOTIERT = HashBiMap.create();

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

        //key is klingender Ton, value is notierter Ton
        BB_NOTIERT.put(KeyData.C, KeyData.D);
        BB_NOTIERT.put(KeyData.DB, KeyData.EB);
        BB_NOTIERT.put(KeyData.D, KeyData.E);
        BB_NOTIERT.put(KeyData.EB, KeyData.F);
        BB_NOTIERT.put(KeyData.E, KeyData.FIS);
        BB_NOTIERT.put(KeyData.F, KeyData.G);
        BB_NOTIERT.put(KeyData.FIS, KeyData.AB);
        BB_NOTIERT.put(KeyData.G, KeyData.A);
        BB_NOTIERT.put(KeyData.AB, KeyData.BB);
        BB_NOTIERT.put(KeyData.A, KeyData.B);
        BB_NOTIERT.put(KeyData.BB, KeyData.C);
        BB_NOTIERT.put(KeyData.B, KeyData.DB);

    }

    public static KeyData getNotierterToneForEb(KeyData key) {
        return EB_NOTIERT.get(key);
    }

    public static KeyData getKlingenderToneForEb(KeyData key) {
        return EB_NOTIERT.inverse().get(key);
    }

    public static KeyData getNotierterToneForBb(KeyData key) {
        return BB_NOTIERT.get(key);
    }

    public static KeyData getKlingenderToneForBb(KeyData key) {
        return BB_NOTIERT.inverse().get(key);
    }

    public static KeyData getSameToneForBb(KeyData key) {
        //Eb greift C -> Eb erklingt
//        KeyData klingenderEbTone = EB_KLINGEND.get(key);
        KeyData klingenderEbTone = EB_NOTIERT.inverse().get(key);
        // was ist Eb klingend als notierter Ton fuer Bb?
        return BB_NOTIERT.get(klingenderEbTone);
    }

    public static KeyData getSameToneForEb(KeyData key) {
//        KeyData klingenderBbTone = BB_KLINGEND.get(key);
        KeyData klingenderBbTone = BB_NOTIERT.inverse().get(key);
        return EB_NOTIERT.get(klingenderBbTone);
    }

    public static List<KeyData> getScale() {
        return SCALE;
    }
}
