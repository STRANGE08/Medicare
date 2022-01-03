package com.example.medicare.Activities.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Dr_Details_Activity extends AppCompatActivity {
    LinearLayout more_info_layout;
    ImageView more_info_view, less_info_view;
    Button online_cons_btn, book_appointment_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_details);

        more_info_layout = findViewById(R.id.more_info_layout);
        more_info_view = findViewById(R.id.more_info_view);
        less_info_view = findViewById(R.id.less_info_view);
        online_cons_btn = findViewById(R.id.online_cons_btn);
        book_appointment_btn = findViewById(R.id.book_appointment_btn);


        more_info_view.setOnClickListener(v -> {
            more_info_layout.setVisibility(View.VISIBLE);
            less_info_view.setVisibility(View.VISIBLE);
            more_info_view.setVisibility(View.GONE);
        });
        less_info_view.setOnClickListener(v -> {
            more_info_layout.setVisibility(View.GONE);
            more_info_view.setVisibility(View.VISIBLE);
            less_info_view.setVisibility(View.GONE);
        });
        book_appointment_btn.setOnClickListener(v -> {
            startActivity(new Intent(
                    Dr_Details_Activity.this, Patient_Details_Activity.class));
        });
        online_cons_btn.setOnClickListener(v -> {
            startActivity(new Intent(
                    Dr_Details_Activity.this, Patient_Details_Activity.class));
        });


    }
}