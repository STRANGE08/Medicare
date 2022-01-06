package com.example.medicare.Activities.Lab_Test.Lt_Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Lab_Test.Lt_Activites.Lab_test_Packages_Activity;
import com.example.medicare.R;

public class LabTest_Category_Adapter extends RecyclerView.Adapter<LabTest_Category_Adapter.MyViewHolder> {
    Context context;

    public LabTest_Category_Adapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.labtest_category_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.category_name.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Lab_test_Packages_Activity.class)
                    .putExtra("name", "labtest"));
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout category_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name = itemView.findViewById(R.id.category_name);

        }
    }
}
