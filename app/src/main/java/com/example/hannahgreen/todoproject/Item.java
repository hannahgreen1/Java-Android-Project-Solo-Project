package com.example.hannahgreen.todoproject;

import java.io.Serializable;

public class Item implements Serializable {

    private String title;
    private String notes;

    public Item(String title, String notes){
        this.title = title;
        this.notes = notes;

    }

    public String getNotes() {
        return notes;
    }

    public String getTitle() {
        return title;
    }

    public String setNotes(String notes) {
       return this.notes = notes;
    }

    public String setTitle(String title) {
        return this.title = title;
    }
}
