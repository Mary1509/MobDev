package com.example.lab3_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager=(ViewPager2)findViewById(R.id.pager);
        FragmentStateAdapter pageAdapter = new PageAdapter(this);
        pager.setAdapter(pageAdapter);

    }
}