package com.wexos.guru.education.Interview_Questions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.wexos.guru.education.R;

public class Main2Activity extends AppCompatActivity {

    CardView
            cardView_java,
            cardView_testing,
            cardView_web_technology,
            cardView_dot_net,
            cardViewbig_data,
            cardView_sap,
            cardView_oracle,
            cardView_data_warehouse,
            cardView_java_script;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_interview);


        cardView_java = (CardView)findViewById(R.id.cardview_java);
        cardView_testing = (CardView)findViewById(R.id.cardview_testing);
        cardView_web_technology = (CardView)findViewById(R.id.cardview_web_technology);
        cardView_dot_net = (CardView)findViewById(R.id.cardview_dot_net);
        cardViewbig_data = (CardView)findViewById(R.id.cardview_big_data);
        cardView_sap = (CardView)findViewById(R.id.cardview_sap);
        cardView_oracle = (CardView)findViewById(R.id.cardview_oracle);
        cardView_data_warehouse = (CardView)findViewById(R.id.cardview_data_warehouse);
        cardView_java_script = (CardView)findViewById(R.id.cardview_java_script);

        cardView_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cardView_testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Testing_Interview.class);
                startActivity(intent);
            }
        });

        cardView_web_technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Web_Technology_Interview.class);
                startActivity(intent);
            }
        });


        cardView_dot_net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Dot_net_Interview.class);
                startActivity(intent);
            }
        });

        cardViewbig_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Big_Data_Interview.class);
                startActivity(intent);
            }
        });

        cardView_sap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Sap_Interview.class);
                startActivity(intent);
            }
        });

        cardView_oracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Oracle_Interview.class);
                startActivity(intent);
            }
        });

        cardView_data_warehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Data_warehouse_Interview.class);
                startActivity(intent);
            }
        });

        cardView_java_script.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Java_Script_Interview.class);
                startActivity(intent);
            }
        });

    }
}
