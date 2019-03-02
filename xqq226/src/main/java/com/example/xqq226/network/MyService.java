package com.example.xqq226.network;


import java.util.HashMap;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;


public interface MyService {
    @GET
    Observable<ResponseBody> doGet(@Url String url, @QueryMap Map<String,String> map);
}
