package com.wexos.guru.education;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.swing_up_left);
        CardView anim= (CardView) findViewById(R.id.wex);
        CardView anim1= (CardView) findViewById(R.id.other);
        anim.startAnimation(animation);
        anim1.startAnimation(animation);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" About Us ");
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.black));




    }


}