package com.leo.md_mvp.dagger.components;

import com.leo.md_mvp.dagger.annotation.ActivityScope;
import com.leo.md_mvp.dagger.modules.LoginModule;
import com.leo.md_mvp.repository.UserRepository;

import dagger.Component;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/10 14:36
 * Desc:
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {LoginModule.class})
public interface LoginComponent {

    UserRepository getUserRepository();

    void inject(com.leo.md_mvp.mvp.login.LoginActivity activity);

    void inject(com.leo.md_mvp.mvvm.view.LoginActivity activity);
}
