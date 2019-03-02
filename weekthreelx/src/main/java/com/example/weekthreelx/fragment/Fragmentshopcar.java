package com.example.weekthreelx.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.weekthreelx.R;
import com.example.weekthreelx.adapter.ShowCarAdapter;
import com.example.weekthreelx.api.Api;
import com.example.weekthreelx.entity.ShowBean;
import com.example.weekthreelx.presenter.Presenter;
import com.example.weekthreelx.view.DataView;

import java.util.HashMap;

public class Fragmentshopcar<T> extends Fragment implements DataView<T> {
    private RecyclerView rv;
    private CheckBox checkbox;
    private Button js;
    private Presenter presenter;
    private ShowCarAdapter showCarAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentshopcar, container, false);
        initView(view);
        /**
         * p层
         */
        presenter = new Presenter(this);
        HashMap<String,String> map=new HashMap<>();
        map.put("page","1");
        map.put("count","5");
        presenter.setData(Api.BASE_CAR,1,"752","1551496448059752");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void success(T data) {
        if (data instanceof ShowBean){
            ShowBean showBean=(ShowBean) data;
            showCarAdapter = new ShowCarAdapter(getActivity(), showBean.getResult());
            rv.setAdapter(showCarAdapter);
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        }
    }

    @Override
    public void failure(T error) {

    }

    private void initView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.rv);
        checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        js = (Button) view.findViewById(R.id.js);
    }
}
