package com.leo.md_mvp.dagger.modules;

import com.leo.md_mvp.api.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 13:59
 * Desc:
 */
@Module
public class ServiceModule {

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
