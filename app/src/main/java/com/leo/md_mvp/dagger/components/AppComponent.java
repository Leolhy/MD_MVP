package com.leo.md_mvp.dagger.components;

import android.app.Application;

import com.leo.md_mvp.api.ApiService;
import com.leo.md_mvp.dagger.modules.AppModule;
import com.leo.md_mvp.dagger.modules.ClientModule;
import com.leo.md_mvp.dagger.modules.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 11:15
 * Desc:
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, ServiceModule.class})
public interface AppComponent {

    Application application();

    ApiService apiService();
}
