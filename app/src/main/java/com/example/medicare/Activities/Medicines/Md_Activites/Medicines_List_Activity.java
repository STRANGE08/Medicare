package com.example.medicare.Activities.Medicines.Md_Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines.Md_Adapters.Medicine_Products_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Medicine_subcategory_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Medicines_Offer_Adapter;
import com.example.medicare.R;
import com.example.medicare.Utilities.SnapHelperOneByOne;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class Medicines_List_Activity extends AppCompatActivity {
    TextView category_name;
    RecyclerView subcategories_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines_list);
        category_name = findViewById(R.id.category_name);
        subcategories_recycler = findViewById(R.id.subcategories_recycler);
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        if (category.equalsIgnoreCase("covid")) {
            category_name.setText("Covid Essentials");
        } else if (category.equalsIgnoreCase("devices")) {
            category_name.setText("Devices");
        } else if (category.equalsIgnoreCase("nutritions")) {
            category_name.setText("Nutrition & Fitness");
        } else if (category.equalsIgnoreCase("personal_care")) {
            category_name.setText("Personal Care");
        } else if (category.equalsIgnoreCase("ayurvedic")) {
            category_name.setText("Ayurvedic Care");
        } else if (category.equalsIgnoreCase("baby_mom")) {
            category_name.setText("Baby & Mom Care");
        } else if (category.equalsIgnoreCase("skin_care")) {
            category_name.setText("Skin Care");
        } else if (category.equalsIgnoreCase("diabtic_care")) {
            category_name.setText("Diabtic Care");
        } else {
            category_name.setText("Brand Name");
            subcategories_recycler.setVisibility(View.GONE);
        }

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        RecyclerView medicine_offers_recycler = findViewById(R.id.medicine_offers_recycler);
        ScrollingPagerIndicator recyclerIndicator = findViewById(R.id.recyclerIndicator3);

        medicine_offers_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicines_List_Activity.this, RecyclerView.HORIZONTAL, false));
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(medicine_offers_recycler);

        medicine_offers_recycler
                .setAdapter(
                        new Medicines_Offer_Adapter(
                                Medicines_List_Activity.this));
        recyclerIndicator.attachToRecyclerView(medicine_offers_recycler);


        RecyclerView products_recycler = findViewById(R.id.products_recycler);
        products_recycler
                .setLayoutManager(
                        new GridLayoutManager(Medicines_List_Activity.this, 2));

        products_recycler.setAdapter(
                new Medicine_Products_Adapter(
                        Medicines_List_Activity.this));


        subcategories_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicines_List_Activity.this, RecyclerView.HORIZONTAL, false));
        subcategories_recycler.setAdapter(
                new Medicine_subcategory_Adapter(
                        Medicines_List_Activity.this));

        findViewById(R.id.go_to_cart).setOnClickListener(v -> {
            startActivity(new Intent(Medicines_List_Activity.this, Medicine_Cart_Activity.class));
        });

    }
}