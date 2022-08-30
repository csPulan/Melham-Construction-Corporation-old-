package com.example.melhamconstructionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.melhamconstructionapp.databinding.ActivitySignInBinding;

public class SignInActivity extends DrawerBaseActivity {
    
    ActivitySignInBinding activitySignInBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignInBinding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(activitySignInBinding.getRoot());
        allocateActivityTitle("SignIn");

        //Hide navigation bar
        //getSupportActionBar().hide();
    }

    private void allocateActivityTitle(String signIn) {
    }
}