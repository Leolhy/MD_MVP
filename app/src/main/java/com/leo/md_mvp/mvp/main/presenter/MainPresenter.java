package com.leo.md_mvp.mvp.main.presenter;

import com.leo.library.base.IMVPBasePresenter;
import com.leo.md_mvp.api.ApiService;
import com.leo.md_mvp.mvp.main.view.MainView;

import javax.inject.Inject;

/**
 * Creator: Leoying
 * Date: 2018-11-08 11:05
 */
public class MainPresenter extends IMVPBasePresenter<MainView> {

    private ApiService apiService;

    @Inject
    public MainPresenter(ApiService apiService) {
        this.apiService = apiService;
    }


    public String getMainStr() {
        return apiService.getClass().getSimpleName();
    }

}
