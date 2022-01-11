package com.leo.md_mvp.dagger.modules;

import android.app.Application;
import android.text.TextUtils;

import com.leo.library.http.intercepter.LogInterceptor;
import com.leo.library.http.intercepter.RequestInterceptor;
import com.leo.md_mvp.dagger.annotation.CacheFile;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 11:22
 * Desc:
 */
@Module
public class ClientModule {
    private static final long CONNECT_TIMEOUT = 60L;
    private static final long READ_TIMEOUT = 30L;
    private static final long WRITE_TIMEOUT = 30L;
    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;

    private final HttpUrl httpUrl;
    private final Interceptor[] interceptors;

    private ClientModule(Builder builder) {
        this.httpUrl = builder.httpUrl;
        this.interceptors = builder.interceptors;
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(Cache cache) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return configureClient(builder, cache);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, HttpUrl httpUrl) {
        final Retrofit.Builder builder = new Retrofit.Builder();
        return configureRetrofit(builder, client, httpUrl);
    }

    @Singleton
    @Provides
    HttpUrl provideBaseUrl() {
        return httpUrl;
    }

    @Singleton
    @Provides
    Cache providerCache(@CacheFile File cacheFile) {
        return new Cache(cacheFile, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }

    @Singleton
    @CacheFile
    @Provides
    File provideCacheFile(Application application) {
        return application.getCacheDir();
    }

    @Singleton
    @Provides
    File provideFile(Application application) {
        return application.getExternalCacheDir();
    }

    private OkHttpClient configureClient(OkHttpClient.Builder builder, Cache cache) {
        builder.retryOnConnectionFailure(true)
                .cache(cache)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(new LogInterceptor());
        if (interceptors != null && interceptors.length > 0) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }

    private Retrofit configureRetrofit(Retrofit.Builder builder, OkHttpClient client, HttpUrl httpUrl) {
        builder.baseUrl(httpUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private HttpUrl httpUrl;
        private Interceptor[] interceptors;

        private Builder() {
        }

        public Builder withBaseUrl(String baseUrl) {
            if (TextUtils.isEmpty(baseUrl)) {
                throw new IllegalArgumentException("'baseUrl' can not be empty");
            }
            this.httpUrl = HttpUrl.parse(baseUrl);
            return this;
        }

        public Builder withInterceptors(Interceptor[] interceptors) {
            this.interceptors = interceptors;
            return this;
        }

        public ClientModule build() {
            return new ClientModule(this);
        }
    }
}
