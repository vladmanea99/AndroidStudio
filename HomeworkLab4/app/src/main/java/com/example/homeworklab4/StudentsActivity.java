package com.example.homeworklab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {

    List<Student> students;
    RecyclerView recyclerViewStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        initViews();
        getStudents(20);
        setLayoutManager();
        setAdapter();
    }

    void getStudents(int n){
        students  = new ArrayList<>();
        int counter = 1;
        while (counter  <= n) {
            students.add(new Student(String.valueOf(counter), String.valueOf(counter)));
            counter ++;
        }
    }

    void setLayoutManager(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewStudents.setLayoutManager(layoutManager);
    }

    void setAdapter(){
        StudentsAdapter studentsAdapter = new StudentsAdapter(students);
        recyclerViewStudents.setAdapter(studentsAdapter);
    }

    void initViews(){
        recyclerViewStudents = findViewById(R.id.recyclerViewStudents);
    }
}
