package com.example.medicare.Activities.Medicines.Md_Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines.Md_Activites.Track_Order_details_Activity;
import com.example.medicare.R;

public class Past_Order_Adapter extends RecyclerView.Adapter<Past_Order_Adapter.MyViewHolder> {
    Context context;

    public Past_Order_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_order_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.itemView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Track_Order_details_Activity.class)
                    .putExtra("status", "delivered"));
        });

        holder.track_order_tv.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Track_Order_details_Activity.class)
                    .putExtra("status", "delivered"));
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView track_order_tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            track_order_tv = itemView.findViewById(R.id.track_order_tv);

        }
    }
}
