package com.example.weekthreelx.presenter;

import com.example.weekthreelx.activity.MainActivity;
import com.example.weekthreelx.model.Model;
import com.example.weekthreelx.utils.RetrofitCallback;
import com.example.weekthreelx.view.DataView;

import java.util.HashMap;

public class Presenter implements PresenterCallback{
    private DataView dataView;
    private Model model=new Model();
    public Presenter(DataView dataView) {
        this.dataView=dataView;
    }

    @Override
    public void setData(String mpath, int type, String userId, String sessionId) {
        model.getData(mpath, type, userId, sessionId, new RetrofitCallback() {
            @Override
            public void success(Object result) {
                dataView.success(result);
            }

            @Override
            public void failure(Object error) {
                dataView.failure(error);
            }
        });
    }

  /*  @Override
    public void setData(String mpath, HashMap<String, String> map, int type) {
       model.getData(mpath, map, type, new RetrofitCallback() {
           @Override
           public void success(Object result) {
               dataView.success(result);
           }

           @Override
           public void failure(Object error) {
                dataView.failure(error);
           }
       });
    }*/
}
