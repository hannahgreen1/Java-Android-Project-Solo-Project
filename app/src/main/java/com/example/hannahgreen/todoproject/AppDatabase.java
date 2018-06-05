package com.example.hannahgreen.todoproject;

class AppDatabase {

    @Database(entities = {Item.class}, version = 3)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract ArtistDao artistDao();
        public abstract AlbumDao albumDao();
    }
}
