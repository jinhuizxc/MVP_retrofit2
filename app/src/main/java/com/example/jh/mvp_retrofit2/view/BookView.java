package com.example.jh.mvp_retrofit2.view;

import com.example.jh.mvp_retrofit2.bean.Book;

/**
 * 作者：jinhui on 2017/4/1
 * 邮箱：1004260403@qq.com
 */

public interface BookView extends BaseView{
    void onSuccess(Book mBook);
    void onError(String result);
}
