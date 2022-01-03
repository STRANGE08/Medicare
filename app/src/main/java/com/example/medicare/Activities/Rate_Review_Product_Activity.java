package com.example.medicare.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Rate_Review_Product_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_review_product);
        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.submit_review).setOnClickListener(v -> {
            finish();
        });
    }
}