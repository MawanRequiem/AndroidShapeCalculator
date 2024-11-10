package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class activityShapeCalc extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_calculator_layout);

        Button btnPersegi = findViewById(R.id.buttonPersegi);
        Button btnPersegiPanjang = findViewById(R.id.buttonPersegiPanjang);
        Button btnLingkaran = findViewById(R.id.buttonLingkaran);
        Button btnSegitiga = findViewById(R.id.buttonSegitiga);

        btnPersegi.setOnClickListener(v -> goToShape("persegi"));
        btnPersegiPanjang.setOnClickListener(v -> goToShape("persegiPanjang"));
        btnLingkaran.setOnClickListener(v -> goToShape("lingkaran"));
        btnSegitiga.setOnClickListener(v -> goToShape("segitiga"));

    }

    public void goToShape(String shape){
        Intent intent =new Intent(activityShapeCalc.this,activityShapeInput.class);
        intent.putExtra("shapes", shape);
        startActivity(intent);
    }
}
