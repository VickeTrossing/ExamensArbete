package com.example.plain;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CalculateCal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

   // Spinner spinner = findViewById(R.id.activitySpinner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_cal);

        Spinner spinner = findViewById(R.id.activitySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.acticity, R.layout.my_spinner);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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


      @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
      public void calculateCal(View view){
       EditText weightInput = findViewById(R.id.weightInput);
        EditText heightInput = findViewById(R.id.heightInput);
        EditText ageInput = findViewById(R.id.ageInput);
        Spinner spinner = findViewById(R.id.activitySpinner);
        String spinnerActivity = spinner.getSelectedItem().toString();
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        int checkedSex;


        double activityLvl;

        switch (spinnerActivity){
            case "Select":
                TextView errorText = (TextView)spinner.getSelectedView();
                errorText.setTextColor(Color.RED);
                errorText.setText("Pick something else");
                activityLvl = 1.2;
                break;
            case "None to very little":
                activityLvl = 1.2;
                break;
            case "Training 1-3 days/week":
                activityLvl = 1.375;
                break;
            case "Training 4-5 days/week":
                activityLvl = 1.55;
                break;
            case "Training 6-7 days/week":
                activityLvl = 1.725;
                break;
            case "Training 2 times/day, heavy training":
                activityLvl = 1.9;
                break;

            default:
                activityLvl = 0.0;
                break;
        }

        switch(radioButtonId){
            case R.id.radioButtonMan:
                checkedSex = 5;
                break;

            case R.id.radioButtonWoman:
                checkedSex = -166;
                break;

            default: checkedSex = 0; break;
        }

        if(heightInput.getText().toString().equals("")){
            heightInput.setError("Please enter something");
        }else if(weightInput.getText().toString().equals("")){
            weightInput.setError("Please enter something");
        }else if(ageInput.getText().toString().equals("")){
            ageInput.setError("Please enter something");
        }else{

            double weight = Double.parseDouble(weightInput.getText().toString());
            double height = Double.parseDouble(heightInput.getText().toString());
            int age = Integer.parseInt(ageInput.getText().toString());

            double bmr = (9.99 * weight) + (6.25 * height) - (4.92 * age) + checkedSex;
            double totalCal = bmr * activityLvl;
            int calToInt = (int) totalCal;
            String totalString = Double.toString(calToInt);

            Intent intent = new Intent(CalculateCal.this, ResultsCal.class);
            intent.putExtra("cal", totalString);
            startActivity(intent);

        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String  spinnerValue= parent.getItemAtPosition(position).toString();
        Toast t = Toast.makeText(getBaseContext(), "Selected", Toast.LENGTH_SHORT);

        if(spinnerValue.equals("Select")){
            t.cancel();
        }else{
            t.show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}