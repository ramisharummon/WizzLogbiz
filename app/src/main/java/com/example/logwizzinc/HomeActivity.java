package com.example.logwizzinc;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);


        }


    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_dashboard) {
            return true;
        } else if (itemId == R.id.menu_home) {

            return true;
        } else if (itemId == R.id.menu_private_files) {

            return true;
        } else if (itemId == R.id.menu_my_courses) {

            return true;
        } else if (itemId == R.id.menu_attendance) {

            return true;
        } else {
            return false;
        }
        }




    private void openDashboard() {

        Toast.makeText(this, "Opening Dashboard", Toast.LENGTH_SHORT).show();
    }

    private void openHome() {

        Toast.makeText(this, "Opening Home", Toast.LENGTH_SHORT).show();
    }

    private void openPrivateFiles() {

        Toast.makeText(this, "Opening Private Files", Toast.LENGTH_SHORT).show();
    }

    private void openMyCourses() {

        Toast.makeText(this, "Opening My Courses", Toast.LENGTH_SHORT).show();
    }

    private void openAttendance() {

        Toast.makeText(this, "Opening Attendance", Toast.LENGTH_SHORT).show();


        }

    }










