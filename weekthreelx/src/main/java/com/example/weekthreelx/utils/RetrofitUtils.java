package com.example.weekthreelx.utils;

import com.example.weekthreelx.api.Api;
import com.example.weekthreelx.network.MyService;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtils {

    private MyService myService;

    private RetrofitUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASE_USER)
                .client(okHttpClient)
                .build();
        myService = retrofit.create(MyService.class);
    }

    public static RetrofitUtils getInstance() {
        return RetrofitHolder.UTIL;
    }

    private static class RetrofitHolder{
        private static final RetrofitUtils UTIL=new RetrofitUtils();
    }

    public RetrofitUtils doGet(String url,String userId,String sessionId){
        myService.doGet(url,userId,sessionId).subscribeOn(Schedulers.io())
                                                  .observeOn(AndroidSchedulers.mainThread())
                                                  .subscribe(observer);
                return RetrofitUtils.getInstance();
    }
    private Observer observer= new Observer<ResponseBody>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if (httpListener!=null){
                httpListener.failure(e.getMessage());
            }
        }

        @Override
        public void onNext(ResponseBody responseBody) {
            if (httpListener!=null){
                try {
                    httpListener.success(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public interface HttpListener{
        void success(String result);
        void failure(String error);
    }
    private HttpListener httpListener;
    public void setHttpListener(HttpListener httpListener){
        this.httpListener=httpListener;
    }
}
