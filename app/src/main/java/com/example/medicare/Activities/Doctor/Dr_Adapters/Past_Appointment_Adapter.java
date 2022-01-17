package com.example.medicare.Activities.Doctor.Dr_Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Appointment_summery_Activity;
import com.example.medicare.R;

public class Past_Appointment_Adapter extends RecyclerView.Adapter<Past_Appointment_Adapter.MyViewHolder> {


    Context context;

    public Past_Appointment_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_appointment_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.complete_layout.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Appointment_summery_Activity.class)
                    .putExtra("status", "complete"));
        });
        holder.canceled_layout.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Appointment_summery_Activity.class)
                    .putExtra("status", "canceled"));
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout canceled_layout, complete_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            complete_layout = itemView.findViewById(R.id.complete_layout);
            canceled_layout = itemView.findViewById(R.id.canceled_layout);
        }
    }
}
