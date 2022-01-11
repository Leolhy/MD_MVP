package com.leo.md_mvp.dagger.components;

import com.leo.md_mvp.dagger.annotation.ActivityScope;
import com.leo.md_mvp.dagger.modules.LoginModule;
import com.leo.md_mvp.dagger.reponstory.UserRepository;
import com.leo.md_mvp.mvp.login.LoginActivity;

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

    void inject(LoginActivity activity);
}
