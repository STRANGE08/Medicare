package com.example.medicare.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicines_List_Activity;
import com.example.medicare.R;

public class Medicine_Category_Adapter extends RecyclerView.Adapter<Medicine_Category_Adapter.MyViewHolder> {
    Context context;

    public Medicine_Category_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_category_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.covid_essential.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "covid"));
        });
        holder.devices.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "devices"));
        });
        holder.nutritions.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "nutritions"));
        });
        holder.personal_care.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "personal_care"));
        });
        holder.ayurvedic.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "ayurvedic"));
        });
        holder.baby_mom.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "baby_mom"));
        });
        holder.diabtic_care.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "diabtic_care"));
        });
        holder.skin_care.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Medicines_List_Activity.class)
                    .putExtra("category", "skin_care"));
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout covid_essential, devices, nutritions, personal_care, ayurvedic, baby_mom, skin_care, diabtic_care;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            covid_essential = itemView.findViewById(R.id.covid_essential);
            devices = itemView.findViewById(R.id.devices);
            nutritions = itemView.findViewById(R.id.nutritions);
            personal_care = itemView.findViewById(R.id.personal_care);
            ayurvedic = itemView.findViewById(R.id.ayurvedic);
            baby_mom = itemView.findViewById(R.id.baby_mom);
            skin_care = itemView.findViewById(R.id.skin_care);
            diabtic_care = itemView.findViewById(R.id.diabtic_care);
        }
    }
}
