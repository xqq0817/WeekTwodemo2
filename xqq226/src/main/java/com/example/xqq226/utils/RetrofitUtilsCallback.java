package com.example.xqq226.utils;

public interface RetrofitUtilsCallback<T> {
    void success(T result);
    void failure(T error);
}
