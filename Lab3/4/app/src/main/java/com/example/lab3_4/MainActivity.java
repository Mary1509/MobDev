package com.example.lab3_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView browser=(WebView)findViewById(R.id.browser);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://www.britannica.com/place/Switzerland");
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


    }