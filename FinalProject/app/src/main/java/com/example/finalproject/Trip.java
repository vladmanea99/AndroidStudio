package com.example.finalproject;

public class Trip {

    private String urlPicture;
    private String tripName;
    private String destination;
    private String price;
    private String rating;
    private boolean bookmarked;

    public Trip(String urlPicture, String tripName, String destination, String price, String rating, boolean bookmarked) {
        this.urlPicture = urlPicture;
        this.tripName = tripName;
        this.destination = destination;
        this.price = price;
        this.rating = rating;
        this.bookmarked = bookmarked;
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
