package com.leo.library.http.intercepter;

import android.util.Log;

import androidx.annotation.NonNull;

import com.leo.library.utils.RetrofitUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 11:25
 * Desc:
 */
public class LogInterceptor implements Interceptor {

    private static final String TAG = "LogInterceptor";

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().toString();
        String params = requestBodyToString(request.body());
//            Response response = chain.proceed(request);
        Log.i(TAG, "Url=========" + url + "\nparams=========" + params);
        return chain.proceed(request);
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
}
