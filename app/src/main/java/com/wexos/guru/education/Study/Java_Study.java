package com.wexos.guru.education.Study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wexos.guru.education.R;


public class Java_Study extends AppCompatActivity {

    WebView mwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_study);

       // mwebView= (WebView)findViewById(R.id.web_java);
        mwebView.setWebViewClient(new WebViewClient());
        mwebView.loadUrl("https://www.tutorialspoint.com/java/");
    }
}
