package com.ab.yuri.coolconstellation;

/**
 * Created by Yuri on 2017/1/16.
 */

public class Constellation {
    private String constellationName;
    private int constellationImg;

    public Constellation(String constellationName, int constellationImg) {
        this.constellationName = constellationName;
        this.constellationImg = constellationImg;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public int getConstellationImg() {
        return constellationImg;
    }

}
