package com.example.rkao14.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.rkao14.R;
import com.recker.flybanner.FlyBanner;

public class MainActivity extends AppCompatActivity {

    private TextView yl;
    private TextView js;
    private TextView ty;
    private TextView cj;
    private TextView kj;
    private TextView ls;
    private FlyBanner fly;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源ID
        initView();
    }
    //资源ID
    private void initView() {
        yl = (TextView) findViewById(R.id.yl);
        js = (TextView) findViewById(R.id.js);
        ty = (TextView) findViewById(R.id.ty);
        cj = (TextView) findViewById(R.id.cj);
        kj = (TextView) findViewById(R.id.kj);
        ls = (TextView) findViewById(R.id.ls);
        fly = (FlyBanner) findViewById(R.id.fly);
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}
