package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class activityShapeInput extends Activity {
    String shape;
    EditText input1, input2;
    TextView labelInput1, labelInput2, labelUtama;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_calculator_input_layout);

        shape = getIntent().getStringExtra("shapes");
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        labelInput1 = findViewById(R.id.labelInput1);
        labelInput2 = findViewById(R.id.labelInput2);
        labelUtama = findViewById(R.id.labelUtama);

        cekShape(shape);

        Button btnHitung = findViewById(R.id.button);
        btnHitung.setOnClickListener(v -> hitung(shape));
    }

    public void cekShape(String shape){
        switch (shape){
            case ("persegi"):
                labelUtama.setText("Hitung Persegi");
                labelInput1.setText("Panjang Sisi (cm)");
                labelInput2.setVisibility(View.INVISIBLE);
                input2.setVisibility(View.INVISIBLE);
                break;
            case ("persegiPanjang"):
                labelUtama.setText("Hitung Persegi Panjang");
                labelInput1.setText("Panjang (cm)");
                labelInput2.setText("Lebar (cm)");
                break;
            case ("segitiga"):
                labelUtama.setText("Hitung Segitiga Sama Sisi");
                labelInput1.setText("Alas (cm)");
                labelInput2.setText("Tinggi (cm)");
                break;
            case ("lingkaran"):
                labelUtama.setText("Hitung Lingkaran");
                labelInput1.setText("Panjang Radius (cm)");
                labelInput2.setVisibility(View.INVISIBLE);
                input2.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void hitung(String shape){
        double val1 = Double.parseDouble(input1.getText().toString());
        double val2 = input2.getVisibility() == View.VISIBLE ? Double.parseDouble(input2.getText().toString()):0;
        double keliling = 0;
        double luas = 0;

        switch (shape){
            case ("persegi"):
                keliling = 4 * val1;
                luas = val1 * val1;
                break;
            case ("persegiPanjang"):
                keliling = 2 * (val1 + val2);
                luas = val1 * val2;
                break;
            case ("segitiga"):
                keliling = 3 * val1;
                luas = 0.5 * val1 * val2;
                break;
            case ("lingkaran"):
                keliling = 2 * Math.PI * val1;
                luas = Math.PI * Math.pow(val1, 2);
                break;
        }

        Intent intent = new Intent(activityShapeInput.this, activityOutput.class);
        intent.putExtra("keliling", keliling);
        intent.putExtra("luas", luas);
        intent.putExtra("shape", shape);
        startActivity(intent);
    }
}
