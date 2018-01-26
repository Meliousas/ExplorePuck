package com.puck.explore.odkryjpuck.model;

/**
 * Created by Mela on 2018-01-25.
 */

public class Eat extends CategoryItem {

    public String openHours;

    public Eat(int id, String category, String name, String address, String desc, String imageSrc, String openHours) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.imageSrc = imageSrc;
        this.openHours = openHours;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

}
