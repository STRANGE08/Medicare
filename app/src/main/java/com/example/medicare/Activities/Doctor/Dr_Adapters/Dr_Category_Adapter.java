package com.example.medicare.Activities.Doctor.Dr_Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Doctor.Dr_Actvities.Dr_List_Activity;
import com.example.medicare.R;

public class Dr_Category_Adapter extends RecyclerView.Adapter<Dr_Category_Adapter.MyViewHolder> {
    Context context;

    public Dr_Category_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Dr_Category_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dr_category_layout, null);
        return new Dr_Category_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dr_Category_Adapter.MyViewHolder holder, int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(v.getContext(), position + "htghg", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Dr_List_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return 18;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

