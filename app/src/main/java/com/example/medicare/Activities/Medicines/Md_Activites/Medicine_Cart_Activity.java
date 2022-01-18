package com.example.medicare.Activities.Medicines.Md_Activites;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines.Md_Adapters.Cart_Items_Adapter;
import com.example.medicare.Adapters.Offer_Code_Adapter;
import com.example.medicare.R;

public class Medicine_Cart_Activity extends AppCompatActivity {
    LinearLayout promocode_layout, checkout_layout, apply_coupon_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        promocode_layout = findViewById(R.id.promocode_layout);
        checkout_layout = findViewById(R.id.checkout_layout);
        apply_coupon_layout = findViewById(R.id.apply_coupon_layout);

        TextView old_price = findViewById(R.id.old_price);
        old_price.setPaintFlags(old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        TextView delivery_charges = findViewById(R.id.delivery_charges);
        delivery_charges.setPaintFlags(delivery_charges.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        RecyclerView cart_item_recycler = findViewById(R.id.cart_item_recycler);
        cart_item_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicine_Cart_Activity.this, RecyclerView.VERTICAL, false));
        cart_item_recycler
                .setAdapter(new Cart_Items_Adapter(Medicine_Cart_Activity.this));

        findViewById(R.id.add_address).setOnClickListener(v -> {
            startActivity(new Intent(Medicine_Cart_Activity.this, Select_Address_activity.class));
        });

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });
        findViewById(R.id.cancel_button).setOnClickListener(v -> {
            promocode_layout.setVisibility(View.GONE);
            checkout_layout.setVisibility(View.VISIBLE);

        });
        findViewById(R.id.apply_coupon_layout).setOnClickListener(v -> {
            checkout_layout.setVisibility(View.GONE);
            promocode_layout.setVisibility(View.VISIBLE);

        });


        RecyclerView offers_code_recycler = findViewById(R.id.offers_code_recycler);
        offers_code_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Medicine_Cart_Activity.this, RecyclerView.VERTICAL, false));

        offers_code_recycler
                .setAdapter(new Offer_Code_Adapter(Medicine_Cart_Activity.this));

    }

    @Override
    public void onBackPressed() {
        if (promocode_layout.getVisibility() == View.VISIBLE) {
            promocode_layout.setVisibility(View.GONE);
            checkout_layout.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
    }


}