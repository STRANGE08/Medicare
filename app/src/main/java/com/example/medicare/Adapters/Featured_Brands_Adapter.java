package com.example.medicare.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines.Medicines_List_Activity;
import com.example.medicare.R;

public class Featured_Brands_Adapter extends RecyclerView.Adapter<Featured_Brands_Adapter.MyviewHolder> {
    Context context;

    public Featured_Brands_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_brands_layout_item, null);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.brand_name.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "Brand Name"));
        });
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        LinearLayout brand_name;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            brand_name = itemView.findViewById(R.id.brand_name);
        }
    }
}
