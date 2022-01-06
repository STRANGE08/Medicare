package com.example.medicare.Activities.Doctor.Dr_Actvities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Doctor.Dr_Adapters.Popular_Dr_Adapter;
import com.example.medicare.R;

public class Popular_Dr_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_dr);

        RecyclerView popular_dr_recycler = findViewById(R.id.popular_dr_recycler);
        popular_dr_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Popular_Dr_Activity.this, RecyclerView.VERTICAL, false));
        popular_dr_recycler
                .setAdapter(new Popular_Dr_Adapter(Popular_Dr_Activity.this));

    }
}