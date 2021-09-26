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
    Double result = 0.0;
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
                try {
                    result = Double.parseDouble((String) textPole.getText());
                    text = text + "+";
                    textPole.setText(text);
                    type = 1;
                }
                catch (Exception e){
                    text = "Enter value first!";
                    textPole.setText(text);
                    text = "";
                }

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result = Double.parseDouble((String) textPole.getText());
                    text = text + "-";
                    textPole.setText(text);
                    type = 2;
                }
                catch (Exception e){
                    text = "Enter value first!";
                    textPole.setText(text);
                    text = "";
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result = Double.parseDouble((String) textPole.getText());
                    text = text + "/";
                    textPole.setText(text);
                    type = 3;
                }
                catch (Exception e){
                    text = "Enter value first!";
                    textPole.setText(text);
                    text = "";
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result = Double.parseDouble((String) textPole.getText());
                    text = text + "*";
                    textPole.setText(text);
                    type = 4;
                }
                catch (Exception e){
                    text = "Enter value first!";
                    textPole.setText(text);
                    text = "";
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double prev = result;
                String newText = (String) textPole.getText();
                String[] parts = newText.split("[+/*-]+");
                if (parts.length == 1) {
                    text = (String) parts[0];
                    textPole.setText(text);
                    return;
                }
                try{
                    double secondValue = Double.parseDouble(parts[1]);
                    System.out.println(prev);
                    System.out.println(secondValue);
                    switch (type){
                        case 1: {
                            result = prev + secondValue;
                            break;
                        }
                        case 2: {
                            result = prev - secondValue;
                            break;
                        }
                        case 3: {
                            if (secondValue == 0){
                                textPole.setText("Division to zero!");
                                text = "";
                                return;
                            }
                            else result = prev / secondValue;
                            break;
                        }
                        case 4: {
                            result = prev * secondValue;
                            break;
                        }
                        default: {
                            System.out.println(result);
                            break;
                        }
                    }
                    text = Double.toString(result);
                    textPole.setText(text);
                }
                catch (Exception e) {
                    text = "Bad input";
                    textPole.setText(text);
                    text = "";
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = "";
                result = 0.0;
                textPole.setText(R.string.blank);
            }
        });



    }

}