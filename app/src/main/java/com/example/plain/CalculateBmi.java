package com.example.plain;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CalculateBmi extends AppCompatActivity {

    private Button whatIsBmiButton;
    private TextView bmiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        ConstraintLayout constraintLayout = findViewById(R.id.home_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        whatIsBmiButton = (Button) findViewById(R.id.whatIsBmi);
        //bmiText = (TextView) findViewById(R.id.bmiText);

        whatIsBmiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculateBmi.this, R.style.Theme_AppCompat_DayNight_Dialog);


                builder.setCancelable(true);
                builder.setTitle("What is BMI?");
                builder.setMessage("Body Mass Index (BMI) is a person's weight in kilograms divided by the square of height in meters. " +
                        "A high BMI can be an indicator of high body fatness. BMI can be used to screen for weight categories that may " +
                        "lead to health problems but it is not diagnostic of the body fatness or health of an individual.");

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

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
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