package com.example.finalproject;

import android.content.ClipData;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class TripsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    private ImageView imageViewPicture;
    private TextView textViewId;
    private TextView textViewTripName;
    private TextView textViewDestination;
    private TextView textViewPrice;
    private TextView textViewRating;
    private CheckBox checkBoxBookmarked;

    private ItemClickListener itemClickListener;

    public ImageView getImageViewPicture() {
        return imageViewPicture;
    }

    public TextView getTextViewId() {
        return textViewId;
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
        textViewId = itemView.findViewById(R.id.textViewId);
        textViewTripName = itemView.findViewById(R.id.textViewTripName);
        textViewDestination = itemView.findViewById(R.id.textViewDestination);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        textViewRating = itemView.findViewById(R.id.textViewRating);
        checkBoxBookmarked = itemView.findViewById(R.id.checkBoxBookmark);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }
}
