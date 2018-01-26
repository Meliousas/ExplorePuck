package com.puck.explore.odkryjpuck.model;

/**
 * Created by Mela on 2018-01-25.
 */

public class Party extends CategoryItem {

    public String date;

    public Party (int id, String category, String name, String address, String desc, String imageSrc, String date) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.imageSrc = imageSrc;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
