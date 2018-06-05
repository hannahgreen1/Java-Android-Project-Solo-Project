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

    public Item(int id, String title, String notes, Boolean completed){
        this.id = id;
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

    public Boolean isCompleted() {
      return this.completed = true;
    }

    public void setCompleted(){
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
