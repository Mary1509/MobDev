package com.example.lab2;

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

    public View.OnClickListener createOnClickListenerNumber() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn0:{
                        text = text + "0";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn1:{
                        text = text + "1";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn2:{
                        text = text + "2";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn3: {
                        text = text + "3";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn4: {
                        text = text + "4";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn5: {
                        text = text + "5";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn6:{
                        text = text + "6";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn7: {
                        text = text + "7";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn8: {
                        text = text + "8";
                        textPole.setText(text);
                        break;
                    }
                    case R.id.btn9: {
                        text = text + "9";
                        textPole.setText(text);
                        break;
                    }

                }
            }
        };
        return onClickListener;
    }
    public View.OnClickListener createOnClickListenerAction() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result = Double.parseDouble((String) textPole.getText());
                    switch (view.getId()) {
                        case R.id.plus: {
                            text = text + "+";
                            textPole.setText(text);
                            type = 1;
                            break;
                        }
                        case R.id.minus: {
                            text = text + "-";
                            textPole.setText(text);
                            type = 2;
                            break;
                        }
                        case R.id.divide: {
                            text = text + "/";
                            textPole.setText(text);
                            type = 3;
                            break;
                        }
                        case R.id.multiply: {
                            text = text + "*";
                            textPole.setText(text);
                            type = 4;
                            break;
                        }
                    }
                }
                catch (Exception e){
                    text = "Enter value first!";
                    textPole.setText(text);
                    text = "";
                }
            }
        };
        return onClickListener;
    }

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

        View.OnClickListener onClickListenerNumber = createOnClickListenerNumber();
        View.OnClickListener onClickListenerAction = createOnClickListenerAction();

        btn0.setOnClickListener(onClickListenerNumber);
        btn1.setOnClickListener(onClickListenerNumber);
        btn2.setOnClickListener(onClickListenerNumber);
        btn3.setOnClickListener(onClickListenerNumber);
        btn4.setOnClickListener(onClickListenerNumber);
        btn5.setOnClickListener(onClickListenerNumber);
        btn6.setOnClickListener(onClickListenerNumber);
        btn7.setOnClickListener(onClickListenerNumber);
        btn8.setOnClickListener(onClickListenerNumber);
        btn9.setOnClickListener(onClickListenerNumber);

        plus.setOnClickListener(onClickListenerAction);
        minus.setOnClickListener(onClickListenerAction);
        divide.setOnClickListener(onClickListenerAction);
        multiply.setOnClickListener(onClickListenerAction);
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