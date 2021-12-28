package com.example.medicare.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.MainActivity;
import com.example.medicare.R;

public class Login_Activity extends AppCompatActivity {
    TextView send_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        send_otp = findViewById(R.id.send_otp);
        findViewById(R.id.go_to_main2).setOnClickListener(v -> {
//            startActivity(new Intent(Login_Activity.this, MainActivity.class));
//            finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("fragment_name", "home");
            startActivity(intent);
        });
        findViewById(R.id.register_go).setOnClickListener(v -> {
            startActivity(new Intent(Login_Activity.this, Register_Activity.class));
            finish();
        });
        findViewById(R.id.send_otp).setOnClickListener(v -> {
            send_otp.setText("Sent");
        });
    }

    @Override
    public void onBackPressed() {
//        startActivity(new Intent(Login_Activity.this, Go_to_Login_Signup_Activity.class));
        finish();
    }
}