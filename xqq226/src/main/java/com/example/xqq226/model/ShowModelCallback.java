package com.example.xqq226.model;

import com.example.xqq226.utils.RetrofitUtilsCallback;

import java.util.HashMap;
import java.util.Map;

public interface ShowModelCallback {
    void getData(String url, Map<String,String> map, RetrofitUtilsCallback retrofitUtilsCallback);
}
