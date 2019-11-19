package com.example.newhomeworklab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    View firstView;
    View secondView;
    View thirdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_game);

        initViews();

        firstView.setX(750);
        firstView.setY(-560);

        secondView.setX(325);
        secondView.setY(-335);

        thirdView.setX(secondView.getX() + 80);
        thirdView.setY(secondView.getY() - 150);

    }


    void initViews(){
        firstView = findViewById(R.id.firstView);
        secondView = findViewById(R.id.secondView);
        thirdView = findViewById(R.id.thirdView);
    }
}
