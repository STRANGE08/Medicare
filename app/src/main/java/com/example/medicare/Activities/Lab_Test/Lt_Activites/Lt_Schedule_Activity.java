package com.example.medicare.Activities.Lab_Test.Lt_Activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

public class Lt_Schedule_Activity extends AppCompatActivity {
    RelativeLayout btn_nineam, btn_twelve, btn_three, btn_fivepm, btn_sixpm, btn_eightpm;
    TextView tv_9am, tv_1230pm, tv_8pm, tv_6pm, tv_5pm, tv_3pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lt_schedule);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setMinDate(System.currentTimeMillis());

//        String from=getIntent().getStringExtra("from");

        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });


        btn_nineam = findViewById(R.id.btn_nineam);
        btn_twelve = findViewById(R.id.btn_twelve);
        btn_three = findViewById(R.id.btn_three);
        btn_fivepm = findViewById(R.id.btn_fivepm);
        btn_sixpm = findViewById(R.id.btn_sixpm);
        btn_eightpm = findViewById(R.id.btn_eightpm);

        tv_9am = findViewById(R.id.tv_9am);
        tv_1230pm = findViewById(R.id.tv_1230pm);
        tv_8pm = findViewById(R.id.tv_8pm);
        tv_6pm = findViewById(R.id.tv_6pm);
        tv_5pm = findViewById(R.id.tv_5pm);
        tv_3pm = findViewById(R.id.tv_3pm);

        btn_nineam.setOnClickListener(arg0 -> {
            tv_9am.setTextColor(getResources().getColor(R.color.white));
            tv_1230pm.setTextColor(getResources().getColor(R.color.black));
            tv_8pm.setTextColor(getResources().getColor(R.color.black));
            tv_6pm.setTextColor(getResources().getColor(R.color.black));
            tv_5pm.setTextColor(getResources().getColor(R.color.black));
            tv_3pm.setTextColor(getResources().getColor(R.color.black));

            btn_nineam.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn_twelve.setBackgroundColor(getResources().getColor(R.color.white));
            btn_three.setBackgroundColor(getResources().getColor(R.color.white));
            btn_fivepm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_sixpm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_eightpm.setBackgroundColor(getResources().getColor(R.color.white));
        });
        btn_twelve.setOnClickListener(arg0 -> {
            tv_9am.setTextColor(getResources().getColor(R.color.black));
            tv_1230pm.setTextColor(getResources().getColor(R.color.white));
            tv_8pm.setTextColor(getResources().getColor(R.color.black));
            tv_6pm.setTextColor(getResources().getColor(R.color.black));
            tv_5pm.setTextColor(getResources().getColor(R.color.black));
            tv_3pm.setTextColor(getResources().getColor(R.color.black));

            btn_twelve.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn_nineam.setBackgroundColor(getResources().getColor(R.color.white));
            btn_three.setBackgroundColor(getResources().getColor(R.color.white));
            btn_fivepm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_sixpm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_eightpm.setBackgroundColor(getResources().getColor(R.color.white));
        });
        btn_three.setOnClickListener(arg0 -> {
            tv_9am.setTextColor(getResources().getColor(R.color.black));
            tv_1230pm.setTextColor(getResources().getColor(R.color.black));
            tv_8pm.setTextColor(getResources().getColor(R.color.black));
            tv_6pm.setTextColor(getResources().getColor(R.color.black));
            tv_5pm.setTextColor(getResources().getColor(R.color.black));
            tv_3pm.setTextColor(getResources().getColor(R.color.white));

            btn_three.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn_twelve.setBackgroundColor(getResources().getColor(R.color.white));
            btn_nineam.setBackgroundColor(getResources().getColor(R.color.white));
            btn_fivepm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_sixpm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_eightpm.setBackgroundColor(getResources().getColor(R.color.white));
        });
        btn_fivepm.setOnClickListener(arg0 -> {

            tv_9am.setTextColor(getResources().getColor(R.color.black));
            tv_1230pm.setTextColor(getResources().getColor(R.color.black));
            tv_8pm.setTextColor(getResources().getColor(R.color.black));
            tv_6pm.setTextColor(getResources().getColor(R.color.black));
            tv_5pm.setTextColor(getResources().getColor(R.color.white));
            tv_3pm.setTextColor(getResources().getColor(R.color.black));


            btn_fivepm.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn_twelve.setBackgroundColor(getResources().getColor(R.color.white));
            btn_three.setBackgroundColor(getResources().getColor(R.color.white));
            btn_nineam.setBackgroundColor(getResources().getColor(R.color.white));
            btn_sixpm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_eightpm.setBackgroundColor(getResources().getColor(R.color.white));
        });
        btn_sixpm.setOnClickListener(arg0 -> {
            tv_9am.setTextColor(getResources().getColor(R.color.black));
            tv_1230pm.setTextColor(getResources().getColor(R.color.black));
            tv_8pm.setTextColor(getResources().getColor(R.color.black));
            tv_6pm.setTextColor(getResources().getColor(R.color.white));
            tv_5pm.setTextColor(getResources().getColor(R.color.black));
            tv_3pm.setTextColor(getResources().getColor(R.color.black));


            btn_sixpm.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn_twelve.setBackgroundColor(getResources().getColor(R.color.white));
            btn_three.setBackgroundColor(getResources().getColor(R.color.white));
            btn_fivepm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_nineam.setBackgroundColor(getResources().getColor(R.color.white));
            btn_eightpm.setBackgroundColor(getResources().getColor(R.color.white));
        });
        btn_eightpm.setOnClickListener(arg0 -> {

            tv_9am.setTextColor(getResources().getColor(R.color.black));
            tv_1230pm.setTextColor(getResources().getColor(R.color.black));
            tv_8pm.setTextColor(getResources().getColor(R.color.white));
            tv_6pm.setTextColor(getResources().getColor(R.color.black));
            tv_5pm.setTextColor(getResources().getColor(R.color.black));
            tv_3pm.setTextColor(getResources().getColor(R.color.black));


            btn_eightpm.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn_twelve.setBackgroundColor(getResources().getColor(R.color.white));
            btn_three.setBackgroundColor(getResources().getColor(R.color.white));
            btn_fivepm.setBackgroundColor(getResources().getColor(R.color.white));
            btn_nineam.setBackgroundColor(getResources().getColor(R.color.white));
            btn_sixpm.setBackgroundColor(getResources().getColor(R.color.white));
        });


        findViewById(R.id.cnf_schedule_btn).setOnClickListener(v -> {
            startActivity(new Intent(Lt_Schedule_Activity.this, Lt_Payment_Activity.class));
        });
    }
}