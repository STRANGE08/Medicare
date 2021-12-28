package com.example.medicare.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Adapters.Notification_Adapter;
import com.example.medicare.Adapters.Offers_Adapder_HomeFrag;
import com.example.medicare.R;


public class Notification_Fragment extends Fragment {
    Context context;

    public Notification_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        RecyclerView notification_recycler = view.findViewById(R.id.notification_recycler);
        notification_recycler
                .setLayoutManager(
                        new LinearLayoutManager(
                                context, RecyclerView.VERTICAL, false));
        notification_recycler
                .setAdapter(new Notification_Adapter(context));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

}
