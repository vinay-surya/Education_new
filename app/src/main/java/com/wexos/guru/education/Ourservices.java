package com.wexos.guru.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

public class Ourservices extends AppCompatActivity {
    Animation animFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ourservices);

    }
    public void websitedesign(View view){
        Intent intent=new Intent(Ourservices.this,Websitedesign.class);
        startActivity(intent);
    }
    public void website(View view){

        Intent intent=new Intent(Ourservices.this,WebDevelopment.class);
        startActivity(intent);
    }
    public void android(View view){
        Intent intent=new Intent(Ourservices.this,AndroidDevelopment.class);
        startActivity(intent);
    }
    public void iphone(View view){
        Intent intent=new Intent(Ourservices.this,IphoneDevelopment.class);
        startActivity(intent);
    }
    public void informatica(View view){
        Intent intent=new Intent(Ourservices.this,Informatica.class);
        startActivity(intent);
    }

    public void testing(View view){
        Intent intent=new Intent(Ourservices.this,Test.class);
        startActivity(intent);
    }
}


