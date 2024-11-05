package com.example.utsaplikasidiet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GenderActivity extends AppCompatActivity {

    private LinearLayout maleLayout, femaleLayout;
    private boolean isMaleSelected = false;
    private boolean isFemaleSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender);

        maleLayout = findViewById(R.id.male);
        femaleLayout = findViewById(R.id.female);

        maleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMaleSelected) {
                    maleLayout.setBackgroundColor(Color.parseColor("#E0F7FA")); // Warna awal
                    isMaleSelected = false;
                } else {
                    maleLayout.setBackgroundColor(Color.parseColor("#B2EBF2")); // Warna saat dipilih
                    isMaleSelected = true;
                }
            }
        });

        femaleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFemaleSelected) {
                    femaleLayout.setBackgroundColor(Color.parseColor("#E0F7FA")); // Warna awal
                    isFemaleSelected = false;
                } else {
                    femaleLayout.setBackgroundColor(Color.parseColor("#B2EBF2")); // Warna saat dipilih
                    isFemaleSelected = true;
                }
            }
        });

        Button continueGender = findViewById(R.id.continueGender);
        continueGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenderActivity.this, TubuhActivity.class);
                startActivity(intent);
            }
        });



    }


}
