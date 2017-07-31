package com.wexos.guru.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Training extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.swing_up_left);
        CardView anim= (CardView) findViewById(R.id.javaanim);
        CardView anim1= (CardView) findViewById(R.id.stesting);
        CardView anim2= (CardView) findViewById(R.id.webtech);
        CardView anim3= (CardView) findViewById(R.id.bigd);
        CardView anim4= (CardView) findViewById(R.id.sapp);
        CardView anim5= (CardView) findViewById(R.id.microsft);
        CardView anim6= (CardView) findViewById(R.id.ora);
        CardView anim7= (CardView) findViewById(R.id.dw);
        anim.startAnimation(animation);
        anim1.startAnimation(animation);
        anim2.startAnimation(animation);
        anim3.startAnimation(animation);
        anim4.startAnimation(animation);
        anim5.startAnimation(animation);
        anim6.startAnimation(animation);
        anim7.startAnimation(animation);

    }
}
