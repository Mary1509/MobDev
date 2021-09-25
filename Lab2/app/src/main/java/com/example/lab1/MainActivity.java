package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            plus, minus, divide, multiply, equals, clear;
    TextView textPole;
    String text = "";
    Integer result = 0;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        equals = (Button) findViewById(R.id.equals);
        clear = (Button) findViewById(R.id.clear);
        textPole = (TextView) findViewById(R.id.textPole);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "0";
                textPole.setText(text);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "1";
                textPole.setText(text);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "2";
                textPole.setText(text);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "3";
                textPole.setText(text);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "4";
                textPole.setText(text);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "5";
                textPole.setText(text);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "6";
                textPole.setText(text);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "7";
                textPole.setText(text);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "8";
                textPole.setText(text);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = text + "9";
                textPole.setText(text);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Integer.valueOf((String) textPole.getText());
                text = text + "+";
                textPole.setText(text);
                type = 1;
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Integer.valueOf((String) textPole.getText());
                text = text + "-";
                textPole.setText(text);
                type = 2;
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Integer.valueOf((String) textPole.getText());
                text = text + "/";
                textPole.setText(text);
                type = 3;
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Integer.valueOf((String) textPole.getText());
                text = text + "*";
                textPole.setText(text);
                type = 4;
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int prev = result;
                String newText = (String) textPole.getText();
                String[] parts = newText.split("\\W");
                result = Integer.valueOf(parts[1]);
                switch (type){
                    case 1: {
                        result = prev + result;
                    }
                    case 2: {
                        result = prev - result;
                    }
                    case 3: {
                        if (result == 0){
                            textPole.setText("Division to zero!");
                        }
                        else result = prev / result;
                    }
                    case 4: {
                        result = prev * result;
                    }
                }
                text = (String)result.toString();
                textPole.setText(text);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = "";
                result = 0;
                textPole.setText(R.string.blank);
            }
        });



    }

}