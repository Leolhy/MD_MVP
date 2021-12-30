package com.leo.library.base;

import android.os.Bundle;

/**
 * Author: Leoying
 * Date: 2018-09-06
 * Desc:
 */

public abstract class IMVPLazyLoadBaseFragment<View extends IMVPBaseView, Presenter extends IMVPBasePresenter<View>> extends LazyLoadFragment {

    protected Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttach((View) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    protected abstract Presenter createPresenter();
}
