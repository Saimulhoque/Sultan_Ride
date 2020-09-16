package com.example.sultanride;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private Adapter recyclerviewadapter;
    ArrayList<RecyclerViewModel> recyclerViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerviewid);
        recyclerViewModel = new ArrayList<>();

        recyclerViewModel.add(new RecyclerViewModel(R.drawable.bike, "Bike"));
        recyclerViewModel.add(new RecyclerViewModel(R.drawable.car, "Car"));
        recyclerViewModel.add(new RecyclerViewModel(R.drawable.cng, "Cng"));
        recyclerViewModel.add(new RecyclerViewModel(R.drawable.truck, "Truck"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(this,recyclerViewModel);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);
        }
    }
