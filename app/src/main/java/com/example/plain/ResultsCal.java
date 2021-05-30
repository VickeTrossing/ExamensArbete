package com.example.plain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsCal extends AppCompatActivity {

    OnCreateCode createCode = new OnCreateCode();
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_cal);


        createCode.onCreateMethod(view, this);

        TextView output = findViewById(R.id.resultsCal);

        String cal = getIntent().getStringExtra("cal");

        output.setText(cal);
    }



    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}