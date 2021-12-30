package com.leo.library.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by Administrator on 2017-08-31.
 */

public abstract class IMVPBaseActivity<View extends IMVPBaseView, Presenter extends IMVPBasePresenter<View>> extends AppCompatActivity {

    protected Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttach((View) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    protected abstract Presenter createPresenter();

}
