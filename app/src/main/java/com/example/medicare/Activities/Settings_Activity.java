package com.example.medicare.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Settings_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.change_password).setOnClickListener(v -> {
            startActivity(new Intent(Settings_Activity.this, Change_Password_Activity.class));
        });
    }
}