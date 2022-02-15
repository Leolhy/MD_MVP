package com.leo.md_mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;

import com.leo.md_mvp.app.SimpleApplication;
import com.leo.md_mvp.dagger.components.AppComponent;

import javax.inject.Inject;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/14 11:23
 * Desc:
 */
public abstract class BaseDaggerMvvmActivity<BD extends ViewBinding, VM extends ViewModel> extends AppCompatActivity {

    @Inject
    protected BD binding;

    @Inject
    protected VM viewModel;

    private SimpleApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        application = (SimpleApplication) getApplication();
        componentInject(application.getAppComponent());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initViews();
        initListeners();
        initObserver();
    }

    protected abstract void componentInject(AppComponent appComponent);

    protected abstract void initViews();

    protected abstract void initListeners();

    protected abstract void initObserver();
}
