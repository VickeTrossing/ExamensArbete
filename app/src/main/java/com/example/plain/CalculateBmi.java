package com.example.plain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateBmi extends AppCompatActivity {

    private Button whatIsBmiButton;
    private TextView bmiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        whatIsBmiButton = (Button) findViewById(R.id.whatIsBmi);
        bmiText = (TextView) findViewById(R.id.bmiText);

        whatIsBmiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculateBmi.this, R.style.Theme_AppCompat_DayNight_Dialog);


                builder.setCancelable(true);
                builder.setTitle("What is BMI?");
                builder.setMessage("Body Mass Index (BMI) is a person's weight in kilograms divided by the square of height in meters. A high BMI can be an indicator of high body fatness. BMI can be used to screen for weight categories that may lead to health problems but it is not diagnostic of the body fatness or health of an individual.");

                builder.setPositiveButton("Got it", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bmiText.setVisibility(View.VISIBLE);
                    }
                });
                builder.show();
            }
        });
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