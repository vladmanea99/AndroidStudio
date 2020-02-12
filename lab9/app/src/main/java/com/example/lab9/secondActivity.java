package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    EditText editTextMessage;
    TextView textViewMessage;
    String message;
    private static final String MESSAGE_KEY = "message_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        getSharedPreference();

    }

    void getSharedPreference(){
        if (ApplicationData.getStringValueFromSharedPreferences(this, MESSAGE_KEY) == null){
            return;
        }

        message = ApplicationData.getStringValueFromSharedPreferences(this, MESSAGE_KEY);
        textViewMessage.setText(message);
    }

    void initViews(){
        editTextMessage = findViewById(R.id.editTextMessage);
        textViewMessage = findViewById(R.id.textViewMessage);
    }

    public void getTextOnClick(View view) {

    if (editTextMessage.getText() == null || editTextMessage.getText().toString().equals("")){
        return;
    }

    message = editTextMessage.getText().toString();
    ApplicationData.setStringValueInSharedPreferences(this, MESSAGE_KEY, message);

    finish();

    }
}
