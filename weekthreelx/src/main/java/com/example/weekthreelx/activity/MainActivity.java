package com.example.weekthreelx.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.weekthreelx.R;
import com.example.weekthreelx.adapter.ShowCarAdapter;
import com.example.weekthreelx.api.Api;
import com.example.weekthreelx.entity.ShowBean;
import com.example.weekthreelx.presenter.Presenter;
import com.example.weekthreelx.view.DataView;

import java.util.HashMap;

public class MainActivity<T> extends AppCompatActivity implements DataView<T> {

    private RecyclerView rv;
    private CheckBox checkbox;
    private Button js;
    private Presenter presenter;
    private ShowCarAdapter showCarAdapter;
    private ShowBean showBean;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源ID
        initView();
        //数据
        initData();

    }
    //数据
    private void initData() {
        /**
         * p层
         */
        presenter = new Presenter(this);
        HashMap<String,String> map=new HashMap<>();
        map.put("page","1");
        map.put("count","5");
        presenter.setData(Api.BASE_CAR,1,"752","1551496448059752");
    }

    //资源ID
    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        checkbox = (CheckBox) findViewById(R.id.checkbox);
        price = findViewById(R.id.price);
        js = (Button) findViewById(R.id.js);
        //点击事件
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkbox.isChecked()){
                    for (ShowBean.ResultBean resultBean : showBean.getResult()) {
                        resultBean.isIschecked=true;
                    }
                }else{
                    for (ShowBean.ResultBean resultBean : showBean.getResult()) {
                        resultBean.isIschecked=false;
                    }
                }
                showCarAdapter.notifyDataSetChanged();
                getTotalprice();
            }
        });
    }

    private void getTotalprice() {
        int totaoprice=0;
        for (ShowBean.ResultBean resultBean : showBean.getResult()) {
                if (resultBean.isIschecked){
                    totaoprice+=resultBean.getPrice();//全选总价
                }
        }
        price.setText("合计:￥"+totaoprice);
    }

    //成功
    @Override
    public void success(T data) {
        if (data instanceof ShowBean){
            showBean = (ShowBean) data;
            showCarAdapter = new ShowCarAdapter(this, showBean.getResult());
            rv.setAdapter(showCarAdapter);
            rv.setLayoutManager(new LinearLayoutManager(this));

        }
    }
    //失败
    @Override
    public void failure(T error) {

    }
}
