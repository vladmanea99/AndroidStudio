package com.example.finalproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.finalproject.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class AddTripActivity extends AppCompatActivity {

    private EditText editTextTripName;
    private EditText editTextDestination;
    private SeekBar seekBarPrice;
    private RatingBar ratingBarTrip;
    private TextView textViewStartDate;
    private TextView textViewEndDate;
    private TextView textViewPrice;

    private String startDate;
    private String endDate;
    private String tripType;

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
        seekBarPrice = findViewById(R.id.seekBarPrice);
        ratingBarTrip = findViewById(R.id.ratingBarTrip);
        textViewStartDate = findViewById(R.id.textViewStartDate);
        textViewEndDate = findViewById(R.id.textViewEndDate);
        textViewPrice = findViewById(R.id.textViewPriceSeekBar);

        seekBarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewPrice.setText(Integer.toString(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
        else if (seekBarPrice.getProgress() == 0){
            Snackbar.make(view, "Missing price, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else if (ratingBarTrip.getRating() == 0){
            Snackbar.make(view, "Missing rating, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else if(startDate == null){
            Snackbar.make(view, "Missing start date, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else if(endDate == null){
            Snackbar.make(view, "Missing end date, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else if(tripType == null){
            Snackbar.make(view, "Missing trip type, please add one", Snackbar.LENGTH_SHORT).show();
        }
        else {
            Snackbar.make(view, "It saved", Snackbar.LENGTH_SHORT).show();

            Intent mainIntent = new Intent(AddTripActivity.this, MainActivity.class);
            Trip trip = new Trip("poza", editTextTripName.getText().toString(), editTextDestination.getText().toString(), Integer.toString(seekBarPrice.getProgress()), String.valueOf(ratingBarTrip.getRating()), false, startDate, endDate, tripType);
            MainActivity.tripDataBase.tripDao().addTrip(trip);

            startActivity(mainIntent);
            finish();
        }
    }

    public void startDatePickerOnClick(View view) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        startDate = (dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        textViewStartDate.setText(startDate);

                    }
                }, year, month, day);
        datePickerDialog.show();

    }

    public void endDatePickerOnClick(View view) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        endDate = (dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        textViewEndDate.setText(endDate);

                    }
                }, year, month, day);
        datePickerDialog.show();

    }

    public void radioButtonOnClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButtonCityBreak:
                if (checked) {
                    tripType = "City Break";
                }
                    break;
            case R.id.radioButtonSeaSide:
                if (checked){
                    tripType = "Sea Side";
                }
                    break;
            case R.id.radioButtonMountains:
                if (checked) {
                    tripType = "Mountains";
                }
                    break;
        }

    }
}
