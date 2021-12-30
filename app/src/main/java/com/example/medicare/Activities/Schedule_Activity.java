package com.example.medicare.Activities;

import android.os.Bundle;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Schedule_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setMinDate(System.currentTimeMillis());
    }
}