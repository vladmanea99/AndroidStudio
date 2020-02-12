package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<TripsViewHolder> {

    private List<Trip> trips;

    public TripsAdapter(List<Trip> trips) {
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item, parent, false);
        return new TripsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripsViewHolder holder, int position) {

        //TODO Add picture and render it
        Trip currentTrip = trips.get(position);
        holder.getTextViewTripName().setText(currentTrip.getTripName());
        holder.getTextViewDestination().setText(currentTrip.getDestination());
        holder.getTextViewPrice().setText(currentTrip.getPrice());
        holder.getTextViewRating().setText(currentTrip.getRating());
        holder.getCheckBoxBookmarked().setChecked(currentTrip.isBookmarked());

    }

    @Override
    public int getItemCount() {
        return trips.size();
    }
}
