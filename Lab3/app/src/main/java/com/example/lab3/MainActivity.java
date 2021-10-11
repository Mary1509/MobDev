package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent();
                in1.setClass(MainActivity.this, GerActivity.class);
                startActivity(in1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent();
                in2.setClass(MainActivity.this, SwitzActivity.class);
                startActivity(in2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3 = new Intent();
                in3.setClass(MainActivity.this, ItActivity.class);
                startActivity(in3);
            }
        });

    }
}