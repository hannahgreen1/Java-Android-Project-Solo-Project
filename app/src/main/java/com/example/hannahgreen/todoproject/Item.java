package com.example.hannahgreen.todoproject;

public class Item {

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
