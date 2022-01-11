package com.leo.md_mvp.http;

/**
 * Project: WanAndroid_XW
 * Creator: Leoying
 * Date: 2020-01-07 14:52
 * Desc:
 */
public class BaseResponse {
    private int errorCode;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
