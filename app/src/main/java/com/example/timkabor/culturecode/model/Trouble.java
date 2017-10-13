package com.example.timkabor.culturecode.model;

import java.util.UUID;

/**
 * Created by Timur on 13.10.2017.
 */

public class Trouble {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    UUID id;
    String text;
    boolean isChecked;

    public Trouble(String text) {
        id = UUID.randomUUID();
        this.text = text;
        isChecked = false;
    }
}
