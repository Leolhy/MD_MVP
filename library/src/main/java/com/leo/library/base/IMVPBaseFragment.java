package com.leo.library.base;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017-08-31.
 */

public abstract class IMVPBaseFragment<View extends IMVPBaseView, Presenter extends IMVPBasePresenter<View>> extends Fragment {

    protected Presenter mPresenter;
    private android.view.View parent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttach((View) this);
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View inflate = LayoutInflater.from(getContext()).inflate(getContentView(), container, false);
        this.parent = inflate;
        onCreate(inflate);
        return inflate;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    @Nullable
    protected <S extends android.view.View> S findViewById(@IdRes int resId) {
        return parent.findViewById(resId);
    }

    protected abstract Presenter createPresenter();

    @LayoutRes
    protected abstract int getContentView();

    protected abstract void onCreate(android.view.View parent);

}
