package com.example.weekthreelx.view;

public interface DataView<T> {
    void success(T data);
    void failure(T error);
}
