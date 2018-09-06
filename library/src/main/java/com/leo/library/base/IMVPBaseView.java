package com.leo.library.base;

/**
 * Created by Administrator on 2017-08-31.
 */

public interface IMVPBaseView {

    void showLoading();

    void hideLoading();

    void showError(int errorCode, String errorMsg);
}
