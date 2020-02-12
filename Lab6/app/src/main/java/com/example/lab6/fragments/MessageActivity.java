package com.example.lab6.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lab6.R;

public class MessageActivity extends AppCompatActivity {

    private EditText editTextMessage;
    public static final String MESS = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initView();
    }

    void initView(){
        editTextMessage = findViewById(R.id.editText);
    }

    public void sendMessageToFragmentOnClick(View view) {
       // communicateWithBundle();
        communicateWithMethod();    
    }

    public void communicateWithMethod(){
        String message = editTextMessage.getText().toString();
        DisplayFragment displayFragment = new DisplayFragment();
        displayFragment.setMessage(message);
        replaceFragment(displayFragment);
    }

    private void communicateWithBundle() {
        Bundle bundle = new Bundle();
        String message = editTextMessage.getText().toString();
        bundle.putString(MESS, message);
        DisplayFragment displayFragment = new DisplayFragment();
        displayFragment.setArguments(bundle);
        replaceFragment(displayFragment);
    }

    private void replaceFragment(Fragment displayFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, displayFragment);
        fragmentTransaction.commit();
    }
}
