package com.example.medicare.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.medicare.R;

public class Add_Balance_Activity extends AppCompatActivity {

    LinearLayout hundred, five_hundred, thousand, two_thousand, five_thousand;
    EditText amount_to_add_et;
    LinearLayout card_pay, upi_pay, paytm, okicici, ybl, card_details_layout, upi_pay_layout;
    CardView pay_by_card, pay_by_upi;

    EditText card_expiry_et, card_no_et, upi_et;
    TextView upi_tv, card_tv, amount_card_add_tv, amount_upi_add_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);

        hundred = findViewById(R.id.hundred);
        five_hundred = findViewById(R.id.five_hundred);
        thousand = findViewById(R.id.thousand);
        two_thousand = findViewById(R.id.two_thousand);
        five_thousand = findViewById(R.id.five_thousand);
        amount_to_add_et = findViewById(R.id.amount_to_add_et);
        amount_card_add_tv = findViewById(R.id.amount_card_add_tv);
        amount_upi_add_tv = findViewById(R.id.amount_upi_add_tv);

        upi_tv = findViewById(R.id.upi_tv);
        card_tv = findViewById(R.id.card_tv);
        card_expiry_et = findViewById(R.id.card_expiry_et);
        card_no_et = findViewById(R.id.card_no_et);

        upi_pay = findViewById(R.id.upi_pay);
        card_pay = findViewById(R.id.card_pay);
        card_details_layout = findViewById(R.id.card_details_layout);
        upi_pay_layout = findViewById(R.id.upi_pay_layout);
        pay_by_card = findViewById(R.id.pay_by_card);
        pay_by_upi = findViewById(R.id.pay_by_upi);

        paytm = findViewById(R.id.paytm);
        okicici = findViewById(R.id.okicici);
        ybl = findViewById(R.id.ybl);
        upi_et = findViewById(R.id.upi_et);


        pay_by_card.setOnClickListener(v -> {
            finish();
            Toast.makeText(Add_Balance_Activity.this, "Balance added successfully", Toast.LENGTH_SHORT).show();
        });

        pay_by_upi.setOnClickListener(v -> {
            Toast.makeText(Add_Balance_Activity.this, "Balance added successfully", Toast.LENGTH_SHORT).show();
            finish();
        });

        upi_pay.setOnClickListener(v -> {
            if (!amount_to_add_et.getText().toString().equalsIgnoreCase("")) {
                amount_upi_add_tv.setText("Add ₹" + amount_to_add_et.getText().toString());

                upi_pay.setBackgroundResource(R.drawable.address_et_background2);
                upi_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
                card_pay.setBackgroundResource(R.drawable.address_et_background);
                card_tv.setTextColor(getResources().getColor(R.color.black));
                upi_pay_layout.setVisibility(View.VISIBLE);
                card_details_layout.setVisibility(View.GONE);
            }
        });

        card_pay.setOnClickListener(v -> {
            if (!amount_to_add_et.getText().toString().equalsIgnoreCase("")) {
                amount_card_add_tv.setText("Add ₹" + amount_to_add_et.getText().toString());

                card_pay.setBackgroundResource(R.drawable.address_et_background2);
                card_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
                upi_pay.setBackgroundResource(R.drawable.address_et_background);
                upi_tv.setTextColor(getResources().getColor(R.color.black));
                card_details_layout.setVisibility(View.VISIBLE);
                upi_pay_layout.setVisibility(View.GONE);
            }
        });


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


        findViewById(R.id.back).setOnClickListener(v -> finish());


        hundred.setOnClickListener(v -> {
            if (amount_to_add_et.getText().toString().equalsIgnoreCase("")) {
                int new_amount = 100;
                amount_to_add_et.setText("" + new_amount);
            } else {

                String string_amount = amount_to_add_et.getText().toString().replace("₹", "");
                int amount = Integer.parseInt(string_amount);
                int new_amount = amount + 100;

                amount_to_add_et.setText("" + new_amount);
            }
        });
        five_hundred.setOnClickListener(v -> {

            if (amount_to_add_et.getText().toString().equalsIgnoreCase("")) {
                int new_amount = 500;
                amount_to_add_et.setText("" + new_amount);
            } else {

                String string_amount = amount_to_add_et.getText().toString().replace("₹", "");
                int amount = Integer.parseInt(string_amount);
                int new_amount = amount + 500;

                amount_to_add_et.setText("" + new_amount);
            }

        });
        thousand.setOnClickListener(v -> {
            if (amount_to_add_et.getText().toString().equalsIgnoreCase("")) {
                int new_amount = 1000;
                amount_to_add_et.setText("" + new_amount);
            } else {
                String string_amount = amount_to_add_et.getText().toString().replace("₹", "");
                int amount = Integer.parseInt(string_amount);
                int new_amount = amount + 1000;

                amount_to_add_et.setText("" + new_amount);
            }
        });
        two_thousand.setOnClickListener(v -> {

            if (amount_to_add_et.getText().toString().equalsIgnoreCase("")) {
                int new_amount = 2000;
                amount_to_add_et.setText("" + new_amount);
            } else {
                String string_amount = amount_to_add_et.getText().toString().replace("₹", "");
                int amount = Integer.parseInt(string_amount);
                int new_amount = amount + 2000;

                amount_to_add_et.setText("" + new_amount);
            }

        });
        five_thousand.setOnClickListener(v -> {
            if (amount_to_add_et.getText().toString().equalsIgnoreCase("")) {
                int new_amount = 5000;
                amount_to_add_et.setText("" + new_amount);
            } else {
                String string_amount = amount_to_add_et.getText().toString().replace("₹", "");
                int amount = Integer.parseInt(string_amount);
                int new_amount = amount + 5000;

                amount_to_add_et.setText("" + new_amount);
            }
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
    }
}