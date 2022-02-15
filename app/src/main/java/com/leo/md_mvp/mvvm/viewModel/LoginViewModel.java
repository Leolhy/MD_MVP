package com.leo.md_mvp.mvvm.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.repository.UserRepository;

import javax.inject.Inject;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/14 11:28
 * Desc:
 */
public class LoginViewModel extends ViewModel {

    private final UserRepository userRepository;
    public MutableLiveData<UserEntity> userEntityLiveData = new MutableLiveData<>();

    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(String username, String password) {
        userRepository.getRemote().login(username, password, userEntity -> userEntityLiveData.setValue(userEntity));
    }


}
