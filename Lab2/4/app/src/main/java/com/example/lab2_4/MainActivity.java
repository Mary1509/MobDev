package com.example.lab2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner[][] spinnerArray = new Spinner[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                int id = getResources().getIdentifier(String.format("d%s%d", i, j),
                        "id",
                        getPackageName());
                spinnerArray[i][j] = findViewById(id);

            }
        }

    }
}