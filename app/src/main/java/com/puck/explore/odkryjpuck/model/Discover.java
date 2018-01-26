package com.puck.explore.odkryjpuck.model;

/**
 * Created by Mela on 2017-12-30.
 */

public class Discover extends CategoryItem {

    public Discover(int id, String category, String name, String address, String desc, String imageSrc) {
        this.id = id;
        this.category =category;
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.imageSrc = imageSrc;
    }

}
