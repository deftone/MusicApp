package de.deftone.musicapp.model;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String artist;
//    private File file;
    private String fileName;
//    private int songLength;

//    public long getId() {
//        return id;
//    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

//    public File getFile() {
//        return file;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public int getSongLength() {
//        return songLength;
//    }

    public Song(int id, String fileName, String title, String artist) {
        this.id = id;
        this.fileName = fileName;
        this.title = title;
        this.artist = artist;
    }
}
