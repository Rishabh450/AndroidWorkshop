package com.pcon.androidworkshop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebViewer extends AppCompatActivity {

    WebView w;
    String home = "http://www.google.com";
    EditText s;
    Button bt;
    long x ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_viewer);
        // Find the WebView by its unique ID
        w = (WebView) findViewById(R.id.webview);
        s = findViewById(R.id.search_box);
        bt = findViewById(R.id.search_button);
        // loading http://www.google.com url in the the WebView.
        w.loadUrl(home);
        // this will enable the javascipt.
        w.getSettings().setJavaScriptEnabled(true);
        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        w.setWebViewClient(new WebViewClient());
        final String USER_AGENT = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
        w.getSettings().setUserAgentString(USER_AGENT);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s.getText().toString().trim().equals(""))
                    Toast.makeText(WebViewer.this, "Enter URL",Toast.LENGTH_SHORT).show();
                else
                {
                    w.loadUrl(s.getText().toString().trim());
                    // this will enable the javascipt.
                    w.getSettings().setJavaScriptEnabled(true);
                    // WebViewClient allows you to handle
                    // onPageFinished and override Url loading.
                    w.setWebViewClient(new WebViewClient());
                    final String USER_AGENT = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
                    w.getSettings().setUserAgentString(USER_AGENT);

                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LastHomeTime",  "Back to fore");
        Log.d("LastHomeTime",  String.valueOf(x));


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LastHomeTime", "App sent to background");
         x = System.currentTimeMillis();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LastHomeTime", "Data Cleared");
    }
}