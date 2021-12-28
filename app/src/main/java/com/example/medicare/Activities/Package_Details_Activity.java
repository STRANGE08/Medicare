package com.example.medicare.Activities;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.medicare.Adapters.Included_tests_Adapter;
import com.example.medicare.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class Package_Details_Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    TextView description_tv,old_price;
    LinearLayout test_requirements;
    ImageView down_arrow, up_arrow;
    RelativeLayout included_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        included_layout = findViewById(R.id.included_layout);

        description_tv = findViewById(R.id.description_tv);
        test_requirements = findViewById(R.id.test_requirements);
        down_arrow = findViewById(R.id.down_arrow);
        up_arrow = findViewById(R.id.up_arrow);
        old_price = findViewById(R.id.old_price);
        old_price.setPaintFlags(old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        tabLayout.addTab(tabLayout.newTab().setText("Description"));
        tabLayout.addTab(tabLayout.newTab().setText("Test Requirement"));
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView tab2 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab2, null);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setCustomView(tabOne);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setCustomView(tab2);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    description_tv.setVisibility(View.VISIBLE);
                    test_requirements.setVisibility(View.GONE);
                } else {
                    description_tv.setVisibility(View.GONE);
                    test_requirements.setVisibility(View.VISIBLE);
                }
//                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        RecyclerView included_tests_recycler = findViewById(R.id.included_tests);

        String type = getIntent().getStringExtra("type");
        if (type.equalsIgnoreCase("labtest")) {
            included_layout.setVisibility(View.GONE);
        } else if (type.equalsIgnoreCase("package")) {
            included_layout.setVisibility(View.VISIBLE);
            ArrayList<String> include_test_list = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                include_test_list.add("Vitamin B12");
                include_test_list.add("Peripheril Smear(PS)");
                include_test_list.add("SGOT/SGPT Ratio");
                include_test_list.add("EGFR");
                include_test_list.add("Chol LDL");
                include_test_list.add("Vitamin D Total");
                include_test_list.add("Complete Blood Count(CBC)");
            }

            included_tests_recycler.setLayoutManager(
                    new LinearLayoutManager(
                            Package_Details_Activity.this, RecyclerView.VERTICAL, false)
            );
            included_tests_recycler.setAdapter(new Included_tests_Adapter(Package_Details_Activity.this, include_test_list));

        }

        down_arrow.setOnClickListener(v -> {
            down_arrow.setVisibility(View.GONE);
            up_arrow.setVisibility(View.VISIBLE);
            included_tests_recycler.setVisibility(View.VISIBLE);

        });
        up_arrow.setOnClickListener(v -> {
            up_arrow.setVisibility(View.GONE);
            down_arrow.setVisibility(View.VISIBLE);
            included_tests_recycler.setVisibility(View.GONE);

        });

    }
}