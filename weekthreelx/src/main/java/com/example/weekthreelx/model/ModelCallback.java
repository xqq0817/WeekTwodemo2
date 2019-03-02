package com.example.weekthreelx.model;

import com.example.weekthreelx.utils.RetrofitCallback;

import java.util.HashMap;

public interface ModelCallback {
     void getData(String mpath,int type,String userId,String sessionId, RetrofitCallback retrofitCallback);
}
