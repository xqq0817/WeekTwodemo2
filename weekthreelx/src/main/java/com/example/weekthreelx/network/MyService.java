package com.example.weekthreelx.network;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface MyService {
    @GET
    Observable<ResponseBody> doGet(@Url String url ,@Header("userId") String userId,@Header("sessionId")String sessionId);
}
