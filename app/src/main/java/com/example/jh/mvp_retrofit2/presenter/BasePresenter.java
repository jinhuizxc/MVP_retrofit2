package com.example.jh.mvp_retrofit2.presenter;


import com.example.jh.mvp_retrofit2.view.BaseView;

/**
 * 作者：jinhui on 2017/4/1
 * 邮箱：1004260403@qq.com
 */

public interface BasePresenter {
    void attachView(BaseView view);
    void onStop();
}
