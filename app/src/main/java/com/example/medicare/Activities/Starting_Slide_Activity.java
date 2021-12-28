package com.example.medicare.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.medicare.R;

public class Starting_Slide_Activity extends AppCompatActivity {
    ImageView move_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_slide);

        move_to_login = findViewById(R.id.move_to_login);
        move_to_login.setOnClickListener(v -> {
            startActivity(new Intent(Starting_Slide_Activity.this, Go_to_Login_Signup_Activity.class));
            finish();
        });
    }
}