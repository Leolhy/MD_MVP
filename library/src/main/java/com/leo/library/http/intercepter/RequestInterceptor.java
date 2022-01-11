package com.leo.library.http.intercepter;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 11:25
 * Desc:
 */
public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("X-APP-TYPE", "android")
                .build();
        return chain.proceed(request);
    }
}
