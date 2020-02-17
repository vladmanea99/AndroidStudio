package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class ReadOnlyActivity extends AppCompatActivity {

    private TextView textViewTripName;
    private TextView textViewDestination;
    private TextView textViewPrice;
    private TextView textViewRating;
    private TextView textViewStartDate;
    private TextView textViewEndDate;
    private TextView textViewWeather;

    private String startDate;
    private String endDate;
    private String tripType;
    private String destination;

    private String idTrip;

    private String API = "8e2da1a253fafc939590f02b06e5dd0b";

    public static final String ID = "id";
    public static final String TRIP_NAME = "trip_name";
    public static final String DESTINATION = "destination";
    public static final String PRICE = "price";
    public static final String RATING = "rating";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String TRIP_TYPE = "trip_type";

    void getExtra(){
        Bundle bundleData = getIntent().getExtras();
        idTrip = bundleData.getString(ID);
        textViewTripName.setText("Trip Name : " + bundleData.getString(TRIP_NAME));
        textViewDestination.setText("Destination : " + bundleData.getString(DESTINATION));
        String price = bundleData.getString(PRICE);
        textViewPrice.setText("Price : " + price);
        textViewStartDate.setText("Start Date : " + bundleData.getString(START_DATE));
        textViewEndDate.setText("End Date : " +bundleData.getString(END_DATE));
        textViewRating.setText("Rating : " +bundleData.getString(RATING));
        tripType = bundleData.getString(TRIP_TYPE);
        startDate = bundleData.getString(START_DATE);
        endDate = bundleData.getString(END_DATE);
        destination = bundleData.getString(DESTINATION);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_only);
        initViews();
        getExtra();

        new weatherTask().execute();
    }

    void initViews(){
        textViewTripName = findViewById(R.id.textViewTripName);
        textViewDestination = findViewById(R.id.textViewDestination);
        textViewPrice = findViewById(R.id.textViewPriceRead);
        textViewRating = findViewById(R.id.textViewRating);
        textViewStartDate = findViewById(R.id.textViewStartDate);
        textViewEndDate = findViewById(R.id.textViewEndDate);
        textViewWeather = findViewById(R.id.textViewWeather);
    }

    class weatherTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + destination + "&units=metric&appid=" + API);
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONObject jsonObj = new JSONObject(s);
                JSONObject jsonWeather = jsonObj.getJSONArray("weather").getJSONObject(0);
                String weather = jsonWeather.getString("main");
                textViewWeather.setText("Weather right now : " + weather);
            } catch (JSONException e) {
                textViewWeather.setText("Weather unavailable");
            }
        }
    }

}
