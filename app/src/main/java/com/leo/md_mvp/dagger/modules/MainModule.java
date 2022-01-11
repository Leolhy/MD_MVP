package com.leo.md_mvp.dagger.modules;

import android.view.LayoutInflater;

import com.leo.md_mvp.dagger.annotation.ActivityScope;
import com.leo.md_mvp.databinding.ActivityMainBinding;

import dagger.Module;
import dagger.Provides;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 15:51
 * Desc:
 */
@Module
public class MainModule {

    private final LayoutInflater inflater;

    public MainModule(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @ActivityScope
    @Provides
    ActivityMainBinding provideActivityMainBinding() {
        return ActivityMainBinding.inflate(inflater);
    }

}
