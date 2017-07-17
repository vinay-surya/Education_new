package com.wexos.guru.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ourservices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ourservices);

    }
    public void websitedesign(View view){
        Intent intent=new Intent(Ourservices.this,Websitedesign.class);
        startActivity(intent);
    }
}
