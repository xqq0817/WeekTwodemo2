package com.example.rkao14.network;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface MyService {
    @GET
    Observable<ResponseBody> doGet(@Url String url, @QueryMap HashMap<String,String> map);
}
