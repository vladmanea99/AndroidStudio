package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LifecycleAcitivity extends AppCompatActivity {

    private EditText editText;
    private EditText editTextFirstNumber;
    private EditText editTextSecondNumber;
    private TextView textViewResult;
        public static final String MESSAGE = "message";
    private static final int REQUEST_CODE_RECEIVED = 10;

    private static final String EDIT_TEXT_VALUE = "edittext";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_acitivity);
        initView();
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EDIT_TEXT_VALUE, editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString(EDIT_TEXT_VALUE));
    }



    void initView(){
        editText = findViewById(R.id.editTextMessage);
        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);
        textViewResult = findViewById(R.id.textViewResult);
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



    public void openReceiverActivityOnClick(View view) {
        Intent openActivity = new Intent(LifecycleAcitivity.this, RecieverActivity.class);
        startActivity(openActivity);
    }

    public void callPhonrNumberOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0777777777"));
        startActivity(intent);
    }

    public void sendMessageOnClick(View view) {
        Intent intent = new Intent(LifecycleAcitivity.this, RecieverActivity.class);
        intent.putExtra(MESSAGE, editText.getText().toString());
        startActivity(intent);
    }

    public void sendMessageForResultOnClick(View view) {

        String message = editText.getText().toString();
        Intent intent = new Intent(LifecycleAcitivity.this, RecieverActivity.class);
        intent.putExtra(MESSAGE, message);
        startActivityForResult(intent, REQUEST_CODE_RECEIVED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_RECEIVED && resultCode == RESULT_OK){
            String messageFromResult = data.getStringExtra(MESSAGE);
            Toast.makeText(LifecycleAcitivity.this, messageFromResult, Toast.LENGTH_LONG).show();
        }
    }

    public void getSumOnClick(View view) {
        String first = editTextFirstNumber.getText().toString();
        String second = editTextSecondNumber.getText().toString();
        textViewResult.setText(first + " " + second);
    }
}
