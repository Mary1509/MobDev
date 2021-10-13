package com.example.lab3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class SwitzActivity extends AppCompatActivity {
    Button back;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switz);

        openText();
        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());


        back = findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent();
                main.setClass(SwitzActivity.this, MainActivity.class);
                startActivity(main);
            }
        });
    }

    public void openText(){

        TextView textView = findViewById(R.id.textView);
        InputStream fin = null;
        try  {
            fin = getResources().openRawResource(R.raw.switzerland);
            byte[] bytes = new byte[fin.available()];
            int i = fin.read(bytes);
            String text = new String(bytes);
            textView.setText(text);
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                fin.close();
            }
            catch (IOException ex){
                Toast.makeText(this, ex.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}
