package com.example.medicare.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Lab_Test.Lt_Activites.Lab_test_Packages_Activity;
import com.example.medicare.Activities.Lab_Test.Lt_Adapters.LabTest_Category_Adapter;
import com.example.medicare.Activities.Lab_Test.Lt_Adapters.Labtest_offer_Adapter;
import com.example.medicare.Activities.Lab_Test.Lt_Adapters.Popular_health_checkup_Adapter;
import com.example.medicare.Activities.Lab_Test.Lt_Adapters.Popular_labtest_Adapter;
import com.example.medicare.R;
import com.example.medicare.Utilities.SnapHelperOneByOne;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class LabTest_Fragment extends Fragment {
    Context context;

    public LabTest_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lab_test_, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        RecyclerView popular_health_package_recycler = view.findViewById(R.id.popular_health_package_recycler);
        popular_health_package_recycler.setLayoutManager(
                new LinearLayoutManager(
                        context, LinearLayoutManager.HORIZONTAL, false));
        popular_health_package_recycler
                .setAdapter(new Popular_health_checkup_Adapter(context));


        RecyclerView category_recycler = view.findViewById(R.id.category_recycler);
        category_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, LinearLayoutManager.HORIZONTAL, false));
        category_recycler
                .setAdapter(new LabTest_Category_Adapter(context));

        RecyclerView medicine_offers_recycler = view.findViewById(R.id.offers_recycler);
        ScrollingPagerIndicator recyclerIndicator = view.findViewById(R.id.recyclerIndicator);
        medicine_offers_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, LinearLayoutManager.HORIZONTAL, false));
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(medicine_offers_recycler);
        medicine_offers_recycler
                .setAdapter(
                        new Labtest_offer_Adapter(context));
        recyclerIndicator.attachToRecyclerView(medicine_offers_recycler);

        RecyclerView popular_test_recycler = view.findViewById(R.id.popular_test_recycler);

        popular_test_recycler.setLayoutManager(
                new LinearLayoutManager(
                        context, LinearLayoutManager.VERTICAL, false));
        popular_test_recycler
                .setAdapter(new Popular_labtest_Adapter(context));

        view.findViewById(R.id.view_all).setOnClickListener(v -> {
            startActivity(new Intent(context, Lab_test_Packages_Activity.class)
                    .putExtra("name", "package"));
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}