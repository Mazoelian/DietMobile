package com.example.utsaplikasidiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BeratActivity extends AppCompatActivity {

    private SeekBar weightSeekBar;
    private TextView currentWeightText;
    private TextView bmiValueText;
    private TextView bmiDescriptionText;

    private static final double HEIGHT = 1.75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berat);

        // Inisialisasi komponen
        weightSeekBar = findViewById(R.id.weightSeekBar);
        currentWeightText = findViewById(R.id.currentWeightText);
        bmiValueText = findViewById(R.id.bmiValueText);
        bmiDescriptionText = findViewById(R.id.bmiDescriptionText);

        // Set nilai awal dari SeekBar dan TextView
        weightSeekBar.setProgress(65); // Nilai awal 65 kg
        currentWeightText.setText("65.0 kg");
        updateBMI(65);

        // Set listener untuk SeekBar
        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update TextView currentWeightText sesuai progress dari SeekBar
                double weight = progress;
                currentWeightText.setText(weight + " kg");

                // Hitung dan update BMI
                updateBMI(weight);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Tidak digunakan
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Tidak digunakan
            }
        });

        // Set tombol lanjut
        Button continueBerat = findViewById(R.id.continueButton);
        continueBerat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeratActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateBMI(double weight) {
        // Hitung nilai BMI
        double bmi = weight / (HEIGHT * HEIGHT);

        // Update tampilan BMI
        bmiValueText.setText(String.format("%.1f", bmi));

        // Tentukan deskripsi BMI berdasarkan nilai BMI
        String bmiDescription;
        if (bmi < 18.5) {
            bmiDescription = "Berat badan Anda di bawah normal.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            bmiDescription = "Anda punya postur yang keren! Pertahankan!";
        } else if (bmi >= 25 && bmi < 29.9) {
            bmiDescription = "Anda sedikit kelebihan berat badan.";
        } else {
            bmiDescription = "Berat badan Anda berlebihan. Cobalah untuk lebih sehat.";
        }

        // Update teks deskripsi BMI
        bmiDescriptionText.setText(bmiDescription);
    }
}
