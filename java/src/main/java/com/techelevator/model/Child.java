package com.techelevator.model;

import java.util.Map;

public class Child {

    private int childId;
    private String name;
    private int minutes;
    private Map<String, Integer> bookMinutes;
    private String icon;
    private int familyId;


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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
}
