package com.leo.md_mvp.repository;

import androidx.annotation.NonNull;

import com.leo.md_mvp.api.ApiService;
import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.http.RetrofitEntityResponse;
import com.leo.md_mvp.tools.DataResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/21 11:38
 * Desc:
 */
public class UserRemoteRepository {

    private final ApiService apiService;

    @Inject
    public UserRemoteRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void login(String username, String password, DataResponse<UserEntity> dataResponse) {
        apiService.loginIn(username, password)
                .compose(ioMain())
                .subscribe(new Observer<RetrofitEntityResponse<UserEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull RetrofitEntityResponse<UserEntity> userEntityRetrofitEntityResponse) {
                        dataResponse.onData(userEntityRetrofitEntityResponse.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public <T> ObservableTransformer<T, T> ioMain() {
        return upStream -> upStream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
