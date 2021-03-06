package com.example.medicare.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Doctor.Dr_Adapters.Dr_Category_Adapter;
import com.example.medicare.R;


public class Doctor_Fragment extends Fragment {

    public Doctor_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doctor, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView category_recycler = view.findViewById(R.id.category_recycler);
        category_recycler
                .setLayoutManager(
                        new GridLayoutManager(getActivity(), 2));
        category_recycler
                .setAdapter(new Dr_Category_Adapter(getActivity()));

    }


}