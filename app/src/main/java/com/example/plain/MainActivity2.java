package com.example.plain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    OnCreateCode createCode = new OnCreateCode();
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        createCode.onCreateMethod(view, this);

        TextView output = findViewById(R.id.textView4);

        String bmi = getIntent().getStringExtra("bmi");

        output.setText(bmi);

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        double bmiDouble = Double.parseDouble(bmi);
        TextView bmiResults = findViewById(R.id.textView17);

        if(bmiDouble < 19.0){
            bmiResults.setText("You are underweight");
        }else if(bmiDouble < 25.0){
            bmiResults.setText("You are in the good zone my dude");
        }else if(bmiDouble < 30.0){
            bmiResults.setText("You are a bit overweight");
        }else if(bmiDouble < 40.0){
            bmiResults.setText("You are obese, do something about it");
        }else if(bmiDouble >= 40.0){
            bmiResults.setText("You gon die soon bro");
        }

    }



    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}


