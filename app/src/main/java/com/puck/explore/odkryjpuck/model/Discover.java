package com.puck.explore.odkryjpuck.model;

/**
 * Created by Mela on 2017-12-30.
 */

public class Discover {

    public String name;
    public String desc;
    public String imageSrc;

    public Discover(String name, String desc, String imageSrc) {
        this.name = name;
        this.desc = desc;
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }


}
