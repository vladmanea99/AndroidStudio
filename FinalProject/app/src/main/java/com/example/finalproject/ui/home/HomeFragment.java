package com.example.finalproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.finalproject.AddTripActivity;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.Trip;
import com.example.finalproject.TripDataBase;
import com.example.finalproject.TripsAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;

    private String tripName;
    private String destination;
    private String price;
    private String rating;

    static int nOfTrips;

    List<Trip> trips;
    RecyclerView recyclerViewTrips;

    Button logoutButton;




    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(root);
        getTrips();
        //deleteTrips();
        setLayoutManager();
        setAdapter();

        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        trips = MainActivity.tripDataBase.tripDao().getTrips();
        setLayoutManager();
        setAdapter();
    }

    public static int getnOfTrips(){
        return nOfTrips;
    }

    void deleteTrips(){
        for (Trip trip:trips){
            MainActivity.tripDataBase.tripDao().deleteTrip(trip);
        }
    }



    void initViews(View view){
        recyclerViewTrips = view.findViewById(R.id.recycleViewTrip);
    }

    void getTrips(){
        trips = MainActivity.tripDataBase.tripDao().getTrips();
        nOfTrips = trips.size();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        logoutButton = view.findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                getActivity().finish();
            }
        });

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