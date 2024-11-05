package com.example.utsaplikasidiet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge, editTextHeight, editTextWeight, editTextTargetWeight, editTextGender;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "ProfilePrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextTargetWeight = findViewById(R.id.editTextTargetWeight);
        editTextGender = findViewById(R.id.editTextGender);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnReset = findViewById(R.id.btnReset);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Load saved data
        loadSavedData();

        // Set up Save button with if-else check for data validation
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().toString().trim().isEmpty() ||
                        editTextAge.getText().toString().trim().isEmpty() ||
                        editTextHeight.getText().toString().trim().isEmpty() ||
                        editTextWeight.getText().toString().trim().isEmpty() ||
                        editTextTargetWeight.getText().toString().trim().isEmpty() ||
                        editTextGender.getText().toString().trim().isEmpty()) {

                    Toast.makeText(ProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    saveData();
                }
            }
        });

        // Set up Reset button
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });

        // Set up BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_saya);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_resep) {
                    startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_program) {
                    startActivity(new Intent(ProfileActivity.this, ProgramActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.nav_saya) {
                    return true;
                } else if (item.getItemId() == R.id.nav_laporkan) {
                    startActivity(new Intent(ProfileActivity.this, LaporanActivity.class));
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    // Method to load saved data from SharedPreferences
    private void loadSavedData() {
        // Use if-else to check if data exists and load default values if necessary
        String name = sharedPreferences.getString("name", "");
        int age = sharedPreferences.getInt("age", 0);
        int height = sharedPreferences.getInt("height", 0);
        float weight = sharedPreferences.getFloat("weight", 0.0f);
        float targetWeight = sharedPreferences.getFloat("targetWeight", 0.0f);
        String gender = sharedPreferences.getString("gender", "");

        editTextName.setText(!name.isEmpty() ? name : "");
        editTextAge.setText(age != 0 ? String.valueOf(age) : "");
        editTextHeight.setText(height != 0 ? String.valueOf(height) : "");
        editTextWeight.setText(weight != 0.0f ? String.valueOf(weight) : "");
        editTextTargetWeight.setText(targetWeight != 0.0f ? String.valueOf(targetWeight) : "");
        editTextGender.setText(!gender.isEmpty() ? gender : "");
    }

    // Method to save data to SharedPreferences
    private void saveData() {
        String name = editTextName.getText().toString().trim();
        int age = Integer.parseInt(editTextAge.getText().toString().trim());
        int height = Integer.parseInt(editTextHeight.getText().toString().trim());
        float weight = Float.parseFloat(editTextWeight.getText().toString().trim());
        float targetWeight = Float.parseFloat(editTextTargetWeight.getText().toString().trim());
        String gender = editTextGender.getText().toString().trim();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putInt("age", age);
        editor.putInt("height", height);
        editor.putFloat("weight", weight);
        editor.putFloat("targetWeight", targetWeight);
        editor.putString("gender", gender);
        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    // Method to reset fields
    private void resetFields() {
        // Reset each field to an empty state and show a toast
        editTextName.setText("");
        editTextAge.setText("");
        editTextHeight.setText("");
        editTextWeight.setText("");
        editTextTargetWeight.setText("");
        editTextGender.setText("");

        Toast.makeText(this, "Data reset", Toast.LENGTH_SHORT).show();
    }
}
