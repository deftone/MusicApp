package de.deftone.musicapp.model;

public class Key {
    private String key;
    private String keyName;
    private int scaleImgResId;
    private int pentaImgResId;


    public Key(String key, String keyName, int scaleImgResId, int pentaImgResId) {
        this.key = key;
        this.keyName = keyName;
        this.scaleImgResId = scaleImgResId;
        this.pentaImgResId = pentaImgResId;
    }

    public String getKey() {
        return key;
    }

    public String getKeyName() {
        return keyName;
    }

    public int getScaleImgResId() {
        return scaleImgResId;
    }

    public int getPentaImgResId() {
        return pentaImgResId;
    }
}
