package com.example.medicare.Activities.Doctor.Dr_Actvities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Doctor.Dr_Adapters.Past_Appointment_Adapter;
import com.example.medicare.Activities.Doctor.Dr_Adapters.Upcoming_Appointments_Adapter;
import com.example.medicare.MainActivity;
import com.example.medicare.R;

public class My_Appointment_list_Activity extends AppCompatActivity {
    String from;

    TextView upcoming_appointment_tv, past_appointment_tv;

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
        RecyclerView my_appointments_rv = findViewById(R.id.my_appointments_rv);
        my_appointments_rv
                .setLayoutManager(
                        new LinearLayoutManager(
                                My_Appointment_list_Activity.this, RecyclerView.VERTICAL, false
                        ));

        my_appointments_rv.setAdapter(new Upcoming_Appointments_Adapter(My_Appointment_list_Activity.this));


        upcoming_appointment_tv = findViewById(R.id.upcoming_appointment_tv);
        past_appointment_tv = findViewById(R.id.past_appointment_tv);

        upcoming_appointment_tv.setOnClickListener(v -> {
            upcoming_appointment_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            past_appointment_tv.setTextColor(getResources().getColor(R.color.black));

            my_appointments_rv.setAdapter(new Upcoming_Appointments_Adapter(My_Appointment_list_Activity.this));
        });

        past_appointment_tv.setOnClickListener(v -> {
            past_appointment_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            upcoming_appointment_tv.setTextColor(getResources().getColor(R.color.black));
            my_appointments_rv.setAdapter(new Past_Appointment_Adapter(My_Appointment_list_Activity.this));

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