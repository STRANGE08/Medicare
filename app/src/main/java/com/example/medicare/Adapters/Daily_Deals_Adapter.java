package com.example.medicare.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Activities.Medicine_Activity;
import com.example.medicare.R;

public class Daily_Deals_Adapter extends RecyclerView.Adapter<Daily_Deals_Adapter.MyviewHolder> {
    Context context;

    public Daily_Deals_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_deals_layout_item, null);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.old_price.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView old_price;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            old_price = itemView.findViewById(R.id.old_price);
        }
    }
}
