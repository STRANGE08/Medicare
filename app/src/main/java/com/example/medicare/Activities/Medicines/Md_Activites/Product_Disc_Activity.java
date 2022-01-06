package com.example.medicare.Activities.Medicines.Md_Activites;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines.Md_Adapters.Daily_Deals_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Featured_Brands_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Products_Images_Adaptetr;
import com.example.medicare.R;
import com.example.medicare.Utilities.SnapHelperOneByOne;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class Product_Disc_Activity extends AppCompatActivity {
    TextView old_price, plus_item, item_count, minus_item, total_item_incart;
    Button add_to_cart;
    LinearLayout total_items_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_disc);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        RecyclerView products_images_recycler = findViewById(R.id.products_images_recycler);
        ScrollingPagerIndicator recyclerIndicator = findViewById(R.id.recyclerIndicator);

        products_images_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Product_Disc_Activity.this, RecyclerView.HORIZONTAL, false));
//        new PagerSnapHelper().attachToRecyclerView(offers_recycler);
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(products_images_recycler);

        products_images_recycler
                .setAdapter(new Products_Images_Adaptetr(Product_Disc_Activity.this));
        recyclerIndicator.attachToRecyclerView(products_images_recycler);

        old_price = findViewById(R.id.old_price);
        old_price.setPaintFlags(old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        add_to_cart = findViewById(R.id.add_to_cart);
        plus_item = findViewById(R.id.plus_item);
        minus_item = findViewById(R.id.minus_item);
        total_item_incart = findViewById(R.id.total_item_incart);

        item_count = findViewById(R.id.item_count);

        total_items_layout = findViewById(R.id.total_items_layout);
        add_to_cart.setOnClickListener(v -> {
            add_to_cart.setVisibility(View.GONE);
            total_items_layout.setVisibility(View.VISIBLE);
            total_item_incart.setVisibility(View.VISIBLE);
            item_count.setText("1");
            total_item_incart.setText("1");
        });

        plus_item.setOnClickListener(v -> {
            int item_count_int = Integer.parseInt(item_count.getText().toString());
            item_count.setText("" + (item_count_int + 1));
            total_item_incart.setText("" + (item_count_int + 1));
        });
        minus_item.setOnClickListener(v -> {
            int item_count_int = Integer.parseInt(item_count.getText().toString());
            if (item_count_int == 1) {
                add_to_cart.setVisibility(View.VISIBLE);
                total_items_layout.setVisibility(View.GONE);
                total_item_incart.setVisibility(View.GONE);
            } else {
                item_count.setText("" + (item_count_int - 1));
                total_item_incart.setText("" + (item_count_int - 1));
            }
        });


        RecyclerView featured_brands_recycler = findViewById(R.id.featured_brands_recycler);

        featured_brands_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Product_Disc_Activity.this, RecyclerView.HORIZONTAL, false));
        featured_brands_recycler
                .setAdapter(new Featured_Brands_Adapter(Product_Disc_Activity.this));

        RecyclerView daily_deals_recycler = findViewById(R.id.daily_deals_recycler);
        daily_deals_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Product_Disc_Activity.this, RecyclerView.HORIZONTAL, false));
        daily_deals_recycler
                .setAdapter(new Daily_Deals_Adapter(Product_Disc_Activity.this));


        findViewById(R.id.go_to_cart).setOnClickListener(v -> {
            startActivity(new Intent(Product_Disc_Activity.this, Medicine_Cart_Activity.class));
        });


    }
}