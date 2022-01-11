package com.leo.md_mvp.dagger.repository;

import androidx.annotation.NonNull;

import com.leo.md_mvp.api.ApiService;
import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.entities.UserEntity_;
import com.leo.md_mvp.http.RetrofitEntityResponse;
import com.leo.md_mvp.tools.DataResponse;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/10 15:27
 * Desc:
 */
public class UserRepository {

    private final UserRemoteRepository remoteRepository;
    private final UserLocalRepository localRepository;

    @Inject
    public UserRepository(UserRemoteRepository remoteRepository, UserLocalRepository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
    }


    public UserRemoteRepository getRemoteRepository() {
        return remoteRepository;
    }

    public UserLocalRepository getLocalRepository() {
        return localRepository;
    }

    public static class UserRemoteRepository {

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

    public static class UserLocalRepository {
        private final Box<UserEntity> box;

        @Inject
        public UserLocalRepository(Box<UserEntity> box) {
            this.box = box;
        }

        public UserEntity getLocalUser(String username) {
            List<UserEntity> userEntities = box.query().equal(UserEntity_.username, username, QueryBuilder.StringOrder.CASE_SENSITIVE).build().find();
            if (userEntities.size() > 0) {
                return userEntities.get(0);
            } else {
                return null;
            }
        }

        public void cacheUser(UserEntity userEntity) {
            box.put(userEntity);
        }

    }
}
