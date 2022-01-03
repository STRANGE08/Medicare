package com.example.medicare.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Lab_Test.Package_Details_Activity;
import com.example.medicare.R;

public class Popular_health_checkup_Adapter extends RecyclerView.Adapter<Popular_health_checkup_Adapter.MyViewHolder> {

    Context context;

    public Popular_health_checkup_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_checkup_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.old_price.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.health_checkups.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Package_Details_Activity.class)
                    .putExtra("type", "package"));
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView old_price;
        RelativeLayout health_checkups;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            old_price = itemView.findViewById(R.id.old_price);
            health_checkups = itemView.findViewById(R.id.health_checkups);

        }
    }
}
