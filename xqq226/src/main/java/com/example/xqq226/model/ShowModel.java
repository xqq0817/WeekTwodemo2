package com.example.xqq226.model;

import com.example.xqq226.entity.ShowBean;
import com.example.xqq226.utils.RetrofitUtils;
import com.example.xqq226.utils.RetrofitUtilsCallback;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ShowModel implements ShowModelCallback{

    @Override
    public void getData(String url, Map<String, String> map, final RetrofitUtilsCallback retrofitUtilsCallback) {

        RetrofitUtils.getInstance().doGet(url,map).setHttpListener(new RetrofitUtils.HttpListener() {
            @Override
            public void success(String result) {
                ShowBean showBean = new Gson().fromJson(result, ShowBean.class);
                retrofitUtilsCallback.success(showBean);
            }

            @Override
            public void failure(String error) {
                retrofitUtilsCallback.failure(error);
            }
        });

       /* RetrofitUtils.getInstance().doGet(url,map).setHttpListener(new RetrofitUtils.HttpListener() {
            //成功
            @Override
            public void success(String result) {
                //gson解析
                ShowBean showBean = new Gson().fromJson(result, ShowBean.class);
                retrofitUtilsCallback.success(showBean);
            }
            //失败
            @Override
            public void failure(String error) {
                retrofitUtilsCallback.failure(error);
            }
        });*/
    }
}
