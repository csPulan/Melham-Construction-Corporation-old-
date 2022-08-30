package com.example.melhamconstructionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.melhamconstructionapp.databinding.ActivityProjectsBinding;

public class ProjectsActivity extends DrawerBaseActivity {
    
    ActivityProjectsBinding activityProjectsBinding;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProjectsBinding = ActivityProjectsBinding.inflate(getLayoutInflater());
        setContentView(activityProjectsBinding.getRoot());
        allocateActivityTitle("Projects");


        button = findViewById(R.id.btnProjectsBotolanViewProject);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectsActivity.this, ProjectBotolanActivity.class);
                startActivity(intent);
            }
        });
        //Hide navigation bar
        //getSupportActionBar().hide();
    }

    private void allocateActivityTitle(String projects) {
    }
}