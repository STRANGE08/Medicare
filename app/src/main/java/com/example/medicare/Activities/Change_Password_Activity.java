package com.example.medicare.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Change_Password_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        findViewById(R.id.save_btn).setOnClickListener(v -> {
            finish();
        });
        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

    }
}