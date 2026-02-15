package com.example.moodtrackerfragments;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        EditText nameInput = findViewById(R.id.etName);
        // הגדרת מאזין ללחיצות בתפריט
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();
            int color = Color.WHITE;
            if (id == R.id.nav_happy) {
                selectedFragment = new HappyFragment();
                color = Color.GREEN;
            } else if (id == R.id.nav_neutral) {
                selectedFragment = new NeutralFragment();
                color = Color.YELLOW;
            } else if (id == R.id.nav_sad) {
                selectedFragment = new SadFragment();
                color = Color.BLUE;
            }

            if (selectedFragment != null) {
                String userName = nameInput.getText().toString();
                Bundle envelope = new Bundle();
                envelope.putString("my_name", userName);
                selectedFragment.setArguments(envelope);
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
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