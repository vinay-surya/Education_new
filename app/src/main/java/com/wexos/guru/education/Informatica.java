package com.wexos.guru.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Informatica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatica);
        //1452214444
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.swing_up_left);
        CardView anim= (CardView) findViewById(R.id.information);
        anim.startAnimation(animation);
    }
}

