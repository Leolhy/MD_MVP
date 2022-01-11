package com.leo.md_mvp.http;

import java.util.List;

/**
 * Author: Leoying
 * Date: 2019-04-19
 * Desc:
 */

public class RetrofitListResponse<T> extends BaseResponse {


    /**
     * data : []
     * errorCode : 0
     * errorMsg :
     */

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
