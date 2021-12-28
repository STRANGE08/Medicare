package com.example.medicare.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Package_Details_Activity;
import com.example.medicare.R;

public class Health_packages_Adapter extends RecyclerView.Adapter<Health_packages_Adapter.MyViewHolder> {
    Context context;

    public Health_packages_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Health_packages_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_packages_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Health_packages_Adapter.MyViewHolder holder, int position) {
        holder.old_price.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.package_name.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Package_Details_Activity.class)
                    .putExtra("type","package"));
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView old_price,package_name;
        LinearLayout mLinear_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            old_price = itemView.findViewById(R.id.old_price);
            package_name = itemView.findViewById(R.id.package_name);
        }
    }
}
