package com.example.utsaplikasidiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProgramActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olahraga);

        TextView continueOlahraga = findViewById(R.id.programMinggu1);
        continueOlahraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgramActivity.this, LatihanActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_program);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_resep) {
                    startActivity(new Intent(ProgramActivity.this, HomeActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_program) {
                    startActivity(new Intent(ProgramActivity.this, ProgramActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_saya) {
                    startActivity(new Intent(ProgramActivity.this, ProfileActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_laporkan) {
                    startActivity(new Intent(ProgramActivity.this, LaporanActivity.class));
                    return true;
                }
                return false;
            }
        });
    }
}
