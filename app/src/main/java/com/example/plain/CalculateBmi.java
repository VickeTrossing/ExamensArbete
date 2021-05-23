package com.example.plain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateBmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
    }

    public void calculateCal(View view) {

        EditText weightInput = findViewById(R.id.weightInput);
        EditText heightInput = findViewById(R.id.heightInput);



        if(weightInput.getText().toString().equals("")){
            weightInput.setError("That's not your weight");

        }else if(heightInput.getText().toString().equals("")){
            heightInput.setError("That's not your height");
        }
        else{

            double weight = Double.parseDouble(weightInput.getText().toString());
            double height = Double.parseDouble(heightInput.getText().toString()) / 100;

            double bmi = weight / (height * height);
            int bmiToInt = (int) bmi;
            String bmiString = Integer.toString(bmiToInt);

            Intent intent = new Intent(CalculateBmi.this, MainActivity2.class);
            intent.putExtra("bmi", bmiString);
            startActivity(intent);
        }


    }
}