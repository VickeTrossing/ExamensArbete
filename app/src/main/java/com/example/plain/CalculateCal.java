package com.example.plain;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateCal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

   // Spinner spinner = findViewById(R.id.activitySpinner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_cal);

        Spinner spinner = findViewById(R.id.activitySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.acticity, R.layout.my_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


      public void calculateCal(View view){
       EditText weightInput = findViewById(R.id.weightInput);
        EditText heightInput = findViewById(R.id.heightInput);
        EditText ageInput = findViewById(R.id.ageInput);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner spinner = findViewById(R.id.activitySpinner);
        String spinnerActivity = spinner.getSelectedItem().toString();

        double activityLvl;

        switch (spinnerActivity){
            case "Select":
                TextView errorText = (TextView)spinner.getSelectedView();
                errorText.setTextColor(Color.RED);
                errorText.setText("Pick something else");
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
            case "Training 5-7 days/week":
                activityLvl = 1.725;
                break;
            case "Training 2 times/day, heavy training":
                activityLvl = 1.9;
                break;
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