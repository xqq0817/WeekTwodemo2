package com.example.xqq226.view;

public interface ShowView<T> {
    void success(T result);
    void failure(T error);
}
