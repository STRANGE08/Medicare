package com.example.medicare.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Adapters.Last_Transaction_Adapter;
import com.example.medicare.R;

public class Wallet_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        RecyclerView last_transactions_rv = findViewById(R.id.last_transactions_rv);

        last_transactions_rv
                .setLayoutManager(
                        new LinearLayoutManager(
                                Wallet_Activity.this, RecyclerView.VERTICAL, false));

        last_transactions_rv
                .setAdapter(
                        new Last_Transaction_Adapter(Wallet_Activity.this));
    }
}