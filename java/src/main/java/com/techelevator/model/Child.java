package com.techelevator.model;

import java.util.Map;

public class Child {

    private int childId;
    private String name;
    private int minutes;
    private Map<String, Integer> bookMinutes;


    public int getChildId() { return childId; }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Map<String, Integer> getBookMinutes() {
        return bookMinutes;
    }

    public void setBookMinutes(Map<String, Integer> bookMinutes) {
        this.bookMinutes = bookMinutes;
    }
}
