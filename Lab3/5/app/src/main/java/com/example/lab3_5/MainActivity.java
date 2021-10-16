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
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    Button search, prev, next;
    EditText editText;
    WebView browser;
    LinkedList<String> history;

    String searchUrl;
    int pos;
    ListIterator<String> iterator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser= findViewById(R.id.browser);
        browser.setWebViewClient(new WebViewClient());
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);

        search = findViewById(R.id.search_btn);
        prev = findViewById(R.id.prev_btn);
        next = findViewById(R.id.next_btn);
        editText = findViewById(R.id.editText);

        history = new LinkedList<>();
        iterator = history.listIterator();

        search.setOnClickListener(v -> {
            searchUrl = editText.getText().toString();
            if (!searchUrl.contains("https://")){
                searchUrl = "https://www.google.com/search?q="+searchUrl;
            }
            history.addFirst(searchUrl);
            browser.loadUrl(searchUrl);
            pos = 0;
            iterator = history.listIterator(0);

        });

        prev.setOnClickListener(v -> {
            if (iterator.hasNext()){
                String prevText = iterator.next();
                browser.loadUrl(prevText);
                searchUrl = prevText;
            }
            else {
                Toast.makeText(getApplicationContext(),
                        "You are viewing the first page!",
                        Toast.LENGTH_LONG).show();
            }
//                if (pos != 0)
//                    pos = history.indexOf(searchUrl);
//                if (pos == history.size()-1) {
//                    Toast.makeText(getApplicationContext(),
//                            "You are viewing the first page!",
//                            Toast.LENGTH_LONG).show();
//                }
//                else {
//                    String prevText = history.get(pos+1);
//                    browser.loadUrl(prevText);
//                    searchUrl = prevText;
//                }
        });

        next.setOnClickListener(v -> {
            if (iterator.hasPrevious()){
                String nextText = iterator.previous();
                browser.loadUrl(nextText);
                searchUrl = nextText;
            }
            else {
                Toast.makeText(getApplicationContext(),
                        "You are viewing the last page!",
                        Toast.LENGTH_LONG).show();
            }
//                if (pos != 0)
//                    pos = history.indexOf(searchUrl);
//                if (pos <= 0 ) {
//                    Toast.makeText(getApplicationContext(),
//                            "You are viewing the latest page!",
//                            Toast.LENGTH_LONG).show();
//                }
//                else {
//                    String nextText = history.get(pos-1);
//                    browser.loadUrl(nextText);
//                    searchUrl = nextText;
//                }
        });



    }

    @Override
    protected void onDestroy() {

        history.remove();
        super.onDestroy();
    }
}