package com.example.medicare.Activities.Doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

import com.example.medicare.Activities.Medicines.Medicine_Checkout_Activity;
import com.example.medicare.Activities.Medicines.Order_History_Activity;
import com.example.medicare.R;

public class Dr_Payment_Activity extends AppCompatActivity {
    TextView upi_tv, card_tv, wallet_tv;
    LinearLayout  card_pay, upi_pay, card_details_layout,
            upi_pay_layout, paytm, okicici, ybl, checkout_layout, wallet_pay, wallet_pay_layout;

    EditText card_expiry_et, card_no_et, upi_et;
    CardView pay_by_card, pay_by_upi, pay_by_wallet;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_payment);

        upi_pay = findViewById(R.id.upi_pay);
        card_pay = findViewById(R.id.card_pay);
        upi_tv = findViewById(R.id.upi_tv);
        card_tv = findViewById(R.id.card_tv);
        card_expiry_et = findViewById(R.id.card_expiry_et);
        card_no_et = findViewById(R.id.card_no_et);
        card_details_layout = findViewById(R.id.card_details_layout);
        pay_by_card = findViewById(R.id.pay_by_card);
        pay_by_upi = findViewById(R.id.pay_by_upi);
        upi_pay_layout = findViewById(R.id.upi_pay_layout);
        upi_et = findViewById(R.id.upi_et);
        checkout_layout = findViewById(R.id.checkout_layout);
        wallet_pay = findViewById(R.id.wallet_pay);
        wallet_tv = findViewById(R.id.wallet_tv);
        wallet_pay_layout = findViewById(R.id.wallet_pay_layout);
        pay_by_wallet = findViewById(R.id.pay_by_wallet);


        wallet_pay.setOnClickListener(v -> {
            wallet_pay.setBackgroundResource(R.drawable.address_et_background2);
            wallet_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));
            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));
            wallet_pay_layout.setVisibility(View.VISIBLE);
            upi_pay_layout.setVisibility(View.GONE);
            card_details_layout.setVisibility(View.GONE);
            

        });
        upi_pay.setOnClickListener(v -> {
            upi_pay.setBackgroundResource(R.drawable.address_et_background2);
            upi_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));
            wallet_pay.setBackgroundResource(R.drawable.address_et_background);
            wallet_tv.setTextColor(getResources().getColor(R.color.black));
            upi_pay_layout.setVisibility(View.VISIBLE);
            card_details_layout.setVisibility(View.GONE);
            
            wallet_pay_layout.setVisibility(View.GONE);

        });

        card_pay.setOnClickListener(v -> {
            wallet_pay.setBackgroundResource(R.drawable.address_et_background);
            wallet_tv.setTextColor(getResources().getColor(R.color.black));
            card_pay.setBackgroundResource(R.drawable.address_et_background2);
            card_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));
            card_details_layout.setVisibility(View.VISIBLE);
            upi_pay_layout.setVisibility(View.GONE);
            
            wallet_pay_layout.setVisibility(View.GONE);


        });


        pay_by_wallet.setOnClickListener(v -> {
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));
            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));

            card_details_layout.setVisibility(View.GONE);
            upi_pay_layout.setVisibility(View.GONE);
            wallet_pay_layout.setVisibility(View.GONE);

            order_cnf();
        });
        pay_by_card.setOnClickListener(v -> {
            upi_pay.setBackgroundResource(R.drawable.address_et_background);
            upi_tv.setTextColor(getResources().getColor(R.color.black));

            card_details_layout.setVisibility(View.GONE);
            upi_pay_layout.setVisibility(View.GONE);
            wallet_pay_layout.setVisibility(View.GONE);

            order_cnf();
        });
        pay_by_upi.setOnClickListener(v -> {

            card_pay.setBackgroundResource(R.drawable.address_et_background);
            card_tv.setTextColor(getResources().getColor(R.color.black));

            upi_pay_layout.setVisibility(View.GONE);
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
//            startActivity(new Intent(Dr_Payment_Activity.this, Order_History_Activity.class)
//                    .putExtra("from", "checkout"));
        });

    }
}