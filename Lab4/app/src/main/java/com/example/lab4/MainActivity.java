package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);

        btn1.setOnClickListener(createOnClickListener());
        btn2.setOnClickListener(createOnClickListener());
        btn3.setOnClickListener(createOnClickListener());
        btn4.setOnClickListener(createOnClickListener());
        btn5.setOnClickListener(createOnClickListener());
        btn6.setOnClickListener(createOnClickListener());



    }

    public View.OnClickListener createOnClickListener(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent();
                switch (v.getId()){
                    case (R.id.button1) : {
                        in1.setClass(MainActivity.this, Task1.class);
                        startActivity(in1);
                    }
                    case (R.id.button2) :
                        // TODO render Activity 2
                    case (R.id.button3) :
                        // TODO render Activity 3
                    case (R.id.button4) :
                        // TODO render Activity 4
                    case (R.id.button5) :
                        // TODO render Activity 5
                    case (R.id.button6) :
                        // TODO render Activity 6
                }
            }
        };
        return  onClickListener;
    }


}