package com.leo.library.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
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
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
    }

    protected class RequestInterceptor implements Interceptor {

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("X-APP-TYPE", "android")
                    .build();
            return chain.proceed(request);
        }
    }

    protected class LogInterceptor implements Interceptor {

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request();
            String url = request.url().toString();
            String params = requestBodyToString(request.body());
//            Response response = chain.proceed(request);
            Log.i(TAG, "Url=========" + url + "\nparams=========" + params);
            return chain.proceed(request);
        }
    }

    protected String requestBodyToString(RequestBody request) {
        try {
            Buffer buffer = new Buffer();
            if (request != null) {
                request.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
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

}
