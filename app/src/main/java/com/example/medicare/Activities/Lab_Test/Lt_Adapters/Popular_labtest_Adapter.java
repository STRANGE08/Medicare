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

public class Popular_labtest_Adapter extends RecyclerView.Adapter<Popular_labtest_Adapter.MyViewHolder> {

    Context context;

    public Popular_labtest_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_labtest_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.old_price.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.old_price2.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.old_price3.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.old_price4.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        holder.itemView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Package_Details_Activity.class)
                    .putExtra("type", "labtest"));
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView old_price, old_price2, old_price3, old_price4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            old_price = itemView.findViewById(R.id.old_price);
            old_price2 = itemView.findViewById(R.id.old_price2);
            old_price3 = itemView.findViewById(R.id.old_price3);
            old_price4 = itemView.findViewById(R.id.old_price4);
        }
    }
}
