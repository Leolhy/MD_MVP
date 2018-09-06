package com.leo.library.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Administrator on 2017-08-31.
 */

public abstract class IMVPBaseActivity<V, T extends IMVPBasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    protected abstract T createPresenter();

}
