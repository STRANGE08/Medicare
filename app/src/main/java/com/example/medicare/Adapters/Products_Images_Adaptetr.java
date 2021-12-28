package com.example.medicare.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.R;

public class Products_Images_Adaptetr extends RecyclerView.Adapter<Products_Images_Adaptetr.MyViewHolder> {

    Context context;

    public Products_Images_Adaptetr(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Products_Images_Adaptetr.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_images_layout_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Products_Images_Adaptetr.MyViewHolder holder, int position) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //if you need three fix imageview in width
        int devicewidth = displaymetrics.widthPixels;

        //if you need 4-5-6 anything fix imageview in height
        int deviceheight = displaymetrics.heightPixels / 4;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.width = devicewidth;
        holder.mrelative.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mrelative;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mrelative = itemView.findViewById(R.id.mrelative);
        }
    }
}
