package com.wexos.guru.education;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class IphoneDevelopment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iphone_development);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.swing_up_left);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.swing_up_right);
        CardView anim= (CardView) findViewById(R.id.anim);
        anim.startAnimation(animation);
        anim.startAnimation(animation1);
    }
}
