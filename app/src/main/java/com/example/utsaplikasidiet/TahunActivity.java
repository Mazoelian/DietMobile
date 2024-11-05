package com.example.utsaplikasidiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class TahunActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tahun);

        Button continueTahun = findViewById(R.id.continueButton2);
        continueTahun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TahunActivity.this, TinggiActivity.class);
                startActivity(intent);
            }
        });

        NumberPicker numberPickerUmur = findViewById(R.id.numberUmur);
        if (numberPickerUmur != null) {
            numberPickerUmur.setMinValue(1);  // Atur nilai minimum
            numberPickerUmur.setMaxValue(64);  // Atur nilai maksimum
            numberPickerUmur.setValue(20);     // Atur nilai default (opsional)
        }

        NumberPicker numberPicker = findViewById(R.id.numberTahun);
        if (numberPicker != null) {
            numberPicker.setMinValue(1990);  // Atur nilai minimum
            numberPicker.setMaxValue(2024);  // Atur nilai maksimum
            numberPicker.setValue(2002);     // Atur nilai default (opsional)
        }

    }
}
