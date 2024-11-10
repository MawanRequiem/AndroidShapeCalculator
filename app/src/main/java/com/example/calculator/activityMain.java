package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class activityMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    Button butBasicCalc = findViewById(R.id.basic_calc);
    Button butShapeCalc = findViewById(R.id.shape_calc);

    butBasicCalc.setOnClickListener(v -> goToCalculatorPage("basic"));
butShapeCalc.setOnClickListener(v -> goToCalculatorPage("shape"));

    }

    public void goToCalculatorPage(String tipeCalc){
        if (tipeCalc.equals("basic")){
            Intent intent =new Intent(activityMain.this,activityBasicCalc.class);
            startActivity(intent);
        } else {
            Intent intent =new Intent(activityMain.this,activityShapeCalc.class);
            startActivity(intent);
        }
    }
}
