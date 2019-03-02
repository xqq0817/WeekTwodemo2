package com.example.rkao14.utils;

public interface RetrofitCallBack<T> {
    void onsuccess(T  result);
    void onfailure(T error);
}
