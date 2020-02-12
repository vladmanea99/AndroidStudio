package com.example.homeworklab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreeButtons extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;

    public static final String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_buttons);

        initView();
    }

    void initView(){
        buttonOne = findViewById(R.id.button1);
        buttonTwo = findViewById(R.id.button2);
        buttonThree = findViewById(R.id.button3);
    }

    public void buttonOneOpenActivityOnClick(View view) {
        Intent intent = new Intent(ThreeButtons.this, ThreeButtonsSecond.class);
        intent.putExtra(MESSAGE, "button1");
        startActivity(intent);
    }

    public void buttonTwoOpenActivityOnClick(View view) {
        Intent intent = new Intent(ThreeButtons.this, ThreeButtonsSecond.class);
        intent.putExtra(MESSAGE, "button2");
        startActivity(intent);
    }

    public void buttonThreeOpenActivityOnClick(View view) {
        Intent intent = new Intent(ThreeButtons.this, ThreeButtonsSecond.class);
        intent.putExtra(MESSAGE, "button3");
        startActivity(intent);
    }
}
