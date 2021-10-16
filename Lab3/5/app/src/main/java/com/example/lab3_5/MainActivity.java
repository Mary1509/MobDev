package com.example.lab3_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Button search, prev, next;
    EditText editText;
    WebView browser;
    LinkedList<String> history;

    String searchUrl;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser=(WebView)findViewById(R.id.browser);
        browser.setWebViewClient(new WebViewClient());
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);

        search = (Button)findViewById(R.id.search_btn);
        prev = (Button)findViewById(R.id.prev_btn);
        next = (Button)findViewById(R.id.next_btn);
        editText = (EditText)findViewById(R.id.editText);

        history = new LinkedList<>();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchUrl = editText.getText().toString();
                history.addFirst(searchUrl);
                browser.loadUrl(searchUrl);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = history.indexOf(searchUrl);
                if (pos == history.size()-1) {
                    Toast.makeText(getApplicationContext(),
                            "You are viewing the first page!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    String prevText = history.get(pos+1);
                    browser.loadUrl(prevText);
                    searchUrl = prevText;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = history.indexOf(searchUrl);
                if (pos <= 0 ) {
                    Toast.makeText(getApplicationContext(),
                            "You are viewing the latest page!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    String nextText = history.get(pos-1);
                    browser.loadUrl(nextText);
                    searchUrl = nextText;
                }
            }
        });



    }

    @Override
    protected void onDestroy() {

        history.remove();
        super.onDestroy();
    }
}