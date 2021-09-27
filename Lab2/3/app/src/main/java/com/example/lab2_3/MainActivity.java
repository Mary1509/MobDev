package com.example.lab2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner operationSpinner = findViewById(R.id.spinner);
        ArrayAdapter <?> operationAdapter = ArrayAdapter.createFromResource(this,
                R.array.operations,
                android.R.layout.simple_spinner_item);
        operationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operationSpinner.setAdapter(operationAdapter);

        String selectedOperation = operationSpinner.getSelectedItem().toString();

    }
}