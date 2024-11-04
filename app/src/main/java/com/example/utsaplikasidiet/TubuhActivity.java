package com.example.utsaplikasidiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TubuhActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tubuh);

        Button continueTahun = findViewById(R.id.continueButton);
        continueTahun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TubuhActivity.this, TahunActivity.class);
                startActivity(intent);
            }
        });

    }
}
