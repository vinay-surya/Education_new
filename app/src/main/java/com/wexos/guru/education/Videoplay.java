package com.wexos.guru.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class Videoplay extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<Youtube> youtubes=new Vector<Youtube>();
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay);
        recyclerView= (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubes.add(new Youtube(" \n" +
                "<iframe width=\"340\" height=\"400\" src=\"https://www.youtube.com/embed/r59xYe3Vyks?list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubes.add(new Youtube("<iframe width=\"340\" height=\"400\" src=\"https://www.youtube.com/embed/gzlhm0jco0g?list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubes.add(new Youtube("<iframe width=\"340\" height=\"400\" src=\"https://www.youtube.com/embed/U8wrZRYAnmI?list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubes.add(new Youtube("<iframe width=\"340\" height=\"400\" src=\"https://www.youtube.com/embed/4ekASokneGU?list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubes.add(new Youtube("<iframe width=\"340\" height=\"400\" src=\"https://www.youtube.com/embed/qgMH6jOOFOE?list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubes.add(new Youtube("<iframe width=\"340\" height=\"400\" src=\"https://www.youtube.com/embed/ss7BtLrbxp4?list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al\" frameborder=\"0\" allowfullscreen></iframe>"));
        Adapter adapter=new Adapter(youtubes);
        recyclerView.setAdapter(adapter);
    }
}
