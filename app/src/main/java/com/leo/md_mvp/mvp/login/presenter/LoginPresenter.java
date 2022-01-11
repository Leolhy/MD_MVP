package com.leo.md_mvp.mvp.login.presenter;

import com.leo.library.base.IMVPBasePresenter;
import com.leo.md_mvp.dagger.repository.UserRepository;
import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.mvp.login.view.LoginView;

import javax.inject.Inject;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/11 10:12
 * Desc:
 */
public class LoginPresenter extends IMVPBasePresenter<LoginView> {

    private final UserRepository userRepository;

    @Inject
    public LoginPresenter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(String username, String password) {
        userRepository.getRemoteRepository().login(username, password, userEntity -> {
            getView().hideLoading();
            getView().onLoginResult(userEntity);
        });
        getView().showLoading();
    }

    public void cacheUser(UserEntity userEntity) {
        userRepository.getLocalRepository().cacheUser(userEntity);
    }
}
