package com.example.medicare.Activities.Medicines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.medicare.R;
import com.example.medicare.Utilities.StepView.VerticalStepView;

import java.util.ArrayList;
import java.util.List;

public class Track_Order_details_Activity extends AppCompatActivity {
    TextView rate_review_tv, need_help_tv;
    private VerticalStepView mSetpview0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order_details);

        String status = getIntent().getStringExtra("status");
        mSetpview0 = findViewById(R.id.step_view0);
        rate_review_tv = findViewById(R.id.rate_review_tv);
        need_help_tv = findViewById(R.id.need_help_tv);

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });


        if (status.equalsIgnoreCase("open")) {
            List<String> list0 = new ArrayList<>();
            list0.add("Order  \n Expected Delivery on 26 Dec 21");
            list0.add("Ready to Ship \n 10:00 am 21 Dec 21");
            list0.add("In Transit \n 01:00 pm 23 Dec 21");
            list0.add("Out for Delivery \n Today");
            mSetpview0.setStepsViewIndicatorComplectingPosition(list0.size() - 2)
                    .reverseDraw(false)//default is true
                    .setTextSize(14)
                    .setStepViewTexts(list0)
                    .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.colorPrimary))
                    .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.colorGrey))
                    .setStepViewComplectedTextColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.black))
                    .setStepViewUnComplectedTextColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.colorGrey))
                    .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(Track_Order_details_Activity.this, R.drawable.selected_check))
                    .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(Track_Order_details_Activity.this, R.drawable.default_icon))
                    .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(Track_Order_details_Activity.this, R.drawable.selected_check));

        } else if (status.equalsIgnoreCase("delivered")) {
            need_help_tv.setVisibility(View.GONE);
            rate_review_tv.setVisibility(View.VISIBLE);
            List<String> list2 = new ArrayList<>();
            list2.add("Order  \n Expected Delivery on 26 Dec 21");
            list2.add("Ready to Ship \n 10:00 am 21 Dec 21");
            list2.add("In Transit \n 01:00 pm 23 Dec 21");
            list2.add("Delivered \n Today");
            mSetpview0.setStepsViewIndicatorComplectingPosition(list2.size() - 1)
                    .reverseDraw(false)//default is true
                    .setTextSize(14)
                    .setStepViewTexts(list2)
                    .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.colorPrimary))
                    .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.colorGrey))
                    .setStepViewComplectedTextColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.black))
                    .setStepViewUnComplectedTextColor(ContextCompat.getColor(Track_Order_details_Activity.this, R.color.colorGrey))
                    .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(Track_Order_details_Activity.this, R.drawable.selected_check))
                    .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(Track_Order_details_Activity.this, R.drawable.default_icon))
                    .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(Track_Order_details_Activity.this, R.drawable.selected_check));

        }


        rate_review_tv.setOnClickListener(v -> {
            startActivity(new Intent(Track_Order_details_Activity.this, Rate_Review_Product_Activity.class));
        });
    }
}