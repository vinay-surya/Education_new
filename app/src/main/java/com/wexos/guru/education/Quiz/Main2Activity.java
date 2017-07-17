package com.wexos.guru.education.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wexos.guru.education.R;
import com.wexos.guru.education.model.Asp;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btnJava = (Button) findViewById(R.id.btnJava);
        btnJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conceptIntent = new Intent(Main2Activity.this, ConceptActivity.class);
                startActivity(conceptIntent);

            }
        });

        Button btnSoftware = (Button) findViewById(R.id.btnSoftware);
        btnSoftware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent softwareIntent = new Intent(Main2Activity.this, Software.class);
                startActivity(softwareIntent);
            }
        });

        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Main2Activity.this, Web.class);
                startActivity(webIntent);
            }
        });

        Button btnBig_Data = (Button) findViewById(R.id.btnBig_Data);
        btnBig_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Main2Activity.this, Big_Data.class);
                startActivity(webIntent);
            }
        });

        Button btnSap = (Button) findViewById(R.id.btnSap);
        btnSap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Main2Activity.this, Sap.class);
                startActivity(webIntent);
            }
        });

        Button btnAsp = (Button) findViewById(R.id.btnAsp);
        btnAsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Main2Activity.this, Asp.class);
                startActivity(webIntent);
            }
        });


        Button btnOracle = (Button) findViewById(R.id.btnOracle);
        btnOracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Main2Activity.this, Oracle.class);
                startActivity(webIntent);
            }
        });


        Button btnDataWare = (Button) findViewById(R.id.btnDataWare);
        btnDataWare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Main2Activity.this, Data_WareHouse.class);
                startActivity(webIntent);
            }
        });

        Button btnDevops = (Button) findViewById(R.id.btnDevops);
        btnDevops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Main2Activity.this, Devops.class);
                startActivity(webIntent);
            }
        });

    }


}