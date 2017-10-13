package com.example.timkabor.culturecode.model;

import java.text.SimpleDateFormat;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class Feature {
    private int id;
    private String name;
    private String cover;
    public Feature(int id, String name, String cover) {
        this.id = id;
        this.name = name;
        this.cover = cover;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
