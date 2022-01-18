package com.example.medicare.Activities.Doctor.Dr_Actvities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.Activities.Appointment_summery_Activity;
import com.example.medicare.R;

public class Patient_Details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);


        String from = getIntent().getStringExtra("from");


        findViewById(R.id.back).setOnClickListener(v -> finish());

        findViewById(R.id.book_appointment_btn).setOnClickListener(v -> {
            if (from.equalsIgnoreCase("Dr_Details")) {
                startActivity(
                        new Intent(
                                Patient_Details_Activity.this,  Dr_Schedule_Activity.class)
                                .putExtra("from", "patient_details"));
            } else {
                startActivity(
                        new Intent(
                                Patient_Details_Activity.this, Appointment_summery_Activity.class)
                                .putExtra("status", "pending"));
            }

        });
    }
}