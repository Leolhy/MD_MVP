package com.leo.md_mvp.mvp.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.leo.md_mvp.base.BaseDaggerMvpActivity;
import com.leo.md_mvp.dagger.components.AppComponent;
import com.leo.md_mvp.dagger.components.DaggerMainComponent;
import com.leo.md_mvp.dagger.modules.MainModule;
import com.leo.md_mvp.databinding.ActivityMainBinding;
import com.leo.md_mvp.mvp.main.presenter.MainPresenter;
import com.leo.md_mvp.mvp.main.view.MainView;

public class MainActivity extends BaseDaggerMvpActivity<MainView, MainPresenter, ActivityMainBinding> implements MainView {

    public static void openMain(Context context, boolean canGoBack) {
        Intent mainIntent = new Intent(context, MainActivity.class);
        context.startActivity(mainIntent);
        if (!canGoBack) ((Activity) context).finish();
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent).mainModule(new MainModule(getLayoutInflater())).build().inject(this);
    }

    @Override
    protected void initViews() {
        binding.text.setText(presenter.getMainStr());
    }

    @Override
    protected void initListeners() {

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
