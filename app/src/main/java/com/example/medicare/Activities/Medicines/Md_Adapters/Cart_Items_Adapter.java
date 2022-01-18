package com.example.medicare.Activities.Medicines.Md_Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.R;

public class Cart_Items_Adapter extends RecyclerView.Adapter<Cart_Items_Adapter.MyViewHolder> {
    Context context;

    public Cart_Items_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.old_price.setPaintFlags(holder.old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.delete_item.setOnClickListener(v -> {
//            notifyItemRemoved(position);
//            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView old_price;
        ImageView delete_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            old_price = itemView.findViewById(R.id.old_price);
            delete_item = itemView.findViewById(R.id.delete_item);
        }
    }


}
