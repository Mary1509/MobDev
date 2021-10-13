package com.example.lab3_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class ItActivity extends Fragment {

    public ItActivity(){
        super(R.layout.fragment_italy);
    }

    Button back;
    TextView textView;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        openText(view);
        textView = view.findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public void openText(View view){

        TextView textView = view.findViewById(R.id.textView);
        InputStream fin = null;
        try  {
            fin = getResources().openRawResource(R.raw.italy);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            textView.setText(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                fin.close();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
}
