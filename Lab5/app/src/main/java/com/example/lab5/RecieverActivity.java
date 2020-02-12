package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecieverActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciever);

        initView();

        //String receivedData = savedInstanceState.getString(LifecycleAcitivity.MESSAGE);

        Bundle savedInstance = getIntent().getExtras();

        String receivedMessage;

        if (savedInstance .containsKey(LifecycleAcitivity.MESSAGE)){
            receivedMessage = savedInstance.getString(LifecycleAcitivity.MESSAGE);
            textView.setText(receivedMessage);

            Intent intent = new Intent();
            intent.putExtra(LifecycleAcitivity.MESSAGE, receivedMessage + " (am primit)");
            setResult(RESULT_OK, intent);
            finish();
        }


    }

    void initView(){
        textView = findViewById(R.id.textView);
    }
}
