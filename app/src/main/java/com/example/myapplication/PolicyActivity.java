package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PolicyActivity extends AppCompatActivity {

    public WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        webView= (WebView) findViewById(R.id.webv);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://doc-hosting.flycricket.io/my-app-privacy-policy/9000d6fc-2e3a-4bbb-800e-16f3b5c93f87/privacy");

    }
}