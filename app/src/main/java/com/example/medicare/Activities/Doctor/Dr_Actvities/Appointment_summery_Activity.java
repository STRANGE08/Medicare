package com.example.medicare.Activities.Doctor.Dr_Actvities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Appointment_summery_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_summery);

        String status = getIntent().getStringExtra("status");


        LinearLayout for_others_layout = findViewById(R.id.for_others_layout);
        TextView cnf_tv = findViewById(R.id.cnf_tv);
        TextView pending_tv = findViewById(R.id.pending_tv);
        TextView complete_tv = findViewById(R.id.complete_tv);
        TextView canceled_tv = findViewById(R.id.canceled_tv);
        TextView change_date_tv = findViewById(R.id.change_date_tv);
        TextView rate_review_tv = findViewById(R.id.rate_review_tv);


        if (status.equalsIgnoreCase("pending")) {

            pending_tv.setVisibility(View.VISIBLE);
            for_others_layout.setVisibility(View.VISIBLE);
            change_date_tv.setVisibility(View.VISIBLE);
            cnf_tv.setVisibility(View.GONE);
            canceled_tv.setVisibility(View.GONE);
            complete_tv.setVisibility(View.GONE);

        } else if (status.equalsIgnoreCase("confirm")) {

            cnf_tv.setVisibility(View.VISIBLE);
            for_others_layout.setVisibility(View.VISIBLE);
            pending_tv.setVisibility(View.GONE);
            complete_tv.setVisibility(View.GONE);
            canceled_tv.setVisibility(View.GONE);
            change_date_tv.setVisibility(View.GONE);
            for_others_layout.setVisibility(View.GONE);

        } else if (status.equalsIgnoreCase("complete")) {

            complete_tv.setVisibility(View.VISIBLE);
            canceled_tv.setVisibility(View.GONE);
            cnf_tv.setVisibility(View.GONE);
            pending_tv.setVisibility(View.GONE);
            for_others_layout.setVisibility(View.GONE);
            change_date_tv.setVisibility(View.GONE);
            rate_review_tv.setVisibility(View.VISIBLE);

        } else if (status.equalsIgnoreCase("canceled")) {

            canceled_tv.setVisibility(View.VISIBLE);
            complete_tv.setVisibility(View.GONE);
            cnf_tv.setVisibility(View.GONE);
            pending_tv.setVisibility(View.GONE);
            for_others_layout.setVisibility(View.GONE);
            change_date_tv.setVisibility(View.GONE);

        }


        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        rate_review_tv.setOnClickListener(v -> {
            startActivity(new Intent(Appointment_summery_Activity.this, Rate_Doctor_Activity.class));
        });
    }
}