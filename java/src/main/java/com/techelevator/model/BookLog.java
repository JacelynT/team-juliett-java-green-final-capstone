package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BookLog {

    private String isbn;
    private String title;
    private int childId;
    private String icon;
    private int minutes;
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChildId() {
        return childId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
