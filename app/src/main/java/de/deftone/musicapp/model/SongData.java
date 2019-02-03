package de.deftone.musicapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongData {

    private static List<Song> ALL_SONGS;

    public static List<Song> getAllSongs() {
        return ALL_SONGS;
    }

    //todo: hier irgendwie noch einen transformator einbauen, fuer Eb und Bb instrumente
    public static List<Song> getSongsInKey(final KeyData key) {
        return getAllSongs().stream().filter(s -> s.getKeyData() == key).collect(Collectors.toList());
    }

    static {
        ALL_SONGS = new ArrayList<>();

        ALL_SONGS.add(new Song(0, KeyData.C, "c_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.D, "d_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.E, "e_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.F, "f_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.G, "g_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.A, "a_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.B, "b_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.BB, "bb_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.EB, "eb_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.DB, "db_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.AB, "ab_major_aebersold", "simple jazz song", "Aebersold"));
        ALL_SONGS.add(new Song(0, KeyData.FIS, "gb_major_aebersold", "simple jazz song", "Aebersold"));
        //todo: hier alle songs hinzufuegen
    }
}
