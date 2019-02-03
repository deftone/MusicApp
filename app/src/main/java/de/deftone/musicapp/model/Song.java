package de.deftone.musicapp.model;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String artist;
    private String fileName;  //ohne .mp3!!
    private KeyData keyData;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public KeyData getKeyData() {
        return keyData;
    }

    public String getFileName() {
        return fileName;
    }

    public Song(int id, KeyData keyData, String fileName, String title, String artist) {
        this.id = id;
        this.keyData = keyData;
        this.fileName = fileName;
        this.title = title;
        this.artist = artist;
    }
}
