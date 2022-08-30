package com.example.melhamconstructionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.melhamconstructionapp.databinding.ActivityAboutBinding;

public class AboutActivity extends DrawerBaseActivity {
    
    ActivityAboutBinding activityAboutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAboutBinding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(activityAboutBinding.getRoot());
        allocateActivityTitle("About");

        //Hide navigation bar
        //getSupportActionBar().hide();
    }

    private void allocateActivityTitle(String about) {
    }
}