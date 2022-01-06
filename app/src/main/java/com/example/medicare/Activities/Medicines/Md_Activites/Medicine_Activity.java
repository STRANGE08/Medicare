package com.example.medicare.Activities.Medicines.Md_Activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines.Md_Adapters.Daily_Deals_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Featured_Brands_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Medicine_Category_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Medicines_Offer_Adapter;
import com.example.medicare.R;
import com.example.medicare.Utilities.SnapHelperOneByOne;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class Medicine_Activity extends AppCompatActivity {
    LinearLayout covid_essential, devices, nutritions, personal_care, ayurvedic, baby_mom, skin_care, diabtic_care;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        covid_essential = findViewById(R.id.covid_essential);
        devices = findViewById(R.id.devices);
        nutritions = findViewById(R.id.nutritions);
        personal_care = findViewById(R.id.personal_care);
        ayurvedic = findViewById(R.id.ayurvedic);
        baby_mom = findViewById(R.id.baby_mom);
        skin_care = findViewById(R.id.skin_care);
        diabtic_care = findViewById(R.id.diabtic_care);


        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        RecyclerView offers_recycler = findViewById(R.id.offers_recycler);
        ScrollingPagerIndicator recyclerIndicator = findViewById(R.id.recyclerIndicator);

        offers_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicine_Activity.this, RecyclerView.HORIZONTAL, false));
//        new PagerSnapHelper().attachToRecyclerView(offers_recycler);
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(offers_recycler);

        offers_recycler
                .setAdapter(new Medicines_Offer_Adapter(Medicine_Activity.this));
        recyclerIndicator.attachToRecyclerView(offers_recycler);


        RecyclerView categories_recycler = findViewById(R.id.categories_recycler);
        categories_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicine_Activity.this, RecyclerView.HORIZONTAL, false));
        categories_recycler
                .setAdapter(new Medicine_Category_Adapter(Medicine_Activity.this));

        RecyclerView featured_brands_recycler = findViewById(R.id.featured_brands_recycler);

        featured_brands_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicine_Activity.this, RecyclerView.HORIZONTAL, false));
        featured_brands_recycler
                .setAdapter(new Featured_Brands_Adapter(Medicine_Activity.this));

        RecyclerView daily_deals_recycler = findViewById(R.id.daily_deals_recycler);
        daily_deals_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicine_Activity.this, RecyclerView.HORIZONTAL, false));
        daily_deals_recycler
                .setAdapter(new Daily_Deals_Adapter(Medicine_Activity.this));


        findViewById(R.id.covid_essential).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "covid"));
        });
        findViewById(R.id.devices).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "devices"));
        });
        findViewById(R.id.nutritions).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "nutritions"));
        });
        findViewById(R.id.personal_care).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "personal_care"));
        });
        findViewById(R.id.ayurvedic).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "ayurvedic"));
        });
        findViewById(R.id.baby_mom).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "baby_mom"));
        });
        findViewById(R.id.diabtic_care).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "diabtic_care"));
        });
        findViewById(R.id.skin_care).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicines_List_Activity.class)
                    .putExtra("category", "skin_care"));
        });
        findViewById(R.id.go_to_cart).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Activity.this, Medicine_Cart_Activity.class));
        });

    }
}