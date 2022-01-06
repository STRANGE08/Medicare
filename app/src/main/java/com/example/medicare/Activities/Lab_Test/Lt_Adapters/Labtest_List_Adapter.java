package com.example.medicare.Activities.Lab_Test.Lt_Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Lab_Test.Lt_Activites.Package_Details_Activity;
import com.example.medicare.R;

public class Labtest_List_Adapter extends RecyclerView.Adapter<Labtest_List_Adapter.MyViewHolder> {
    Context context;

    public Labtest_List_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.labtest_list_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.old_price.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.package_name.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Package_Details_Activity.class)
                    .putExtra("type", "labtest"));
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView old_price, package_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            old_price = itemView.findViewById(R.id.old_price);
            package_name = itemView.findViewById(R.id.package_name);
        }
    }
}
