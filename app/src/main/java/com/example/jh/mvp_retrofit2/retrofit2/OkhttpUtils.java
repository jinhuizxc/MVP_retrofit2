package com.example.jh.mvp_retrofit2.retrofit2;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：jinhui on 2017/4/1
 * 邮箱：1004260403@qq.com
 *
 * 1.当前Android studio内嵌了OkHttpClient3，所以不用导包
 * 2. 对于json的话导入包3个对象：Gson、GsonConverterFactory、GsonBuilder
 */

public class OkhttpUtils {

    private Context context;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());

    private static OkhttpUtils instance = null;
    private Retrofit retrofit = null;

    // 构造方法
    public OkhttpUtils(Context context) {
        this.context = context;
        init();
    }
    // 单例模式
    public static OkhttpUtils getInstance(Context context){
       if(instance == null){
           instance = new OkhttpUtils(context);
       }
        return instance;
    }

    public void init(){
      retrofit = new Retrofit.Builder()
              .baseUrl("https://api.douban.com/v2/")
              .client(okHttpClient)
              .addConverterFactory(factory)
              .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
              .build();
    }

    public Api getService(){
        return retrofit.create(Api.class);
    }


}
