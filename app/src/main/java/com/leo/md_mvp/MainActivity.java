package com.leo.md_mvp;

import android.os.Bundle;

import com.leo.library.base.IMVPBaseActivity;

public class MainActivity extends IMVPBaseActivity<MainView, MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(int errorCode, String errorMsg) {

    }
}
