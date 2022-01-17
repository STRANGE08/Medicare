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

public class Upcoming_Appointments_Adapter extends RecyclerView.Adapter<Upcoming_Appointments_Adapter.MyViewHolder> {
    Context context;

    public Upcoming_Appointments_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_appointment_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.confirm_layout.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Appointment_summery_Activity.class)
                    .putExtra("status", "confirm"));
        });
        holder.pending_layout.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Appointment_summery_Activity.class)
                    .putExtra("status", "pending"));
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout pending_layout, confirm_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            pending_layout = itemView.findViewById(R.id.pending_layout);
            confirm_layout = itemView.findViewById(R.id.confirm_layout);
        }
    }
}
