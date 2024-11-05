package com.example.utsaplikasidiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        TextView continueTahun = findViewById(R.id.btnMinggu1);
        TextView continueTahun2 = findViewById(R.id.btnMinggu2);
        TextView continueTahun3 = findViewById(R.id.btnMinggu3);
        TextView continueTahun4 = findViewById(R.id.btnMinggu4);

        continueTahun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MingguActivity.class);
                startActivity(intent);
            }
        });

        continueTahun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MingguActivity2.class);
                startActivity(intent);
            }
        });

        continueTahun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MingguActivity3.class);
                startActivity(intent);
            }
        });

        continueTahun4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MingguActivity4.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_resep);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_resep) {
                    startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_program) {
                    startActivity(new Intent(HomeActivity.this, ProgramActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_saya) {
                    startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_laporkan) {
                    startActivity(new Intent(HomeActivity.this, LaporanActivity.class));
                    return true;
                }
                return false;
            }
        });
    }
}
