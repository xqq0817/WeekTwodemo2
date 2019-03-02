package com.example.xqq226.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xqq226.R;
import com.example.xqq226.adapter.ShowAdapter;
import com.example.xqq226.api.API;
import com.example.xqq226.entity.ShowBean;
import com.example.xqq226.presenter.ShowPresenter;
import com.example.xqq226.view.ShowView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity<T> extends AppCompatActivity implements ShowView<T> {

    private ImageView back;
    private TextView dy;
    private ImageView cai;
    private RecyclerView rv;
    private ShowPresenter showPresenter;
    private ShowAdapter showAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源ID
        initView();
        /**
         * p层
         */
        showPresenter = new ShowPresenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("page","1");
        map.put("count","10");
        showPresenter.getData(API.USER_MOVIE,map);

    }
    //成功
    @Override
    public void success(T result) {
        if (result instanceof ShowBean){
            ShowBean showBean=(ShowBean) result;
            showAdapter = new ShowAdapter(this, showBean.getResult());
            rv.setAdapter(showAdapter);
            rv.setLayoutManager(new GridLayoutManager(this,2));
        }
    }
    //失败
    @Override
    public void failure(T error) {

    }
    //资源ID
    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        dy = (TextView) findViewById(R.id.dy);
        cai = (ImageView) findViewById(R.id.cai);
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}
