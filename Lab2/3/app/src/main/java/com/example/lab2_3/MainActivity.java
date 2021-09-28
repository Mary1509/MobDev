package com.example.lab2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView result;
    Button submitBtn;
    String selectedOperation;

    private String calculate (Integer num1, Integer num2, String operation) throws Exception {
        switch (operation) {
            case "+":
                return Integer.toString(num1 + num2);
            case "-":
                return Integer.toString(num1 - num2);
            case "/":
                if (num2 != 0) return Integer.toString(num1 / num2);
                else throw new Exception("Division to zero!");
            case "*":
                return Integer.toString(num1 * num2);
            default:
                return "";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.editTextNumber1);
        et2 = (EditText) findViewById(R.id.editTextNumber2);
        result = (TextView) findViewById(R.id.result);


        final Spinner operationSpinner = findViewById(R.id.spinner);
        ArrayAdapter <?> operationAdapter = ArrayAdapter.createFromResource(this,
                R.array.operations,
                android.R.layout.simple_spinner_item);
        operationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operationSpinner.setAdapter(operationAdapter);

        submitBtn.setOnClickListener(view -> {
            selectedOperation = operationSpinner.getSelectedItem().toString();
            Integer num1 = Integer.parseInt(et1.getText().toString());
            Integer num2 = Integer.parseInt(et2.getText().toString());
            try {
                result.setText(calculate(num1, num2, selectedOperation));
            }
            catch (Exception err) {
                Toast.makeText(getApplicationContext(), err.toString() ,
                        Toast.LENGTH_SHORT).show();
            }
        });




    }
}