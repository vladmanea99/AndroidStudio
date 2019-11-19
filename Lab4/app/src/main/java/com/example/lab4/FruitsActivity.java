package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FruitsActivity extends AppCompatActivity {

    List<Fruit> fruits;
    RecyclerView recyclerViewFruits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        initViews();
        getFruits();
        setLayoutManager();
        setAdapter();
    }

    void getFruits(){
        fruits = new ArrayList<>();
        fruits.add(new Fruit("banana", "galben"));
        fruits.add(new Fruit("caspuni", "rosu", "https://cdn1.iconfinder.com/data/icons/food-111/512/strawberry-512.png"));
        fruits.add(new Fruit("mere", "verzi"));
        fruits.add(new Fruit("fructul pasiunii", "portocaliu"));
        fruits.add(new Fruit("mure", "albastru"));
        fruits.add(new Fruit("afine", "albastru"));
        fruits.add(new Fruit("mango", "galben"));
        fruits.add(new Fruit("pepene", "rosu"));
        fruits.add(new Fruit("pomelo", "galben"));
        fruits.add(new Fruit("kiwi", "verde"));
        fruits.add(new Fruit("pere", "galben"));

    }

    void setLayoutManager(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewFruits.setLayoutManager(layoutManager);
    }

    void setAdapter(){
        FruitsAdapter fruitsAdapter = new FruitsAdapter(fruits);
        recyclerViewFruits.setAdapter(fruitsAdapter);
    }

    void initViews(){
        recyclerViewFruits = findViewById(R.id.recycleViewFruits);
    }
}
