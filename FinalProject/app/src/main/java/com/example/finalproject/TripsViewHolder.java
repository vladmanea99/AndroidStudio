package com.example.finalproject;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class TripsViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageViewPicture;
    private TextView textViewTripName;
    private TextView textViewDestination;
    private TextView textViewPrice;
    private TextView textViewRating;
    private CheckBox checkBoxBookmarked;

    public ImageView getImageViewPicture() {
        return imageViewPicture;
    }

    public TextView getTextViewTripName() {
        return textViewTripName;
    }

    public TextView getTextViewDestination() {
        return textViewDestination;
    }

    public TextView getTextViewPrice() {
        return textViewPrice;
    }

    public TextView getTextViewRating() {
        return textViewRating;
    }

    public CheckBox getCheckBoxBookmarked() {
        return checkBoxBookmarked;
    }

    public TripsViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewPicture = itemView.findViewById(R.id.imageViewTrip);
        textViewTripName = itemView.findViewById(R.id.textViewTripName);
        textViewDestination = itemView.findViewById(R.id.textViewDestination);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        textViewRating = itemView.findViewById(R.id.textViewRating);
        checkBoxBookmarked = itemView.findViewById(R.id.checkBoxBookmark);
    }
}
