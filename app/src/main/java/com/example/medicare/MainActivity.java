package com.example.medicare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.medicare.fragments.Doctor_Fragment;
import com.example.medicare.fragments.Home_Fragment;
import com.example.medicare.fragments.LabTest_Fragment;
import com.example.medicare.fragments.Notification_Fragment;
import com.example.medicare.fragments.Profile_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {
    FrameLayout fragmentcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentcontainer = findViewById(R.id.fragmentcontainer);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomnavigation_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Home_Fragment()).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Home_Fragment()).commit();
            }
            if (item.getItemId() == R.id.labtest) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new LabTest_Fragment()).commit();
            }
            if (item.getItemId() == R.id.notification) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Notification_Fragment()).commit();
            }
            if (item.getItemId() == R.id.profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Profile_Fragment()).commit();
            }
            if (item.getItemId() == R.id.map_doctor) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Doctor_Fragment()).commit();
            }
            return true;
        });
        Intent intent = getIntent();
        String fragment_name = intent.getStringExtra("fragment_name");
        if (fragment_name.equalsIgnoreCase("home")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Home_Fragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.home);
        } else if (fragment_name.equalsIgnoreCase("doctor")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Doctor_Fragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.map_doctor);
        } else if (fragment_name.equalsIgnoreCase("notification")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Notification_Fragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.notification);
        } else if (fragment_name.equalsIgnoreCase("profile")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Profile_Fragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.profile);
        }else if (fragment_name.equalsIgnoreCase("labtest")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new LabTest_Fragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.labtest);
             }

//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            if (item.getItemId() == R.id.home) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Home_Fragment()).commit();
//            }
//            if (item.getItemId() == R.id.map_doctor) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Doctor_Fragment()).commit();
//            }
//            if (item.getItemId() == R.id.notification) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Notification_Fragment()).commit();
//            }
//            if (item.getItemId() == R.id.labtest) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new LabTest_Fragment()).commit();
//            }
//            if (item.getItemId() == R.id.profile) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Profile_Fragment()).commit();
//            }
//            return true;
//        });

    }
}