package com.example.homeworklab4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<String> spinnerList;
    Spinner spinner;
    ArrayAdapter<String> adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);

        initViews();

        adapterSpinner = getAdapter();
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = spinner.getSelectedItemPosition();
                String string = spinnerList.get(item);
                Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    void initViews(){
        spinner = findViewById(R.id.spinner);

        spinnerList = new ArrayList<>();
        spinnerList.add("Ecler");
        spinnerList.add("Pizza");
        spinnerList.add("Hamburger");
        spinnerList.add("Tzatziki");
        spinnerList.add("Donut");
        spinnerList.add("Coke");
        spinnerList.add("Gyros");
        spinnerList.add("Pancakes");
    }

    ArrayAdapter<String> getAdapter(){
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerList);
    }
}
