package com.example.medicare.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.medicare.Activities.Doctor.Dr_Actvities.Dr_Schedule_Activity;
import com.example.medicare.Activities.Doctor.Dr_Actvities.Patient_Details_Activity;
import com.example.medicare.Activities.Doctor.Dr_Actvities.Rate_Doctor_Activity;
import com.example.medicare.R;

public class Appointment_summery_Activity extends AppCompatActivity {
    private PopupWindow mPopupWindow;
    LinearLayout summery_layout, for_others_layout,dr_app_layout,lab_test_layout;
    TextView cnf_tv, pending_tv, complete_tv, canceled_tv,
            change_date_tv, cancel_appointment_tv, rate_review_tv;
    CardView cancel_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_summery);

        String status = getIntent().getStringExtra("status");
        String type = getIntent().getStringExtra("type");

        summery_layout = findViewById(R.id.summery_layout);
        dr_app_layout = findViewById(R.id.dr_app_layout);
        lab_test_layout = findViewById(R.id.lab_test_layout);

        for_others_layout = findViewById(R.id.for_others_layout);
        cnf_tv = findViewById(R.id.cnf_tv);
        pending_tv = findViewById(R.id.pending_tv);
        complete_tv = findViewById(R.id.complete_tv);
        canceled_tv = findViewById(R.id.canceled_tv);
        change_date_tv = findViewById(R.id.change_date_tv);
        rate_review_tv = findViewById(R.id.rate_review_tv);
        cancel_appointment_tv = findViewById(R.id.cancel_appointment_tv);

        cancel_card = findViewById(R.id.cancel_card);

        if (type.equalsIgnoreCase("doctor")) {
            dr_app_layout.setVisibility(View.VISIBLE);
            lab_test_layout.setVisibility(View.GONE);
            if (status.equalsIgnoreCase("pending")) {
                pending_tv.setVisibility(View.VISIBLE);
                for_others_layout.setVisibility(View.VISIBLE);
                change_date_tv.setVisibility(View.VISIBLE);
                cnf_tv.setVisibility(View.GONE);
                canceled_tv.setVisibility(View.GONE);
                complete_tv.setVisibility(View.GONE);
                cancel_card.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase("confirm")) {
                cnf_tv.setVisibility(View.VISIBLE);
                for_others_layout.setVisibility(View.VISIBLE);
                pending_tv.setVisibility(View.GONE);
                complete_tv.setVisibility(View.GONE);
                canceled_tv.setVisibility(View.GONE);
                change_date_tv.setVisibility(View.GONE);
                for_others_layout.setVisibility(View.GONE);
                cancel_card.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase("complete")) {
                complete_tv.setVisibility(View.VISIBLE);
                canceled_tv.setVisibility(View.GONE);
                cnf_tv.setVisibility(View.GONE);
                pending_tv.setVisibility(View.GONE);
                for_others_layout.setVisibility(View.GONE);
                change_date_tv.setVisibility(View.GONE);
                rate_review_tv.setVisibility(View.VISIBLE);
                cancel_card.setVisibility(View.GONE);
            } else if (status.equalsIgnoreCase("canceled")) {
                canceled_tv.setVisibility(View.VISIBLE);
                complete_tv.setVisibility(View.GONE);
                cnf_tv.setVisibility(View.GONE);
                pending_tv.setVisibility(View.GONE);
                for_others_layout.setVisibility(View.GONE);
                change_date_tv.setVisibility(View.GONE);
                cancel_card.setVisibility(View.GONE);
            }
        }
        else if (type.equalsIgnoreCase("lab_test")) {
            dr_app_layout.setVisibility(View.GONE);
            lab_test_layout.setVisibility(View.VISIBLE);
            if (status.equalsIgnoreCase("pending")) {
                pending_tv.setVisibility(View.VISIBLE);
                for_others_layout.setVisibility(View.VISIBLE);
                change_date_tv.setVisibility(View.VISIBLE);
                cnf_tv.setVisibility(View.GONE);
                canceled_tv.setVisibility(View.GONE);
                complete_tv.setVisibility(View.GONE);
                cancel_card.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase("confirm")) {
                cnf_tv.setVisibility(View.VISIBLE);
                for_others_layout.setVisibility(View.VISIBLE);
                pending_tv.setVisibility(View.GONE);
                complete_tv.setVisibility(View.GONE);
                canceled_tv.setVisibility(View.GONE);
                change_date_tv.setVisibility(View.GONE);
                for_others_layout.setVisibility(View.GONE);
                cancel_card.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase("complete")) {
                complete_tv.setVisibility(View.VISIBLE);
                canceled_tv.setVisibility(View.GONE);
                cnf_tv.setVisibility(View.GONE);
                pending_tv.setVisibility(View.GONE);
                for_others_layout.setVisibility(View.GONE);
                change_date_tv.setVisibility(View.GONE);
                rate_review_tv.setVisibility(View.VISIBLE);
                cancel_card.setVisibility(View.GONE);
            } else if (status.equalsIgnoreCase("canceled")) {
                canceled_tv.setVisibility(View.VISIBLE);
                complete_tv.setVisibility(View.GONE);
                cnf_tv.setVisibility(View.GONE);
                pending_tv.setVisibility(View.GONE);
                for_others_layout.setVisibility(View.GONE);
                change_date_tv.setVisibility(View.GONE);
                cancel_card.setVisibility(View.GONE);
            }
        }


        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        rate_review_tv.setOnClickListener(v -> {
            startActivity(
                    new Intent(
                            Appointment_summery_Activity.this,
                            Rate_Doctor_Activity.class));
        });


        change_date_tv.setOnClickListener(v -> {
            startActivity(
                    new Intent(
                            Appointment_summery_Activity.this,
                            Dr_Schedule_Activity.class)
                            .putExtra("from", "appointment"));
        });

        for_others_layout.setOnClickListener(v1 -> {
            startActivity(
                    new Intent(
                            Appointment_summery_Activity.this,
                            Patient_Details_Activity.class)
                            .putExtra("from", "appointment"));
        });

        cancel_appointment_tv.setOnClickListener(v -> {

            fun_cancel_appointment();

        });
    }

    void fun_cancel_appointment() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.cancel_appointment_layout, null);
        mPopupWindow = new PopupWindow(customView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setElevation(5.0f);
        mPopupWindow.setFocusable(true);

        mPopupWindow.update();

        mPopupWindow.showAtLocation(summery_layout, Gravity.CENTER, 0, 0);

        TextView cancel_appointment = customView.findViewById(R.id.cancel_appointment);
        EditText reason_et = customView.findViewById(R.id.reason_et);

        reason_et.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(reason_et, InputMethodManager.SHOW_IMPLICIT);

        RelativeLayout closebtn = customView.findViewById(R.id.closebtn);
        closebtn.setOnClickListener(view -> {
            mPopupWindow.dismiss();

        });

        cancel_appointment.setOnClickListener(v1 -> {
            if (reason_et.getText().toString().equalsIgnoreCase("")) {
                Toast.makeText(
                        Appointment_summery_Activity.this,
                        "Please enter reason for cancellation",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(
                        Appointment_summery_Activity.this,
                        "Appointment Canceled",
                        Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                canceled_tv.setVisibility(View.VISIBLE);
                complete_tv.setVisibility(View.GONE);
                cnf_tv.setVisibility(View.GONE);
                pending_tv.setVisibility(View.GONE);
                for_others_layout.setVisibility(View.GONE);
                change_date_tv.setVisibility(View.GONE);
                cancel_card.setVisibility(View.GONE);
            }
        });

    }
}