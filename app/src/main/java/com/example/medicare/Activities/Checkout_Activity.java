package com.example.medicare.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.medicare.R;

public class Checkout_Activity extends AppCompatActivity {
    TextView change_address, upi_tv, cod_tv, card_tv;
    LinearLayout cod_pay, card_pay, upi_pay, card_details_layout, upi_pay_layout, paytm, okicici, ybl, checkout_layout;
    EditText card_expiry_et, card_no_et, upi_et;
    CardView pay_by_card, pay_by_upi, pay_by_cod;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        change_address = findViewById(R.id.change_address);
        upi_pay = findViewById(R.id.upi_pay);
        cod_pay = findViewById(R.id.cod_pay);
        card_pay = findViewById(R.id.card_pay);
        upi_tv = findViewById(R.id.upi_tv);
        cod_tv = findViewById(R.id.cod_tv);
        card_tv = findViewById(R.id.card_tv);
        card_expiry_et = findViewById(R.id.card_expiry_et);
        card_no_et = findViewById(R.id.card_no_et);
        card_details_layout = findViewById(R.id.card_details_layout);
        pay_by_card = findViewById(R.id.pay_by_card);
        pay_by_upi = findViewById(R.id.pay_by_upi);
        upi_pay_layout = findViewById(R.id.upi_pay_layout);
        upi_et = findViewById(R.id.upi_et);
        pay_by_cod = findViewById(R.id.pay_by_cod);
        checkout_layout = findViewById(R.id.checkout_layout);


        change_address.setOnClickListener(v -> {
            finish();
        });
        upi_pay.setOnClickListener(v -> {
            upi_pay.setBackgroundResource(R.drawable.address_et_background2);
            upi_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));
            cod_pay.setBackgroundResource(R.drawable.address_et_background);
            cod_tv.setTextColor(getResources().getColor(R.color.black));
            upi_pay_layout.setVisibility(View.VISIBLE);
            card_details_layout.setVisibility(View.GONE);
            pay_by_cod.setVisibility(View.GONE);

        });

        card_pay.setOnClickListener(v -> {
            card_pay.setBackgroundResource(R.drawable.address_et_background2);
            card_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));
            cod_pay.setBackgroundResource(R.drawable.address_et_background);
            cod_tv.setTextColor(getResources().getColor(R.color.black));

            card_details_layout.setVisibility(View.VISIBLE);
            upi_pay_layout.setVisibility(View.GONE);
            pay_by_cod.setVisibility(View.GONE);


        });
        cod_pay.setOnClickListener(v -> {
            cod_pay.setBackgroundResource(R.drawable.address_et_background2);
            cod_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));
            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));
            pay_by_cod.setVisibility(View.VISIBLE);
            card_details_layout.setVisibility(View.GONE);
            upi_pay_layout.setVisibility(View.GONE);

        });
        pay_by_card.setOnClickListener(v -> {
            cod_pay.setBackgroundResource(R.drawable.address_et_background);
            cod_tv.setTextColor(getResources().getColor(R.color.black));
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));

            card_details_layout.setVisibility(View.GONE);
            upi_pay_layout.setVisibility(View.GONE);

            order_cnf();
        });
        pay_by_upi.setOnClickListener(v -> {
            cod_pay.setBackgroundResource(R.drawable.address_et_background);
            cod_tv.setTextColor(getResources().getColor(R.color.black));

            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));

            upi_pay_layout.setVisibility(View.GONE);
            order_cnf();
        });
        pay_by_cod.setOnClickListener(v -> {
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));

            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));

            pay_by_cod.setVisibility(View.GONE);
            order_cnf();
        });


        card_expiry_et.addTextChangedListener(new TextWatcher() {
            int prevL = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prevL = card_expiry_et.getText().toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if ((prevL < length) && (length == 2)) {
                    editable.append("/");
                }
            }
        });
        card_no_et.addTextChangedListener(new TextWatcher() {
            int prevL = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prevL = card_no_et.getText().toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if ((prevL < length) && (length == 4 || length == 9 || length == 14)) {
                    editable.append("-");
                }
            }
        });

        paytm = findViewById(R.id.paytm);
        okicici = findViewById(R.id.okicici);
        ybl = findViewById(R.id.ybl);
        upi_et = findViewById(R.id.upi_et);

        paytm.setOnClickListener(v -> {
            String s = upi_et.getText().toString();
            upi_et.setText(s + "@paytm");
        });
        okicici.setOnClickListener(v -> {
            String s = upi_et.getText().toString();
            upi_et.setText(s + "@okicici");
        });
        ybl.setOnClickListener(v -> {
            String s = upi_et.getText().toString();
            upi_et.setText(s + "@ybl");
        });


        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

    }


    void order_cnf() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_order_cnflayout, null);
        mPopupWindow = new PopupWindow(customView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setElevation(5.0f);
        // Set a click listener for the popup window close button

        mPopupWindow.showAtLocation(checkout_layout, Gravity.CENTER, 0, 0);

        RelativeLayout closebtn = customView.findViewById(R.id.closebtn);
        closebtn.setOnClickListener(view -> {
            mPopupWindow.dismiss();
            startActivity(new Intent(Checkout_Activity.this, Order_History_Activity.class)
                    .putExtra("from", "checkout"));
        });

    }
}