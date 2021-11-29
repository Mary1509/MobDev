package com.example.lab5_2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private LinearLayout mBackgroundLinearLayout;
    private String[] colors = { "BLUE", "CYAN", "DKGRAY",
            "GRAY", "GREEN", "LTGRAY",
            "MAGENTA", "RED", "TRANSPARENT",
            "WHITE", "YELLOW" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBackgroundLinearLayout = findViewById(R.id.linearLayout);
        final Spinner colorSpinner =

                findViewById(R.id.color_spinner);
        ArrayAdapter<String> adapter = new

                ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);
        colorSpinner.setSelection(0);
        colorSpinner
                .setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?>
                                                  arg0, View arg1, int arg2, long arg3) {
                   setBackgroundColor(colorSpinner.
                           getSelectedItem().toString());

               }
               @Override
               public void onNothingSelected

                       (AdapterView<?> arg0) {

               }
           });
    }
    private void setBackgroundColor(String strColor) {
        Toast.makeText(this, strColor, Toast.LENGTH_SHORT).show();
        if (strColor.equalsIgnoreCase("BLACK")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.BLACK);

        } else if (strColor.equalsIgnoreCase("BLUE")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.BLUE);

        } else if (strColor.equalsIgnoreCase("CYAN")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.CYAN);

        } else if (strColor.equalsIgnoreCase("DKGRAY")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.DKGRAY);

        } else if (strColor.equalsIgnoreCase("GRAY")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.GRAY);

        } else if (strColor.equalsIgnoreCase("GREEN")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.GREEN);

        } else if (strColor.equalsIgnoreCase("LTGRAY")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.LTGRAY);

        } else if (strColor.equalsIgnoreCase("MAGENTA")) {
            mBackgroundLinearLayout.setBackgroundColor(Color.MAGENTA);

        } else if (strColor.equalsIgnoreCase("RED")) {
            mBackgroundLinearLayout.setBackgroundColor(Color.RED);
        } else if (strColor.equalsIgnoreCase("TRANSPARENT")) {
            mBackgroundLinearLayout.setBackgroundColor(Color.TRANSPARENT);

        } else if (strColor.equalsIgnoreCase("WHITE")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.WHITE);

        } else if (strColor.equalsIgnoreCase("YELLOW")) {

            mBackgroundLinearLayout.setBackgroundColor(Color.YELLOW);

        }
    }
}
