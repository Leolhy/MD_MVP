package com.leo.md_mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.leo.library.base.IMVPBasePresenter;
import com.leo.library.base.IMVPBaseView;
import com.leo.md_mvp.app.SimpleApplication;
import com.leo.md_mvp.dagger.components.AppComponent;

import javax.inject.Inject;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 14:56
 * Desc:
 */
public abstract class BaseDaggerMvpActivity<View extends IMVPBaseView, Presenter extends IMVPBasePresenter<View>, Binding extends ViewBinding> extends AppCompatActivity {

    @Inject
    protected Binding binding;
    @Inject
    protected Presenter presenter;

    private SimpleApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        application = (SimpleApplication) getApplication();
        componentInject(application.getAppComponent());
        super.onCreate(savedInstanceState);
        presenter.onAttach((View) this);
        setContentView(binding.getRoot());
        initViews();
        initListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    protected abstract void componentInject(AppComponent appComponent);

    protected abstract void initViews();

    protected abstract void initListeners();
}
