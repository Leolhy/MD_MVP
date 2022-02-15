package com.leo.md_mvp.mvvm.view;

import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextWatcher;

import com.leo.md_mvp.base.BaseDaggerMvvmActivity;
import com.leo.md_mvp.dagger.components.AppComponent;
import com.leo.md_mvp.dagger.components.DaggerLoginComponent;
import com.leo.md_mvp.dagger.modules.LoginModule;
import com.leo.md_mvp.databinding.ActivityLoginBinding;
import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.mvp.main.MainActivity;
import com.leo.md_mvp.mvvm.viewModel.LoginViewModel;

import javax.inject.Inject;

import dagger.Lazy;

public class LoginActivity extends BaseDaggerMvvmActivity<ActivityLoginBinding, LoginViewModel> {
    private String username = "";
    private String password = "";
    private ProgressDialog progressDialog;

    @Inject
    Lazy<UserEntity> lazyUser;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(getLayoutInflater()))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
//        UserEntity userEntity = lazyUser.get();
//        if (userEntity != null) {
//            MainActivity.openMain(this, false);
//        }
    }

    @Override
    protected void initListeners() {
        binding.loginTvAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                username = s.toString();
            }
        });
        binding.loginTvPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                password = s.toString();
            }
        });
        binding.loginBtn.setOnClickListener(v -> viewModel.login(username, password));
    }

    @Override
    protected void initObserver() {
        viewModel.userEntityLiveData.observe(this, userEntity -> {
            if (userEntity != null) {
                MainActivity.openMain(this, false);
            }
        });
    }

}