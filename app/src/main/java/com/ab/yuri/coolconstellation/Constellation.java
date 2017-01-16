package com.ab.yuri.coolconstellation;

/**
 * Created by Yuri on 2017/1/16.
 */

public class Constellation {
    private String constellationName;
    private int constellationImg;
    private int constellationImgView;

    public Constellation(String constellationName, int constellationImg, int constellationImgView) {
        this.constellationName = constellationName;
        this.constellationImg = constellationImg;
        this.constellationImgView = constellationImgView;
    }



    public String getConstellationName() {
        return constellationName;
    }

    public int getConstellationImg() {
        return constellationImg;
    }

    public int getConstellationImgView() {
        return constellationImgView;
    }
}

