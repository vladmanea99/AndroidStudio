package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;

import com.example.finalproject.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {


    private String tripName;
    private String destination;
    private String price;
    private String rating;

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            Bundle bundle = new Bundle();
            bundle.putString(AddTripActivity.TRIP_NAME, intent.getExtras().getString(AddTripActivity.TRIP_NAME));
            String m = intent.getExtras().getString(AddTripActivity.TRIP_NAME);
            bundle.putString(AddTripActivity.DESTINATION, intent.getExtras().getString(AddTripActivity.DESTINATION));
            bundle.putString(AddTripActivity.PRICE, getIntent().getExtras().getString(AddTripActivity.PRICE));
            bundle.putString(AddTripActivity.RATING, getIntent().getExtras().getString(AddTripActivity.RATING));

            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(bundle);

        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addTripIntent = new Intent(MainActivity.this, AddTripActivity.class);
                MainActivity.this.startActivity(addTripIntent);

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_about_us, R.id.nav_slideshow,
                R.id.nav_contact, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            Bundle bundle = new Bundle();
            bundle.putString(AddTripActivity.TRIP_NAME, intent.getExtras().getString(AddTripActivity.TRIP_NAME));
            String m = intent.getExtras().getString(AddTripActivity.TRIP_NAME);
            bundle.putString(AddTripActivity.DESTINATION, intent.getExtras().getString(AddTripActivity.DESTINATION));
            bundle.putString(AddTripActivity.PRICE, getIntent().getExtras().getString(AddTripActivity.PRICE));
            bundle.putString(AddTripActivity.RATING, getIntent().getExtras().getString(AddTripActivity.RATING));

            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(bundle);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
