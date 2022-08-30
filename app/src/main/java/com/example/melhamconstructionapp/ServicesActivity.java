package com.example.melhamconstructionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.melhamconstructionapp.databinding.ActivityServicesBinding;

public class ServicesActivity extends DrawerBaseActivity {

    ActivityServicesBinding activityServicesBinding;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityServicesBinding = ActivityServicesBinding.inflate(getLayoutInflater());
        setContentView(activityServicesBinding.getRoot());
        setTitle("Services");


        button = findViewById(R.id.btnServicesContactUsToday);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServicesActivity.this, ContactUsActivity.class);
                startActivity(intent);
            }
        });
        //Hide navigation bar
        //getSupportActionBar().hide();
    }

}