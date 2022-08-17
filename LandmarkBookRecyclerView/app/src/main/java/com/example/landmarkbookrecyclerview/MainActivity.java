package com.example.landmarkbookrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.landmarkbookrecyclerview.databinding.ActivityDetailsBinding;
import com.example.landmarkbookrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        Landmark belle = new Landmark("Belle", "Beauty and the Beast",R.drawable.belle);
        Landmark aurora = new Landmark("Aurora", "Sleeping beauty",R.drawable.aurora);
        Landmark jasmine = new Landmark("Jasmine", "Aladdin",R.drawable.jasmine);
        Landmark fiona = new Landmark("Fiona", "Shrek",R.drawable.fiona);

        landmarkArrayList.add(belle);
        landmarkArrayList.add(aurora);
        landmarkArrayList.add(jasmine);
        landmarkArrayList.add(fiona);

        //RecyclerView un grid mi yoxsa linear layout mu olacagini secirik
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //THE SEVENTH!!!- MainActivitye gelib LandmarkAdapter sinifinden bir adapter objesi olusturdum
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);


    }
}