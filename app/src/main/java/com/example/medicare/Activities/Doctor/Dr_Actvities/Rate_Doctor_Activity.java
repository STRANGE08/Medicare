package com.example.medicare.Activities.Doctor.Dr_Actvities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Rate_Doctor_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_doctor);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

    }
}