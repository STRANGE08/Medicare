package com.example.medicare.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.R;

public class Medicine_subcategory_Adapter extends RecyclerView.Adapter<Medicine_subcategory_Adapter.MyViewHolder> {

    Context context;
    int selectedPosition = 0;

    public Medicine_subcategory_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcategory_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (selectedPosition == holder.getAdapterPosition()) {
            holder.subcategories_tv.setTextColor(Color.parseColor("#0A9085"));
            holder.subcategories_layout.setBackground(context.getDrawable(R.drawable.selected_category_background));
        } else {

            holder.subcategories_tv.setTextColor(Color.parseColor("#FF000000"));
            holder.subcategories_layout.setBackground(context.getDrawable(R.drawable.round_edittext_background));
        }

        holder.itemView.setOnClickListener(v -> {
            selectedPosition = holder.getAdapterPosition();
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView subcategories_tv;
        LinearLayout subcategories_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subcategories_tv = itemView.findViewById(R.id.subcategories_tv);
            subcategories_layout = itemView.findViewById(R.id.subcategories_layout);
        }
    }
}
