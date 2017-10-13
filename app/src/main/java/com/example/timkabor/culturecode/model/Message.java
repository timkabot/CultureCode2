package com.example.timkabor.culturecode.model;

/**
 * Created by Timkabor on 10/14/2017.
 */

public class Message {
    private String user;
    private String message;

    public Message(String name, String message) {
        this.user = name;
        this.message = message;
    }

    public String getName() {
        return user;
    }

    public void setName(String name) {
        this.user = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
