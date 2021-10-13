package com.example.lab3_2;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;

public class GerActivity extends Fragment {

    public GerActivity(){
        super(R.layout.fragment_germany);
    }

    Button back;
    TextView textView;
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        openText();
        textView = getView().findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

//        back = findViewById(R.id.button);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent main = new Intent();
//                main.setClass(GerActivity.this, MainActivity.class);
//                startActivity(main);
//            }
//        });
    }
    public void openText(){

        textView = getView().findViewById(R.id.textView);
        InputStream fin = null;
        try  {
            fin = getActivity().getResources().openRawResource(R.raw.germany);
            byte[] bytes = new byte[fin.available()];
            int i = fin.read(bytes);
            String text = new String(bytes);
            textView.setText(text);
        } catch (IOException ex) {
//            Toast.makeText(this, ex.getMessage(),
//                    Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                fin.close();
            }
            catch (IOException ex){
//                Toast.makeText(this, ex.getMessage(),
//                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}
