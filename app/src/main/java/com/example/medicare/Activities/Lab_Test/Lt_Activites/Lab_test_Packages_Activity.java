package com.example.medicare.Activities.Lab_Test.Lt_Activites;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Lab_Test.Lt_Adapters.Health_packages_Adapter;
import com.example.medicare.Activities.Lab_Test.Lt_Adapters.Labtest_List_Adapter;
import com.example.medicare.R;

public class Lab_test_Packages_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_packages);


        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        TextView test_category_name_tv = findViewById(R.id.test_category_name_tv);
        String name = getIntent().getStringExtra("name");

        RecyclerView health_package_recycler_recycler = findViewById(R.id.health_package_recycler_recycler);
        health_package_recycler_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                Lab_test_Packages_Activity.this, RecyclerView.VERTICAL, false));

        if (name.equalsIgnoreCase("package")) {
            test_category_name_tv.setText("Health packages");
            health_package_recycler_recycler
                    .setAdapter(new Health_packages_Adapter(Lab_test_Packages_Activity.this));
        } else if (name.equalsIgnoreCase("labtest")) {
            test_category_name_tv.setText("Lab Tests");
            health_package_recycler_recycler
                    .setAdapter(new Labtest_List_Adapter(Lab_test_Packages_Activity.this));
        }

    }
}