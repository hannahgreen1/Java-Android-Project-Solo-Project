package com.example.hannahgreen.todoproject;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Item implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String notes;
    private Boolean completed;

    public Item(String title, String notes){
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

    public void setCompleted(Boolean value) {
      this.completed = value;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
