package com.example.plain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateCal(View view) {

        EditText weightInput = findViewById(R.id.weightInput);
        EditText heightInput = findViewById(R.id.heightInput);

        double weight = Double.parseDouble(weightInput.getText().toString());
        double height = Double.parseDouble(heightInput.getText().toString()) / 100;

        double bmi = weight / (height * height);

        String bmiString = Double.toString(bmi);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("bmi", bmiString);
        startActivity(intent);
    }
}


