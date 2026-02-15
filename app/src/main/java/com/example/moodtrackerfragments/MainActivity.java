package com.example.moodtrackerfragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        // הגדרת מאזין ללחיצות בתפריט
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();
            int color = Color.WHITE;
            if (id == R.id.nav_happy) {
                selectedFragment = new HappyFragment();
                color = Color.parseColor("#E8F5E9");
            } else if (id == R.id.nav_neutral) {
                selectedFragment = new NeutralFragment();
                color = Color.parseColor("#E3F2FD");
            } else if (id == R.id.nav_sad) {
                selectedFragment = new SadFragment();
                color = Color.parseColor("#F5F5F5");
            }

            // החלפת הפרגמנט בפועל
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                bottomNav.setBackgroundColor(color);
            }
            return true;
        });

        // הצגת פרגמנט ברירת מחדל בכניסה לאפליקציה
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HappyFragment())
                    .commit();
        }
    }
}