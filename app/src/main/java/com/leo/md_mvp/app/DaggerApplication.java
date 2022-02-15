package com.leo.md_mvp.app;

import android.app.Application;
import android.content.Context;


import com.leo.md_mvp.dagger.modules.AppModule;
import com.leo.md_mvp.dagger.modules.BoxModule;
import com.leo.md_mvp.dagger.modules.ClientModule;
import com.leo.md_mvp.dagger.modules.ServiceModule;

import okhttp3.Interceptor;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 14:07
 * Desc:
 */
public abstract class DaggerApplication extends Application {
    private static DaggerApplication application;
    private ClientModule clientModule;
    private AppModule appModule;
    private ServiceModule serviceModule;
    private BoxModule boxModule;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        this.clientModule = ClientModule
                .builder()
                .withBaseUrl(getBaseUrl())
                .withInterceptors(getInterceptors())
                .build();
        this.appModule = new AppModule(this);
        this.serviceModule = new ServiceModule();
        this.boxModule = new BoxModule();
    }

    public ClientModule getClientModule() {
        return clientModule;
    }

    public AppModule getAppModule() {
        return appModule;
    }

    public ServiceModule getServiceModule() {
        return serviceModule;
    }

    public BoxModule getBoxModule() {
        return boxModule;
    }

    protected abstract String getBaseUrl();

    protected Interceptor[] getInterceptors() {
        return null;
    }

    protected static Context getContext() {
        return application;
    }
}
