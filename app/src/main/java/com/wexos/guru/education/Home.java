package com.wexos.guru.education;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.wexos.guru.education.Interview_Questions.Main2Activity;
import com.wexos.guru.education.Quiz.Main2Activity_Quiz;
import com.wexos.guru.education.Study.MainActivity_Study;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            //
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {
            Intent intent=new Intent(Home.this,Login.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_register) {
            Intent intent=new Intent(Home.this,Register.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.video) {
            Intent intent=new Intent(Home.this,Videoplay.class);
            startActivity(intent);

        } else if (id == R.id.contact) {
            Intent intent=new Intent(Home.this,Contactus.class);
            startActivity(intent);

        } else if (id == R.id.quiz) {
            Intent intent=new Intent(Home.this,Main2Activity_Quiz.class);
            startActivity(intent);

        } else if (id == R.id.interview) {
            Intent intent=new Intent(Home.this,Main2Activity_Quiz.class);
            startActivity(intent);

        } else if (id == R.id.technical) {
            Intent intent=new Intent(Home.this,Main2Activity_Quiz.class);
            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void video(View view){
        Intent intent=new Intent(Home.this,Videoplay.class);
        startActivity(intent);

    }
    public void interview(View view){
        Intent intent =new Intent(Home.this, Main2Activity.class);
        startActivity(intent);

    }

    public void quiz(View view){
        Intent intent=new Intent(Home.this,Main2Activity_Quiz.class);
        startActivity(intent);
    }


    public void training(View view){
        Intent intent =new Intent(Home.this, Training.class);
        startActivity(intent);

    }

    public void study(View view){
        Intent intent=new Intent(Home.this,MainActivity_Study.class);
        startActivity(intent);
    }

    public void contact(View view){
        Intent intent=new Intent(Home.this,Contactus.class);
        startActivity(intent);
    }


    public void sevice(View view){
        Intent intent=new Intent(Home.this,Ourservices.class);
        startActivity(intent);


    }

    public void about_us(View view){
        Intent intent=new Intent(Home.this,About_Us.class);
        startActivity(intent);


    }


}
