package com.example.finalproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TripDao {

    @Insert
    public void addTrip(Trip trip);

    @Query("select * from trips")
    public List<Trip> getTrips();

    @Delete
    public void deleteTrip(Trip trip);

    @Update
    public void updateTrip(Trip trip);

}
