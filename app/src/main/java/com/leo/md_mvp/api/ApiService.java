package com.leo.md_mvp.api;

import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.http.RetrofitEntityResponse;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 13:59
 * Desc:
 */
public interface ApiService {

    @POST("/user/login")
    Observable<RetrofitEntityResponse<UserEntity>> loginIn(@Query("username") String username,
                                                           @Query("password") String password);

}
