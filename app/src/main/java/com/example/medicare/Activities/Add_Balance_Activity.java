package com.example.medicare.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicare.R;

public class Add_Balance_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

    }
}