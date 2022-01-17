package com.example.medicare.Activities.Lab_Test.Lt_Activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Lt_Patient_Details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lt_patient_details);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });
        findViewById(R.id.cnf_appointment_btn).setOnClickListener(v -> {
            startActivity(
                    new Intent(
                            Lt_Patient_Details_Activity.this, Lt_Schedule_Activity.class));
        });

    }
}