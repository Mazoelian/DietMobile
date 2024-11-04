package com.example.utsaplikasidiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class TinggiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tinggi);

        Button continueTinggi = findViewById(R.id.continueTinggi);
        continueTinggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TinggiActivity.this, BeratActivity.class);
                startActivity(intent);
            }
        });

        // Menambahkan konfigurasi untuk NumberPicker
        NumberPicker numberPicker = findViewById(R.id.numberTinggi);
        if (numberPicker != null) {
            numberPicker.setMinValue(100);  // Atur nilai minimum
            numberPicker.setMaxValue(250);  // Atur nilai maksimum
            numberPicker.setValue(171);     // Atur nilai default (opsional)
        }
    }
}
