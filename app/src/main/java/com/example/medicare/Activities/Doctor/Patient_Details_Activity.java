package com.example.medicare.Activities.Doctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Patient_Details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });
        findViewById(R.id.book_appointment_btn).setOnClickListener(v -> {
            startActivity(new Intent(Patient_Details_Activity.this, Schedule_Activity.class));
        });
    }
}