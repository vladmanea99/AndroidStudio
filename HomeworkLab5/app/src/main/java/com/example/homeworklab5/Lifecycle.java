package com.example.homeworklab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Lifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "was called");
    }


}
