package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textViewDate;
    TextView textViewDateTime;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setAnimation();
    }

    void initView(){
        textViewDate = findViewById(R.id.textViewDate);
        textViewDateTime = findViewById(R.id.textViewDateTime);
        linearLayout = findViewById(R.id.layoutMain);
    }

    public void datePickerOnClick(View view) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textViewDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void timePickerOnClick(View view) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        textViewDateTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    public void openDialogOnClick(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.notice));
        builder.setMessage(getString(R.string.alert_title));

// add the buttons
        builder.setPositiveButton(getString(R.string.launch_app), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, getString(R.string.launch_app) + " " + getString(R.string.click), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(getString(R.string.reminde_me), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, getString(R.string.reminde_me) + " " + getString(R.string.click), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, getString(R.string.cancel) + " " + getString(R.string.click), Toast.LENGTH_SHORT).show();
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setAnimation() {
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
    }


    public void pressMeOnClick(View view) {
        Snackbar snackbar = Snackbar
                .make(view, R.string.error_occured, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, getString(R.string.retry_message), Toast.LENGTH_LONG).show();
                    }
                });
        snackbar.setActionTextColor(Color.RED);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.GREEN);
        snackbar.show();
    }
}
