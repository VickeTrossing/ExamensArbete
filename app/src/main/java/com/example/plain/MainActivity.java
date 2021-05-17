package com.example.plain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent = new Intent();
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateCal(View view) {

        EditText weightInput = findViewById(R.id.weightInput);
        EditText heightInput = findViewById(R.id.heightInput);
        TextView output = findViewById(R.id.textView6);

        double weight = Double.parseDouble(weightInput.getText().toString());
        double height = Double.parseDouble(heightInput.getText().toString()) / 100;

         bmi = weight / (height * height);

        String bmiString = Double.toString(bmi);


        if (output.getText() == "") {
            output.setText(bmiString);
        } else {
            output.setText("");
        }
    }
}


