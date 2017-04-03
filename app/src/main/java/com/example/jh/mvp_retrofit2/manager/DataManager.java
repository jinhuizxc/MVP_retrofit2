package com.example.jh.mvp_retrofit2.manager;

import android.content.Context;

import com.example.jh.mvp_retrofit2.bean.Book;
import com.example.jh.mvp_retrofit2.retrofit2.OkhttpUtils;
import com.example.jh.mvp_retrofit2.retrofit2.Api;

import rx.Observable;

/**
 * 作者：jinhui on 2017/4/1
 * 邮箱：1004260403@qq.com
 *
 * 数据管理类
 */

public class DataManager {

    private Api mApi;

    public DataManager(Context context) {
        this.mApi = OkhttpUtils.getInstance(context).getService();
    }

    public Observable<Book> getSearchBooks(String name, String tag, int start, int count) {
        return mApi.getSearchBooks(name,tag, start, count);
    }
}
