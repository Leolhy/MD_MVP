package com.leo.md_mvp.dagger.modules;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 11:16
 * Desc:
 */
@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return this.application;
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }
}
