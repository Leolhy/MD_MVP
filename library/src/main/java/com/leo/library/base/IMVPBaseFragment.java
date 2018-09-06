package com.leo.library.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017-08-31.
 */

public abstract class IMVPBaseFragment<V, T extends IMVPBasePresenter<V>> extends Fragment {

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
