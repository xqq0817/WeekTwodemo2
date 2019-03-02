package com.example.weekthreelx.model;

import com.example.weekthreelx.entity.ShowBean;
import com.example.weekthreelx.utils.RetrofitCallback;
import com.example.weekthreelx.utils.RetrofitUtils;
import com.google.gson.Gson;

import java.util.HashMap;

public class Model implements ModelCallback{
    @Override
    public void getData(String mpath,int type,String userId,String sessionId, RetrofitCallback retrofitCallback) {
            switch (type){
                case 1:
                    getShow(mpath,userId,sessionId,retrofitCallback);
                    break;
            }
    }

    private void getShow(String mpath, String userId, String sessionId, final RetrofitCallback retrofitCallback) {
        RetrofitUtils.getInstance().doGet(mpath,userId,sessionId).setHttpListener(new RetrofitUtils.HttpListener() {
            @Override
            public void success(String result) {
                ShowBean showBean = new Gson().fromJson(result, ShowBean.class);
                retrofitCallback.success(showBean);
            }

            @Override
            public void failure(String error) {
                retrofitCallback.failure(error);
            }
        });
    }

}
