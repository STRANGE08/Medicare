package com.example.medicare.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.go_to_otp).setOnClickListener(v -> {
            startActivity(new Intent(Register_Activity.this, Otp_Verify_Activity.class));
        });
        findViewById(R.id.login_go).setOnClickListener(v -> {
            startActivity(new Intent(Register_Activity.this, Login_Activity.class));
            finish();
        });
    }


}