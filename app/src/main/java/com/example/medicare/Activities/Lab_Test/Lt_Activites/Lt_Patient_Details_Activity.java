package com.example.medicare.Activities.Lab_Test.Lt_Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.medicare.Activities.Doctor.Dr_Actvities.Dr_Schedule_Activity;
import com.example.medicare.Activities.Doctor.Dr_Actvities.Patient_Details_Activity;
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