package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.finalproject.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

public class AddTripActivity extends AppCompatActivity {

    private EditText editTextTripName;
    private EditText editTextDestination;
    private EditText editTextPrice;
    private RatingBar ratingBarTrip;

    public static final String TRIP_NAME = "trip_name";
    public static final String DESTINATION = "destination";
    public static final String PRICE = "price";
    public static final String RATING = "rating";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        initViews();
    }

    void initViews(){
        editTextTripName = findViewById(R.id.editTextTripName);
        editTextDestination = findViewById(R.id.editTextDestination);
        editTextPrice = findViewById(R.id.editTextPrice);
        ratingBarTrip = findViewById(R.id.ratingBarTrip);
    }

    public void addTripToTripsOnClick(View view) {

        //TODO save trip and add it to the other activity list
        //TODO add picture

        if (editTextTripName.getText().toString().equals("") || editTextTripName.getText().toString() == null){
            Snackbar.make(view, "Missing trip name, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else if (editTextDestination.getText().toString().equals("") || editTextDestination.getText().toString() == null){
            Snackbar.make(view, "Missing destination, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else if (editTextPrice.getText().toString().equals("") || editTextPrice.getText() == null){
            Snackbar.make(view, "Missing price, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else if (ratingBarTrip.getRating() == 0){
            Snackbar.make(view, "Missing rating, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else {
            Snackbar.make(view, "It saved", Snackbar.LENGTH_SHORT).show();

            Intent mainIntent = new Intent(AddTripActivity.this, MainActivity.class);
            mainIntent.putExtra(TRIP_NAME, editTextTripName.getText().toString());
            mainIntent.putExtra(DESTINATION, editTextDestination.getText().toString());
            mainIntent.putExtra(PRICE, editTextPrice.getText().toString());
            mainIntent.putExtra(RATING, String.valueOf(ratingBarTrip.getRating()));
           // mainIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(mainIntent);
            finish();
        }
    }

}
