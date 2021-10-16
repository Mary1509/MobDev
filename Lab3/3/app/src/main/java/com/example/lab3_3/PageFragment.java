package com.example.lab3_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;

public class PageFragment extends Fragment {
    private int pageNumber;
    String[] countries;


    public PageFragment(){}

    public static PageFragment newFragment(int page){
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        if (getArguments() != null){
            pageNumber = getArguments().getInt("num");
        }
        else pageNumber = 1;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View result = inflater.inflate(R.layout.fragment_page, container, false);
        countries = getResources().getStringArray(R.array.countries);
        TextView textView = (TextView) result.findViewById(R.id.textView);
        ImageView imageView = (ImageView) result.findViewById(R.id.imageView);
        switch (pageNumber){
            case 0: {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.flag_of_germany));
                openText(result, R.raw.germany);
            }
            case 1: {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.flag_of_italy));
                openText(result, R.raw.italy);
            }
            case 2: {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.flag_of_switzerland));
                openText(result, R.raw.switzerland);
            }
        }

        return result;
    }

    public void openText(View view, int resource){

        TextView textView = view.findViewById(R.id.textView);
        InputStream fin = null;
        try  {
            fin = getResources().openRawResource(resource);
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
