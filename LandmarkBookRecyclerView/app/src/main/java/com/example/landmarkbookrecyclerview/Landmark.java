package com.example.landmarkbookrecyclerview;

import java.io.Serializable;

public class Landmark implements Serializable {
    String name;
    String filmName;
    int image;

    public Landmark(String name,String filmName, int image) {
        this.name = name;
        this.filmName = filmName;
        this.image = image;
    }
}
