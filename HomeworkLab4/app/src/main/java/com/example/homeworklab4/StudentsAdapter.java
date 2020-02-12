package com.example.homeworklab4;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsViewHolder> {

    List<Student> students;
    private int count = 0;

    public StudentsAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);

        return new StudentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        count ++;
        Student currentStudent = students.get(position);
        holder.getTextViewFirstName().setText("First Name "+ currentStudent.getFirstName());
        holder.getTextViewSecondName().setText("Second Name " + currentStudent.getSecondName());
        if (count%2 == 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#EEEEEE"));
        }
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
