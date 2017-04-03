package com.example.jh.mvp_retrofit2.retrofit2;

import com.example.jh.mvp_retrofit2.bean.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：jinhui on 2017/4/1
 * 邮箱：1004260403@qq.com
 */

public interface Api {

    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name, @Query("tag") String tag,
                                    @Query("start") int start, @Query("count") int count);
}
