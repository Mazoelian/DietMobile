package com.example.utsaplikasidiet;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PencapaianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PencapaianFragment extends Fragment {

    private static final String PREFS_NAME = "DietAppPreferences";
    private static final String TAG = "PencapaianFragment";

    public PencapaianFragment() {
        // Required empty public constructor
    }

    public static PencapaianFragment newInstance() {
        return new PencapaianFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pencapaian, container, false);

        // Initialize SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Initialize CheckBoxes
        CheckBox checkBoxDietWeek1 = view.findViewById(R.id.checkBox_diet_week1);
        CheckBox checkBoxDietWeek2 = view.findViewById(R.id.checkBox_diet_week2);
        CheckBox checkBoxDietWeek3 = view.findViewById(R.id.checkBox_diet_week3);
        CheckBox checkBoxDietWeek4 = view.findViewById(R.id.checkBox_diet_week4);
        CheckBox checkBoxExerciseWeek1 = view.findViewById(R.id.checkBox_exercise_week1);
        CheckBox checkBoxExerciseWeek2 = view.findViewById(R.id.checkBox_exercise_week2);
        CheckBox checkBoxExerciseWeek3 = view.findViewById(R.id.checkBox_exercise_week3);
        CheckBox checkBoxExerciseWeek4 = view.findViewById(R.id.checkBox_exercise_week4);

        // Initialize Button and TextView for result
        Button buttonCalculate = view.findViewById(R.id.button_calculate);
        Button buttonReset = view.findViewById(R.id.button_reset);
        TextView hasilPerhitungan = view.findViewById(R.id.hasilPerhitungan);

        // Load saved state
        checkBoxDietWeek1.setChecked(sharedPreferences.getBoolean("dietWeek1", false));
        checkBoxDietWeek2.setChecked(sharedPreferences.getBoolean("dietWeek2", false));
        checkBoxDietWeek3.setChecked(sharedPreferences.getBoolean("dietWeek3", false));
        checkBoxDietWeek4.setChecked(sharedPreferences.getBoolean("dietWeek4", false));
        checkBoxExerciseWeek1.setChecked(sharedPreferences.getBoolean("exerciseWeek1", false));
        checkBoxExerciseWeek2.setChecked(sharedPreferences.getBoolean("exerciseWeek2", false));
        checkBoxExerciseWeek3.setChecked(sharedPreferences.getBoolean("exerciseWeek3", false));
        checkBoxExerciseWeek4.setChecked(sharedPreferences.getBoolean("exerciseWeek4", false));
        hasilPerhitungan.setText(sharedPreferences.getString("hasil", "0 kkal"));

        // Set OnClickListener for calculate button
        buttonCalculate.setOnClickListener(v -> {
            int totalKalori = 0;

            // Perhitungan untuk diet (kalori)
            if (checkBoxDietWeek1.isChecked()) {
                totalKalori += 500;
                Log.d(TAG, "Diet Week 1 checked, adding 500 kkal");
            }
            if (checkBoxDietWeek2.isChecked()) {
                totalKalori += 700;
                Log.d(TAG, "Diet Week 2 checked, adding 700 kkal");
            }
            if (checkBoxDietWeek3.isChecked()) {
                totalKalori += 900;
                Log.d(TAG, "Diet Week 3 checked, adding 900 kkal");
            }
            if (checkBoxDietWeek4.isChecked()) {
                totalKalori += 1200;
                Log.d(TAG, "Diet Week 4 checked, adding 1200 kkal");
            }

            // Perhitungan untuk olahraga (kalori)
            if (checkBoxExerciseWeek1.isChecked()) {
                totalKalori += 400;
                Log.d(TAG, "Exercise Week 1 checked, adding 400 kkal");
            }
            if (checkBoxExerciseWeek2.isChecked()) {
                totalKalori += 600;
                Log.d(TAG, "Exercise Week 2 checked, adding 600 kkal");
            }
            if (checkBoxExerciseWeek3.isChecked()) {
                totalKalori += 800;
                Log.d(TAG, "Exercise Week 3 checked, adding 800 kkal");
            }
            if (checkBoxExerciseWeek4.isChecked()) {
                totalKalori += 1000;
                Log.d(TAG, "Exercise Week 4 checked, adding 1000 kkal");
            }

            // Tampilkan hasil
            String hasil = totalKalori > 0 ? totalKalori + " kkal" : "0 kkal";
            hasilPerhitungan.setText(hasil);
            Log.d(TAG, "Total Kalori Dibakar: " + totalKalori);

            // Simpan hasil ke SharedPreferences
            editor.putBoolean("dietWeek1", checkBoxDietWeek1.isChecked());
            editor.putBoolean("dietWeek2", checkBoxDietWeek2.isChecked());
            editor.putBoolean("dietWeek3", checkBoxDietWeek3.isChecked());
            editor.putBoolean("dietWeek4", checkBoxDietWeek4.isChecked());
            editor.putBoolean("exerciseWeek1", checkBoxExerciseWeek1.isChecked());
            editor.putBoolean("exerciseWeek2", checkBoxExerciseWeek2.isChecked());
            editor.putBoolean("exerciseWeek3", checkBoxExerciseWeek3.isChecked());
            editor.putBoolean("exerciseWeek4", checkBoxExerciseWeek4.isChecked());
            editor.putString("hasil", hasil);
            editor.apply();
        });

        // Set OnClickListener for reset button
        buttonReset.setOnClickListener(v -> {
            // Reset all CheckBoxes and result
            checkBoxDietWeek1.setChecked(false);
            checkBoxDietWeek2.setChecked(false);
            checkBoxDietWeek3.setChecked(false);
            checkBoxDietWeek4.setChecked(false);
            checkBoxExerciseWeek1.setChecked(false);
            checkBoxExerciseWeek2.setChecked(false);
            checkBoxExerciseWeek3.setChecked(false);
            checkBoxExerciseWeek4.setChecked(false);
            hasilPerhitungan.setText("0 kkal");

            // Clear saved state
            editor.clear().apply();
            Log.d(TAG, "Reset button clicked, all data cleared");
        });

        return view;
    }
}