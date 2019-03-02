package com.example.xqq226.presenter;

import com.example.xqq226.utils.RetrofitUtilsCallback;

import java.util.HashMap;
import java.util.Map;

public interface ShowPresenterCallback {
    void getData(String url, Map<String,String> map);
}
