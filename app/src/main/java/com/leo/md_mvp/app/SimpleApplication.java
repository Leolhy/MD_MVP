package com.leo.md_mvp.app;

import com.leo.md_mvp.dagger.components.AppComponent;
import com.leo.md_mvp.dagger.components.DaggerAppComponent;
import com.leo.md_mvp.objectBox.ObjectBoxTools;

import okhttp3.Interceptor;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 14:15
 * Desc:
 */
public class SimpleApplication extends DaggerApplication {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(getAppModule())
                .clientModule(getClientModule())
                .serviceModule(getServiceModule())
                .boxModule(getBoxModule())
                .build();
        ObjectBoxTools.init(this);
    }

    @Override
    protected String getBaseUrl() {
        return "https://www.wanandroid.com";
    }

    @Override
    protected Interceptor[] getInterceptors() {
        return new Interceptor[0];
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
