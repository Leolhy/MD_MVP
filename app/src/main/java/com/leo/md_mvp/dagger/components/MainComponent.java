package com.leo.md_mvp.dagger.components;

import com.leo.md_mvp.dagger.annotation.ActivityScope;
import com.leo.md_mvp.dagger.modules.MainModule;
import com.leo.md_mvp.mvp.main.MainActivity;

import dagger.Component;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 15:50
 * Desc:
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);
}
