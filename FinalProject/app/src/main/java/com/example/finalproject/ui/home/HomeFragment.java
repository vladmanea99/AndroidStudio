package com.example.finalproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.AddTripActivity;
import com.example.finalproject.R;
import com.example.finalproject.Trip;
import com.example.finalproject.TripsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private String tripName;
    private String destination;
    private String price;
    private String rating;

    List<Trip> trips;
    RecyclerView recyclerViewTrips;

    //TODO GET DATA FROM DATA BASE
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        initViews(root);
        getTrips();
        if (getExtra()){
            trips.add(new Trip("poza", tripName, destination, price, rating, false));
        }
        setLayoutManager();
        setAdapter();
        return root;
    }

    //TODO GET DATA FROM DATA BASE
    @Override
    public void onResume() {
        super.onResume();
        if (getExtra()){
            trips.add(new Trip("poza", tripName, destination, price, rating, false));
        }
        setLayoutManager();
        setAdapter();
    }

    boolean getExtra(){
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();;
        if (bundle == null) {
            return false;
        }

        if (bundle.getString(AddTripActivity.TRIP_NAME) == null || bundle.getString(AddTripActivity.TRIP_NAME).equals("")){
            return false;
        }
        if (bundle.getString(AddTripActivity.DESTINATION) == null || bundle.getString(AddTripActivity.DESTINATION).equals("")){
            return false;
        }
        if (bundle.getString(AddTripActivity.PRICE) == null || bundle.getString(AddTripActivity.PRICE).equals("")){
            return false;
        }
        if (bundle.getString(AddTripActivity.RATING) == null || bundle.getString(AddTripActivity.RATING).equals("")) {
            return false;
        }

        tripName = bundle.getString(AddTripActivity.TRIP_NAME);
        destination = bundle.getString(AddTripActivity.DESTINATION);
        price = bundle.getString(AddTripActivity.PRICE);
        rating = bundle.getString(AddTripActivity.RATING);

        return true;
    }

    void initViews(View view){
        recyclerViewTrips = view.findViewById(R.id.recycleViewTrip);
    }

    void getTrips(){
        trips = new ArrayList<>();
        trips.add(new Trip("poza", "M-am dus", "La destinatie", "200", "3.6", true));
        trips.add(new Trip("poza2", "M-am dus2", "La destinatie2", "200", "3.6", true));
        trips.add(new Trip("poza3", "M-am dus3", "La destinatie3", "200", "3.6", true));
        trips.add(new Trip("poza4", "M-am dus4", "La destinatie4", "200", "3.6", true));
        trips.add(new Trip("poza5", "M-am dus5", "La destinatie5", "200", "3.6", true));
        trips.add(new Trip("poza6", "M-am dus6", "La destinatie6", "200", "3.6", true));
        trips.add(new Trip("poza7", "M-am dus7", "La destinatie7", "200", "3.6", true));
        trips.add(new Trip("poza8", "M-am dus8", "La destinatie8", "200", "3.6", true));
        trips.add(new Trip("poza9", "M-am dus9", "La destinatie9", "200", "3.6", true));
        trips.add(new Trip("poza10", "M-am dus10", "La destinatie10", "200", "3.6", true));
        trips.add(new Trip("poza11", "M-am dus11", "La destinatie11", "200", "3.6", true));
    }

    void setLayoutManager(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewTrips.setLayoutManager(layoutManager);
    }

    void setAdapter(){
        TripsAdapter tripsAdapter = new TripsAdapter(trips);
        recyclerViewTrips.setAdapter(tripsAdapter);
    }

}