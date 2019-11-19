package com.example.lab4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FruitsViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewName;
    private TextView textViewColor;

    @Override
    public String toString() {
        return "FruitsViewHolder{" +
                "name=" + textViewName +
                ", color=" + textViewColor +
                ", imageViewFruit=" + imageViewFruit +
                '}';
    }

    public TextView getName() {
        return textViewName;
    }

    public TextView getColor() {
        return textViewColor;
    }

    public ImageView getImageViewFruit() {
        return imageViewFruit;
    }

    private ImageView imageViewFruit;

    public FruitsViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.textViewName);
        textViewColor = itemView.findViewById(R.id.textViewColor);
        imageViewFruit = itemView.findViewById(R.id.imageViewFruit);
    }
}
