package com.example.finalproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Trip.class}, version = 1)
public abstract class TripDataBase extends RoomDatabase {

    public abstract TripDao tripDao();

}
