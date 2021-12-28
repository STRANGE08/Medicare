package com.example.medicare.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.medicare.Adapters.Popular_Dr_Adapter;
import com.example.medicare.R;
import com.example.medicare.Utilities.SnapHelperOneByOne;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

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