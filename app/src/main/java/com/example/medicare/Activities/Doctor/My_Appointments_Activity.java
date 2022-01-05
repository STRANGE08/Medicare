package com.example.medicare.Activities.Doctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.MainActivity;
import com.example.medicare.R;

public class My_Appointments_Activity extends AppCompatActivity {
    String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments);

        from = getIntent().getStringExtra("from");
        findViewById(R.id.back).setOnClickListener(v -> {
            if (from.equalsIgnoreCase("dr_payment")) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("fragment_name", "home");
                startActivity(intent);
            } else if (from.equalsIgnoreCase("profile")) {
                finish();
            }
        });
    }

    public void onBackPressed() {
        if (from.equalsIgnoreCase("dr_payment")) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("fragment_name", "home");
            startActivity(intent);
        } else {
            finish();
        }
    }
}