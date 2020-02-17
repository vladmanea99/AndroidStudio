package com.example.finalproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "trips")
public class Trip {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "photo")
    private String urlPicture;

    @ColumnInfo(name = "name_of_trip")
    private String tripName;

    @ColumnInfo(name = "destination")
    private String destination;

    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "rating")
    private String rating;

    @ColumnInfo(name = "bookmarked")
    private boolean bookmarked;

    @ColumnInfo(name = "start_date")
    private String startDate;

    @ColumnInfo(name = "end_date")
    private String endDate;

    @ColumnInfo(name = "trip_type")
    private String tripType;


    public Trip(String urlPicture, String tripName, String destination, String price, String rating, boolean bookmarked, String startDate, String endDate, String tripType) {

        this.urlPicture = urlPicture;
        this.tripName = tripName;
        this.destination = destination;
        this.price = price;
        this.rating = rating;
        this.bookmarked = bookmarked;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tripType = tripType;
    }

    @Ignore
    public Trip(int id, String urlPicture, String tripName, String destination, String price, String rating, boolean bookmarked, String startDate, String endDate, String tripType) {

        this.id = id;
        this.urlPicture = urlPicture;
        this.tripName = tripName;
        this.destination = destination;
        this.price = price;
        this.rating = rating;
        this.bookmarked = bookmarked;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tripType = tripType;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public String getTripName() {
        return tripName;
    }

    public String getDestination() {
        return destination;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "urlPicture='" + urlPicture + '\'' +
                ", tripName='" + tripName + '\'' +
                ", destination='" + destination + '\'' +
                ", price='" + price + '\'' +
                ", rating='" + rating + '\'' +
                ", bookmarked=" + bookmarked +
                '}';
    }
}
