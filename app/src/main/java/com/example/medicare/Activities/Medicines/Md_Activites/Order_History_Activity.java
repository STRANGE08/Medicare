package com.example.medicare.Activities.Medicines.Md_Activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines.Md_Adapters.Open_Order_Adapter;
import com.example.medicare.Activities.Medicines.Md_Adapters.Past_Order_Adapter;
import com.example.medicare.MainActivity;
import com.example.medicare.R;

public class Order_History_Activity extends AppCompatActivity {
    RecyclerView open_order_recycler, past_order_recycler;
    String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        from = getIntent().getStringExtra("from");

        open_order_recycler = findViewById(R.id.open_order_recycler);
        open_order_recycler.setLayoutManager(
                new LinearLayoutManager(
                        Order_History_Activity.this, RecyclerView.VERTICAL, false));
        open_order_recycler.setAdapter(new Open_Order_Adapter(Order_History_Activity.this));


        past_order_recycler = findViewById(R.id.past_order_recycler);
        past_order_recycler.setLayoutManager(
                new LinearLayoutManager(
                        Order_History_Activity.this, RecyclerView.VERTICAL, false));
        past_order_recycler.setAdapter(new Past_Order_Adapter(Order_History_Activity.this));

        findViewById(R.id.back).setOnClickListener(v -> {
            if (from.equalsIgnoreCase("checkout")) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("fragment_name", "home");
                startActivity(intent);
            } else if (from.equalsIgnoreCase("profile")) {
                finish();
            }
        });

    }

    public void onBackPressed() {
        if (from.equalsIgnoreCase("checkout")) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("fragment_name", "home");
            startActivity(intent);
        } else {
            finish();
        }
    }

}
