package com.example.newhomeworklab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview_activity);
       /*initViews();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmailCorrect(editTextEmail.getText().toString())){
                    editTextEmail.setError("Wrong email");
                }

            }
        });
*/
    }
    boolean isEmailCorrect(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    void initViews(){
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);
    }
}
