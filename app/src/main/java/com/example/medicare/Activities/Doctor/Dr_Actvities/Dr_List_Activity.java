package com.example.medicare.Activities.Doctor.Dr_Actvities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Doctor.Dr_Adapters.Popular_Dr_Adapter;
import com.example.medicare.R;

public class Dr_List_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_list);

        RecyclerView offers_recycler = findViewById(R.id.categorydetail_recycler);

        offers_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Dr_List_Activity.this, RecyclerView.VERTICAL, false));
//        new PagerSnapHelper().attachToRecyclerView(offers_recycler);
        offers_recycler
                .setAdapter(new Popular_Dr_Adapter(Dr_List_Activity.this));

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

    }
}