package com.leo.md_mvp.mvp.login.view;

import com.leo.library.base.IMVPBaseView;
import com.leo.md_mvp.entities.UserEntity;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/11 10:11
 * Desc:
 */
public interface LoginView extends IMVPBaseView {

    void onLoginResult(UserEntity entity);
}
