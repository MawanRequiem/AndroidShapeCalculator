package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class activityOutput extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_output_layout);


        TextView kelilingText = findViewById(R.id.hasil);
        TextView luasText = findViewById(R.id.hasil2);

        double keliling = getIntent().getDoubleExtra("keliling", 0);
        double luas = getIntent().getDoubleExtra("luas", 0);
        String shape = getIntent().getStringExtra("shape");

        kelilingText.setText("Hasil " + "Keliling" + " " + shape + ": " + keliling);
        luasText.setText("Hasil " + "Luas" + " " + shape + ": " + luas);
    }
}
