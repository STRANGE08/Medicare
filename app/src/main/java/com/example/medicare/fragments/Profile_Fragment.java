package com.example.medicare.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.medicare.Activities.Edit_Profile_Activity;
import com.example.medicare.Activities.Order_History_Activity;
import com.example.medicare.Activities.Settings_Activity;
import com.example.medicare.MainActivity;
import com.example.medicare.R;


public class Profile_Fragment extends Fragment {

    Context context;

    public Profile_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        view.findViewById(R.id.edit_profile_layout)
                .setOnClickListener(v -> {
                    startActivity(new Intent(context, Edit_Profile_Activity.class));
                });
        view.findViewById(R.id.settings_layout)
                .setOnClickListener(v -> {
                    startActivity(new Intent(context, Settings_Activity.class));
                });
        view.findViewById(R.id.notifications)
                .setOnClickListener(v -> {
                    startActivity(new Intent(context, MainActivity.class)
                            .putExtra("fragment_name", "notification"));
                });
        view.findViewById(R.id.order_history)
                .setOnClickListener(v -> {
                    startActivity(new Intent(context, Order_History_Activity.class)
                    .putExtra("from","profile"));
                });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

}