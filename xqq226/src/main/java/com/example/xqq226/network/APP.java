package com.example.xqq226.network;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
