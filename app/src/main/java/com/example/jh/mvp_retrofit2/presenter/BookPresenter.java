package com.example.jh.mvp_retrofit2.presenter;

import android.content.Context;

import com.example.jh.mvp_retrofit2.manager.DataManager;
import com.example.jh.mvp_retrofit2.bean.Book;
import com.example.jh.mvp_retrofit2.view.BaseView;
import com.example.jh.mvp_retrofit2.view.BookView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 作者：jinhui on 2017/4/1
 * 邮箱：1004260403@qq.com
 */

public class BookPresenter implements BasePresenter {

    // 数据类
    private DataManager mDataManager;
    // 取消订阅的对象
    private CompositeSubscription mCompositeSubscription;
    // 在presenter里面得有BookView
    private BookView mBookView;
    private Context mContext;
    private Book mBook;

    public BookPresenter(Context mContext) {
        this.mContext = mContext;
        // 初始化数据类， 在类中不可避免的要传入上下文的引用
        mDataManager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void attachView(BaseView view) {
        // 子类指向父类，强制转型
        mBookView = (BookView) view;
    }

    // 取消订阅
    @Override
    public void onStop() {
        if(mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }
    // 查找书籍：名字、tag标签、start开始、count数量？
    public void getSearchBooks(String name, String tag, int start, int count) {
        // 添加订阅
        mCompositeSubscription.add(mDataManager.getSearchBooks(name, tag, start, count)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Book>() {
            @Override
            public void onCompleted() {
                if(mBook != null){
                    mBookView.onSuccess(mBook);
                }
            }

            @Override
            public void onError(Throwable e) {
                // 错误时
                e.printStackTrace();
                mBookView.onError("请求失败");
            }

            @Override
            public void onNext(Book book) {
                mBook = book;
            }
        }));
    }



}
