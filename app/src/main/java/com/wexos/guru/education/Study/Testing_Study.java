package com.wexos.guru.education.Study;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wexos.guru.education.R;


public class Testing_Study extends AppCompatActivity {

    WebView mwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing__study);

        mwebView= (WebView)findViewById(R.id.web_testing);
        mwebView.setWebViewClient(new WebViewClient());
        mwebView.loadUrl("https://www.tutorialspoint.com/software_testing/");
    }
}
