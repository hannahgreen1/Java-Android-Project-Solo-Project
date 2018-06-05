package com.example.hannahgreen.todoproject;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    public static App INSTANCE;
    private static final String DATABASE_NAME = "ToDoList";

    private AppDatabase database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();

        INSTANCE = this;
    }

    public AppDatabase getDB() {
        return this.database;
    }

}

