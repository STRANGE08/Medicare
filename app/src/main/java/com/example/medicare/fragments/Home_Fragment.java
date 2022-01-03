package com.example.medicare.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Doctor.Popular_Dr_Activity;
import com.example.medicare.Activities.Lab_Test.Lab_test_Packages_Activity;
import com.example.medicare.Activities.Medicines.Medicine_Activity;
import com.example.medicare.Activities.Medicines.Medicine_Cart_Activity;
import com.example.medicare.Activities.Medicines.Medicines_List_Activity;
import com.example.medicare.Adapters.Labtest_offer_Adapter;
import com.example.medicare.Adapters.Medicine_Category_Adapter;
import com.example.medicare.Adapters.Medicines_Offer_Adapter;
import com.example.medicare.Adapters.Popular_Dr_Adapter;
import com.example.medicare.Adapters.Popular_health_checkup_Adapter;
import com.example.medicare.Adapters.Popular_labtest_Adapter;
import com.example.medicare.MainActivity;
import com.example.medicare.R;
import com.example.medicare.Utilities.SnapHelperOneByOne;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class Home_Fragment extends Fragment {
    Context context;

    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LinearLayout covid_essential, devices, nutritions, personal_care,
                ayurvedic, baby_mom, skin_care, more_medicine_ctgry;

        covid_essential = view.findViewById(R.id.covid_essential);
        devices = view.findViewById(R.id.devices);
        nutritions = view.findViewById(R.id.nutritions);
        personal_care = view.findViewById(R.id.personal_care);
        ayurvedic = view.findViewById(R.id.ayurvedic);
        baby_mom = view.findViewById(R.id.baby_mom);
        skin_care = view.findViewById(R.id.skin_care);
        more_medicine_ctgry = view.findViewById(R.id.more_medicine_ctgry);


        RecyclerView offers_recycler = view.findViewById(R.id.offers_recycler);
        ScrollingPagerIndicator recyclerIndicator = view.findViewById(R.id.recyclerIndicator);
        offers_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, RecyclerView.HORIZONTAL, false));
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(offers_recycler);
        offers_recycler
                .setAdapter(new Labtest_offer_Adapter(context));
        recyclerIndicator.attachToRecyclerView(offers_recycler);


        RecyclerView offers2_recycler = view.findViewById(R.id.offers2_recycler);
        offers2_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, RecyclerView.HORIZONTAL, false));
        LinearSnapHelper linearSnapHelper3 = new SnapHelperOneByOne();
        linearSnapHelper3.attachToRecyclerView(offers2_recycler);
        offers2_recycler
                .setAdapter(new Medicines_Offer_Adapter(context));
        ScrollingPagerIndicator offers2_Indicator = view.findViewById(R.id.offers2_Indicator);
        offers2_Indicator.attachToRecyclerView(offers2_recycler);

        RecyclerView categories_recycler = view.findViewById(R.id.categories_recycler);
        categories_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, RecyclerView.HORIZONTAL, false));

        categories_recycler
                .setAdapter(new Medicine_Category_Adapter(context));


        RecyclerView popular_dr_recycler = view.findViewById(R.id.popular_dr_recycler);
        popular_dr_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, RecyclerView.HORIZONTAL, false));
        LinearSnapHelper linearSnapHelper2 = new SnapHelperOneByOne();
        linearSnapHelper2.attachToRecyclerView(popular_dr_recycler);
        popular_dr_recycler
                .setAdapter(new Popular_Dr_Adapter(context));
        ScrollingPagerIndicator drIndicator = view.findViewById(R.id.drIndicator);
        drIndicator.attachToRecyclerView(popular_dr_recycler);


        view.findViewById(R.id.more_dr_tv).setOnClickListener(v -> {
            startActivity(new Intent(context, Popular_Dr_Activity.class));
        });
        view.findViewById(R.id.more_packages).setOnClickListener(v -> {
            startActivity(new Intent(context, Lab_test_Packages_Activity.class)
                    .putExtra("name", "package"));
        });

        RecyclerView popular_package_recycler = view.findViewById(R.id.popular_package_recycler);
        popular_package_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, RecyclerView.HORIZONTAL, false));

        popular_package_recycler
                .setAdapter(new Popular_health_checkup_Adapter(context));

        RecyclerView popular_test_recycler = view.findViewById(R.id.popular_test_recycler);
        popular_test_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, RecyclerView.VERTICAL, false));

        popular_test_recycler
                .setAdapter(new Popular_labtest_Adapter(context));

        view.findViewById(R.id.go_to_medicine).setOnClickListener(v -> {
            startActivity(new Intent(context, Medicine_Activity.class));
        });
        view.findViewById(R.id.go_to_dr_frag).setOnClickListener(v -> {
            startActivity(new Intent(context, MainActivity.class)
                    .putExtra("fragment_name", "doctor"));
        });
        view.findViewById(R.id.go_to_labtest).setOnClickListener(v -> {
            startActivity(new Intent(context, MainActivity.class)
                    .putExtra("fragment_name", "labtest"));
        });


        view.findViewById(R.id.go_to_cart).setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicine_Cart_Activity.class));
        });
        covid_essential.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "covid"));
        });
        devices.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "devices"));
        });
        nutritions.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "nutritions"));
        });
        personal_care.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "personal_care"));
        });
        ayurvedic.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "ayurvedic"));
        });
        baby_mom.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "baby_mom"));
        });
        more_medicine_ctgry.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicine_Activity.class));
        });
        skin_care.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "skin_care"));
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

}