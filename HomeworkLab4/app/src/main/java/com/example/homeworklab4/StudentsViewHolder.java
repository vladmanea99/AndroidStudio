package com.example.homeworklab4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewFirstName;
    private TextView textViewSecondName;
    private View viewBar;

    public TextView getTextViewFirstName() {
        return textViewFirstName;
    }

    public TextView getTextViewSecondName() {
        return textViewSecondName;
    }

    @Override
    public String toString() {
        return "StudentsViewHolder{" +
                "textViewFirstName=" + textViewFirstName +
                ", textViewSecondName=" + textViewSecondName +
                '}';
    }

    public View getViewBar() {
        return viewBar;
    }

    public StudentsViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
        textViewSecondName = itemView.findViewById(R.id.textViewSecondName);
        viewBar = itemView.findViewById(R.id.viewBar);
    }
}
