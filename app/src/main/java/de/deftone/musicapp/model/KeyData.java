package de.deftone.musicapp.model;

public class KeyData {
    private String keyName;
    private int scaleImgResId;
    private int pentaImgResId;


    public KeyData(String keyName, int scaleImgResId, int pentaImgResId) {
        this.keyName = keyName;
        this.scaleImgResId = scaleImgResId;
        this.pentaImgResId = pentaImgResId;
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
