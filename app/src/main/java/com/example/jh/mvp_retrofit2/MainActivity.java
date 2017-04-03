package com.example.jh.mvp_retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jh.mvp_retrofit2.bean.Book;
import com.example.jh.mvp_retrofit2.presenter.BookPresenter;
import com.example.jh.mvp_retrofit2.view.BaseView;
import com.example.jh.mvp_retrofit2.view.BookView;

/**
 * 测试MVP、retrofit2
 */
public class MainActivity extends AppCompatActivity implements BookView {

    private TextView textView;
    private Button button;
    private BookPresenter mBookPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        //presenter的初始化
        mBookPresenter = new BookPresenter(this);
        // attachView(this)——>事先BaseView这个接口，也可以将这个部分写在BookPresenter的构造方法里面
        mBookPresenter.attachView(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBookPresenter.getSearchBooks("本草纲目", null, 0, 1);
            }
        });
    }

    @Override
    public void onSuccess(Book mBook) {
        textView.setText(mBook.toString());
    }

    @Override
    public void onError(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
    /**
     * 补充一点：接口的另一种实现方式，内部类
     *  private BookView mBookView = new BookView() {
    @Override
    public void onSuccess(Book mBook) {
    textView.setText(mBook.toString());
    }

    @Override
    public void onError(String result) {
    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }
    };
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }
}
