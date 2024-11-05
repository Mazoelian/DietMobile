package com.example.utsaplikasidiet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MingguActivity4 extends AppCompatActivity {
    private boolean isChecked = false; // Track the state of the button
    private LinearLayout buttonLayout; // Reference to the layout for background change
    private ImageView checkButton; // Reference to the check button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minggu2);

        buttonLayout = findViewById(R.id.btncentang); // Get the layout reference
        checkButton = findViewById(R.id.checkMakanSiang); // Get the button reference

        // Set click listener on the button
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleCheckState();
            }
        });
    }

    // Method to toggle the check state
    private void toggleCheckState() {
        if (isChecked) {
            // If currently checked, uncheck it (reset to default color)
            buttonLayout.setBackgroundColor(Color.WHITE); // Change background back to white
            isChecked = false; // Update the state
        } else {
            // If currently unchecked, check it (set to green)
            buttonLayout.setBackgroundColor(Color.GREEN); // Change background to green
            isChecked = true; // Update the state
        }
    }
}
