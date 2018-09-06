package com.leo.library.base;

import android.os.Bundle;

/**
 * Author: Leoying
 * Date: 2018-09-06
 * Desc:
 */

public abstract class IMVPLazyLoadBaseFragment<V, T extends IMVPBasePresenter<V>> extends LazyLoadFragment {

    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttach((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    protected abstract T createPresenter();
}
