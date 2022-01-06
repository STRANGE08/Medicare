package com.example.medicare.Activities.Medicines.Md_Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Select_Address_activity extends AppCompatActivity {
    LinearLayout home_linear, work_linear, other_linear, add_address, add_address_layout, address_layout;
    LinearLayout work_address, home_address;
    boolean home, work, other;
    TextView home_tv, work_tv, other_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        home_linear = findViewById(R.id.home_linear);
        work_linear = findViewById(R.id.work_linear);
        other_linear = findViewById(R.id.other_linear);
        add_address = findViewById(R.id.add_address);
        add_address_layout = findViewById(R.id.add_address_layout);
        work_address = findViewById(R.id.work_address);
        home_address = findViewById(R.id.home_address);
        address_layout = findViewById(R.id.address_layout);
        home_tv = findViewById(R.id.home_tv);
        work_tv = findViewById(R.id.work_tv);
        other_tv = findViewById(R.id.other_tv);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        home_linear.setOnClickListener(v -> {
            home = true;
            work = false;
            other = false;
            home_linear.setBackgroundResource(R.drawable.edittext_background2);
            home_tv.setTextColor(getResources().getColor(R.color.white));

            work_linear.setBackgroundResource(R.drawable.edittext_background);
            work_tv.setTextColor(getResources().getColor(R.color.black));

            other_linear.setBackgroundResource(R.drawable.edittext_background);
            other_tv.setTextColor(getResources().getColor(R.color.black));

        });
        work_linear.setOnClickListener(v -> {
            home = false;
            work = true;
            other = false;

            work_linear.setBackgroundResource(R.drawable.edittext_background2);
            work_tv.setTextColor(getResources().getColor(R.color.white));

            home_linear.setBackgroundResource(R.drawable.edittext_background);
            home_tv.setTextColor(getResources().getColor(R.color.black));

            other_linear.setBackgroundResource(R.drawable.edittext_background);
            other_tv.setTextColor(getResources().getColor(R.color.black));

        });
        other_linear.setOnClickListener(v -> {

            other_linear.setBackgroundResource(R.drawable.edittext_background2);
            other_tv.setTextColor(getResources().getColor(R.color.white));

            home_linear.setBackgroundResource(R.drawable.edittext_background);
            home_tv.setTextColor(getResources().getColor(R.color.black));

            work_linear.setBackgroundResource(R.drawable.edittext_background);
            work_tv.setTextColor(getResources().getColor(R.color.black));
        });


        add_address.setOnClickListener(v -> {
            add_address_layout.setVisibility(View.VISIBLE);
            address_layout.setVisibility(View.GONE);
        });

        findViewById(R.id.save_address).setOnClickListener(v -> {
            add_address_layout.setVisibility(View.GONE);
            address_layout.setVisibility(View.VISIBLE);
        });
        work_address.setOnClickListener(v -> {
            startActivity(new Intent(Select_Address_activity.this, Medicine_Checkout_Activity.class));
        });
        home_address.setOnClickListener(v -> {
            startActivity(new Intent(Select_Address_activity.this, Medicine_Checkout_Activity.class));
        });

    }
}