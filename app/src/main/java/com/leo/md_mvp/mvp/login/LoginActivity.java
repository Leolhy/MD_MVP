package com.leo.md_mvp.mvp.login;

import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextWatcher;

import com.leo.md_mvp.base.BaseDaggerMvpActivity;
import com.leo.md_mvp.dagger.components.AppComponent;
import com.leo.md_mvp.dagger.components.DaggerLoginComponent;
import com.leo.md_mvp.dagger.modules.LoginModule;
import com.leo.md_mvp.databinding.ActivityLoginBinding;
import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.mvp.login.presenter.LoginPresenter;
import com.leo.md_mvp.mvp.login.view.LoginView;
import com.leo.md_mvp.mvp.main.MainActivity;

public class LoginActivity extends BaseDaggerMvpActivity<LoginView, LoginPresenter, ActivityLoginBinding> implements LoginView {
    private String username = "";
    private String password = "";
    private ProgressDialog progressDialog;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerLoginComponent.builder().appComponent(appComponent).loginModule(new LoginModule(getLayoutInflater())).build().inject(this);
    }

    @Override
    protected void initViews() {

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
        binding.loginBtn.setOnClickListener(v -> presenter.login(username, password));
    }

    @Override
    public void onLoginResult(UserEntity entity) {
        if (entity != null) {
            presenter.cacheUser(entity);
            MainActivity.openMain(this, false);
        }
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("请稍候...");
        }
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showError(int errorCode, String errorMsg) {

    }


}