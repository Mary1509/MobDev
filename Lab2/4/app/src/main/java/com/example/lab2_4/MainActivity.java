package com.example.lab2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner[][] spinners;
    int full = 0;

    private boolean isWinning(Spinner spinner){
        int i = 0, j = 0;
        boolean flag = false;
        if (!spinner.getSelectedItem().toString().equals(" ")){
            while (i < 4 && !flag) {
                if (spinners[i][0].getSelectedItem().toString()
                        .equals(spinners[i][1].getSelectedItem().toString()) &&
                        spinners[i][1].getSelectedItem().toString()
                                .equals(spinners[i][2].getSelectedItem().toString()) &&
                        spinners[i][2].getSelectedItem().toString()
                                .equals(spinners[i][3].getSelectedItem().toString())) {
                    if (!spinners[i][0].getSelectedItem().toString().equals(""))
                    flag = true;
                }
                i++;
            }
            while (j < 4 && !flag) {
                if (spinners[0][j].getSelectedItem().toString()
                        .equals(spinners[1][j].getSelectedItem().toString()) &&
                        spinners[1][j].getSelectedItem().toString()
                                .equals(spinners[2][j].getSelectedItem().toString()) &&
                        spinners[2][j].getSelectedItem().toString()
                                .equals(spinners[3][j].getSelectedItem().toString()) &&
                        !spinners[0][j].getSelectedItem().toString().equals("")) {
                    flag = true;
                }
                j++;
            }
            if (!flag) {
                if (spinners[0][0].getSelectedItem().toString()
                        .equals(spinners[1][1].getSelectedItem().toString()) &&
                        spinners[1][1].getSelectedItem().toString()
                                .equals(spinners[2][2].getSelectedItem().toString()) &&
                        spinners[2][2].getSelectedItem().toString()
                                .equals(spinners[3][3].getSelectedItem().toString()) &&
                        !spinners[0][0].getSelectedItem().toString().equals("")) {
                    flag = true;
                }
            }
            if (!flag) {
                if (spinners[3][0].getSelectedItem().toString()
                        .equals(spinners[2][1].getSelectedItem().toString()) &&
                        spinners[2][1].getSelectedItem().toString()
                                .equals(spinners[1][2].getSelectedItem().toString()) &&
                        spinners[1][2].getSelectedItem().toString()
                                .equals(spinners[0][3].getSelectedItem().toString()) &&
                        !spinners[3][0].getSelectedItem().toString().equals("")) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean isFull(){
        full = 0;
        for (Spinner[] arr : spinners){
            for (Spinner spin : arr){
                if (spin.getSelectedItemPosition() != 0) full ++;
            }
        }
        return full == 16;
    }

    private void restartGame(){
        int i = 0, j;
        while (i < 4){
            j = 0;
            while (j < 4) {
                spinners[i][j].setSelection(0, true);
                j++;
            }
            i++;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinners = new Spinner[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                int id = getResources().getIdentifier(String.format(Locale.UK,"d%s%d", i, j),
                        "id",
                        getPackageName());
                spinners[i][j] = findViewById(id);
                ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
                        R.array.tic_tac,
                        android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinners[i][j].setAdapter(adapter);
                spinners[i][j].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (isWinning((Spinner) adapterView)) {
                            Toast.makeText(getApplicationContext(),
                                    String.format(Locale.UK, "%s won!!!",
                                            adapterView.getSelectedItem().toString()),
                                            Toast.LENGTH_LONG).show();
                            restartGame();
                        }
                        else if (isFull()){
                            Toast.makeText(getApplicationContext(),
                                     "Friendship wins!!!",
                                    Toast.LENGTH_LONG).show();
                            restartGame();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        }



    }
}