package com.example.hannahgreen.todoproject;

import java.io.Serializable;

public class Item implements Serializable {

    private String title;
    private String notes;
    private Boolean completed;

    public Item(String title, String notes, Boolean completed){
        this.title = title;
        this.notes = notes;
        this.completed = false;

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

    public Boolean itemCompleted() {
      return this.completed = true;
    }
}
