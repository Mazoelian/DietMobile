package com.example.utsaplikasidiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LaporanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporan);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, PencapaianFragment.newInstance())
                    .commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_laporkan);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_resep) {
                    startActivity(new Intent(LaporanActivity.this, HomeActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_program) {
                    startActivity(new Intent(LaporanActivity.this, ProgramActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_saya) {
                    startActivity(new Intent(LaporanActivity.this, ProfileActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_laporkan) {
                    startActivity(new Intent(LaporanActivity.this, LaporanActivity.class));
                    return true;
                }
                return false;
            }
        });

    }
}
