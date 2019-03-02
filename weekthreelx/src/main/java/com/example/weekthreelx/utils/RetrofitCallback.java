package com.example.weekthreelx.utils;

public interface RetrofitCallback<T> {
    void success(T result);
    void failure(T error);
}
