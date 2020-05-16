package com.krunal_shah.glcif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView servingsTV, glycemicIndexTV, carbsTV, glycemicLoadTV;
    Spinner foodSpinner;
    Button submitButton;

    String[] servingsArray;
    String[] glycemicIndexArray;
    String[] carbsArray;
    String[] glycemicLoadArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servingsArray = getResources().getStringArray(R.array.servings);
        glycemicIndexArray = getResources().getStringArray(R.array.glycemicIndex);
        carbsArray = getResources().getStringArray(R.array.carbs);
        glycemicLoadArray = getResources().getStringArray(R.array.glycemicLoad);

        servingsTV = findViewById(R.id.servingsTextView);
        glycemicIndexTV = findViewById(R.id.glycemicIndexTextView);
        carbsTV = findViewById(R.id.carbsTextView);
        glycemicLoadTV = findViewById(R.id.glycemicLoadTextView);
        foodSpinner = findViewById(R.id.foodSpinner);
        submitButton = findViewById(R.id.submitButton);

        foodSpinner.setOnItemSelectedListener(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = foodSpinner.getSelectedItemPosition();

                glycemicLoadTV.setText(glycemicLoadArray[position]);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = foodSpinner.getSelectedItemPosition();

//        Log.d("error", String.valueOf(position));

        servingsTV.setText(servingsArray[position]);
        glycemicIndexTV.setText(glycemicIndexArray[position]);
        carbsTV.setText(carbsArray[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
