package com.example.medicare.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.R;

import java.util.ArrayList;

public class Included_tests_Adapter extends RecyclerView.Adapter<Included_tests_Adapter.MyViewHolder> {

    Context context;
    ArrayList<String> include_test_list;

    public Included_tests_Adapter(Context context, ArrayList<String> include_test_list) {
        this.context = context;
        this.include_test_list = include_test_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.included_tests_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.test_name.setText(include_test_list.get(position));
    }

    @Override
    public int getItemCount() {
        return include_test_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView test_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            test_name = itemView.findViewById(R.id.test_name);
        }
    }
}
