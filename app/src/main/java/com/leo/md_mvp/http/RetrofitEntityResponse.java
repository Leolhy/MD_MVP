package com.leo.md_mvp.http;


/**
 * Author: Leoying
 * Date: 2019-05-06
 * Desc:
 */

public class RetrofitEntityResponse<T> extends BaseResponse {

    /**
     * data : {}
     * errorCode : 0
     * errorMsg :
     */

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
