package com.example.homeworklab5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ThreeButtonsSecond extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;

    List<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_buttons_second);

        initView();

        Bundle savedInstance =getIntent().getExtras();

        String message;

        if (savedInstance.containsKey(ThreeButtons.MESSAGE)){
            message = savedInstance.getString(ThreeButtons.MESSAGE);
           for (TextView textView: textViews){
               if(message.equals("button1")){
                   textView.setText(R.string.button1);
               }
               else  if(message.equals("button2")){
                   textView.setText(R.string.button2);
               }
               else  if(message.equals("button3")){
                   textView.setText(R.string.button3);
               }
           }
        }
    }

    void initView(){
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        textViews = new ArrayList<>();
        textViews.add(textView1);
        textViews.add(textView2);
        textViews.add(textView3);
    }
}
