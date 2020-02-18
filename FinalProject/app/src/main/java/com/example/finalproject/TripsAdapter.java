package com.example.finalproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

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
    public void onBindViewHolder(@NonNull final TripsViewHolder holder, int position) {

        //TODO Add picture and render it
        final Trip currentTrip = trips.get(position);
        holder.getTextViewId().setText("Id : " + Integer.toString(currentTrip.getId()));
        holder.getTextViewTripName().setText("Trip name : " + currentTrip.getTripName());
        holder.getTextViewDestination().setText("Destination : " + currentTrip.getDestination());
        holder.getTextViewPrice().setText("Price : " + currentTrip.getPrice());
        holder.getTextViewRating().setText("Rating : " + currentTrip.getRating());
        holder.getCheckBoxBookmarked().setChecked(currentTrip.isBookmarked());

        holder.getCheckBoxBookmarked().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.getCheckBoxBookmarked().isChecked()){
                    currentTrip.setBookmarked(true);
                    MainActivity.tripDataBase.tripDao().updateTrip(currentTrip);
                   // MainActivity.favouriteTripsDataBase.tripDao().addTrip(currentTrip);
                }
                else{
                    currentTrip.setBookmarked(false);
                    MainActivity.tripDataBase.tripDao().updateTrip(currentTrip);
                    //MainActivity.favouriteTripsDataBase.tripDao().deleteTrip(currentTrip);
                }
            }
        });

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){
                    Intent editTripIntent = new Intent(view.getContext(), EditTripActivity.class);
                    Snackbar.make(view, Integer.toString(currentTrip.getId()), Snackbar.LENGTH_SHORT).show();
                    editTripIntent.putExtra(EditTripActivity.ID, Integer.toString(currentTrip.getId()));
                    editTripIntent.putExtra(EditTripActivity.TRIP_NAME, currentTrip.getTripName());
                    editTripIntent.putExtra(EditTripActivity.DESTINATION, currentTrip.getDestination());
                    editTripIntent.putExtra(EditTripActivity.TRIP_TYPE, currentTrip.getTripType());
                    editTripIntent.putExtra(EditTripActivity.PRICE, currentTrip.getPrice());
                    editTripIntent.putExtra(EditTripActivity.START_DATE, currentTrip.getStartDate());
                    editTripIntent.putExtra(EditTripActivity.END_DATE, currentTrip.getEndDate());
                    editTripIntent.putExtra(EditTripActivity.RATING, currentTrip.getRating());
                    view.getContext().startActivity(editTripIntent);
                }
                //TODO READ ONLY MODE
                else{
                    Intent readTripIntent = new Intent(view.getContext(), ReadOnlyActivity.class);
                    Snackbar.make(view, Integer.toString(currentTrip.getId()), Snackbar.LENGTH_SHORT).show();
                    readTripIntent.putExtra(EditTripActivity.ID, Integer.toString(currentTrip.getId()));
                    readTripIntent.putExtra(EditTripActivity.TRIP_NAME, currentTrip.getTripName());
                    readTripIntent.putExtra(EditTripActivity.DESTINATION, currentTrip.getDestination());
                    readTripIntent.putExtra(EditTripActivity.TRIP_TYPE, currentTrip.getTripType());
                    readTripIntent.putExtra(EditTripActivity.PRICE, currentTrip.getPrice());
                    readTripIntent.putExtra(EditTripActivity.START_DATE, currentTrip.getStartDate());
                    readTripIntent.putExtra(EditTripActivity.END_DATE, currentTrip.getEndDate());
                    readTripIntent.putExtra(EditTripActivity.RATING, currentTrip.getRating());
                    view.getContext().startActivity(readTripIntent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return trips.size();
    }


}
