package com.example.medicare.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Go_to_Login_Signup_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_login_signup);

        findViewById(R.id.go_to_signup).setOnClickListener(v -> {
            startActivity(new Intent(Go_to_Login_Signup_Activity.this, Register_Activity.class));
        });
        findViewById(R.id.go_to_signin).setOnClickListener(v -> {
            startActivity(new Intent(Go_to_Login_Signup_Activity.this, Login_Activity.class));
        });
    }
}