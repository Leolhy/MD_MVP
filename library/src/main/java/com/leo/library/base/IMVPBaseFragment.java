package com.leo.library.base;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017-08-31.
 */

public abstract class IMVPBaseFragment<V, T extends IMVPBasePresenter<V>> extends Fragment {

    protected T mPresenter;
    private View parent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onAttach((V) this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(getContentView(), null, false);
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
    protected <S extends View> S findViewById(@IdRes int resId) {
        return parent.findViewById(resId);
    }

    protected abstract T createPresenter();

    @LayoutRes
    protected abstract int getContentView();

    protected abstract void onCreate(View parent);

}
