package de.deftone.musicapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongData {

    private static List<Song> ALL_SONGS;

    public static List<Song> getAllSongs() {
        return ALL_SONGS;
    }

    public static List<Song> getSongsInKey(final KeyData key) {
        return getAllSongs().stream().filter(s -> s.getKeyData() == key).collect(Collectors.toList());
    }

    static {
        ALL_SONGS = new ArrayList<>();
//achtung: auch die minor (moll) songs sind noch in major (dur)
        ALL_SONGS.add(new Song(KeyData.C, "c_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.D, "d_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.E, "e_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.F, "f_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.G, "g_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.A, "a_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.B, "b_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.BB, "bb_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.EB, "eb_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.DB, "db_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.AB, "ab_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(KeyData.FIS, "gb_major_aebersold", "simple jazz song", "Aebersold"));

        ALL_SONGS.add(new Song(KeyData.C, "c_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.D, "d_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.E, "e_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.F, "f_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.G, "g_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.A, "a_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.B, "b_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.BB, "bb_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.EB, "eb_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.DB, "db_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.AB, "ab_dirko", "sax sound song", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.FIS, "gb_dirko", "sax sound song", "Dirko"));

        ALL_SONGS.add(new Song(KeyData.C, "c_moon_river", "moon river", "Dirko"));

        // d moll = f dur vorzeichen
        ALL_SONGS.add(new Song(KeyData.F, "d_min_summertime", "summertime (moll)", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.F, "f_sentimental", "sentimental jorney", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.F, "f_tequila", "tequila", "Dirko"));

        // c moll = Eb dur vorzeichen
        ALL_SONGS.add(new Song(KeyData.EB, "c_min_wade_wader", "wade in the water (moll)", "Dirko"));
        // g moll = Bb dur vorzeichen
        ALL_SONGS.add(new Song(KeyData.BB, "g_min_wayfaring_stranger", "wayfaring stranger (moll)", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.BB, "g_min_autumn_leaves", "autumn leaves (moll)", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.BB, "g_min_petite_fleur", "petite fleur (moll)", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.BB, "bb_perdigo", "perdigo", "Dirko"));

        ALL_SONGS.add(new Song(KeyData.G, "g_how_high_moon", "how high the moon", "Dirko"));

        // f moll == Ab dur vorzeichen
        ALL_SONGS.add(new Song(KeyData.AB, "f_min_caravan", "caravan (moll)", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.AB, "ab_mood_indigo", "mood indigo", "Dirko"));
        ALL_SONGS.add(new Song(KeyData.AB, "ab_in_the_mood", "in the mood", "Dirko"));

    }
}
