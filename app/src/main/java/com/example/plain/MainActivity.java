package com.example.plain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    OnCreateCode createCode = new OnCreateCode();
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCode.onCreateMethod(view, this);

    }

    public void goToBMI(View view){
        Intent intent = new Intent(this, CalculateBmi.class);
        startActivity(intent);
    }

    public void goToCal(View view){
        Intent intent = new Intent(this, CalculateCal.class);
        startActivity(intent);
    }

    public void goToActivity(View view){
        Intent intent = new Intent(this, CalculateCal.class);
        startActivity(intent);
    }
}