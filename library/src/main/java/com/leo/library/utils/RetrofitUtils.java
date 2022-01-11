package com.leo.library.utils;

import com.leo.library.http.intercepter.LogInterceptor;
import com.leo.library.http.intercepter.RequestInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Creator: Leoying
 * Date: 2018-12-06 20:58
 */
public abstract class RetrofitUtils {

    private static String TAG = "RetrofitUtils";

    private final long CONNECT_TIMEOUT = 60L;
    private final long READ_TIMEOUT = 30L;
    private final long WRITE_TIMEOUT = 30L;

    private Retrofit retrofit;

    protected void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    protected OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(new RequestInterceptor())
                .addInterceptor(new LogInterceptor());
        List<Interceptor> interceptors = addInterceptors();
        for (Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }
        return builder.build();
    }

    public <S> S createServer(Class<S> cls) {
        return retrofit.create(cls);
    }

    public <T> ObservableTransformer<T, T> ioMain() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upStream) {
                return upStream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    protected abstract String getBaseUrl();

    protected List<Interceptor> addInterceptors() {
        return new ArrayList<>();
    }


}
