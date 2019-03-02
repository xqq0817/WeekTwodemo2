package com.example.xqq226.presenter;

import com.example.xqq226.activity.MainActivity;
import com.example.xqq226.model.ShowModel;
import com.example.xqq226.utils.RetrofitUtilsCallback;
import com.example.xqq226.view.ShowView;

import java.util.HashMap;
import java.util.Map;

public class ShowPresenter implements ShowPresenterCallback{
    private ShowView showview;
    private ShowModel showModel;
    public ShowPresenter(ShowView showview) {
        this.showview=showview;
        showModel=new ShowModel();
    }

    @Override
    public void getData(String url, Map<String, String> map) {
        showModel.getData(url, map, new RetrofitUtilsCallback() {
            //成功
            @Override
            public void success(Object result) {
                showview.success(result);
            }
            //失败
            @Override
            public void failure(Object error) {
                showview.failure(error);
            }
        });
    }

}
