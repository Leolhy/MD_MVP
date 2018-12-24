package com.leo.md_mvp;

import com.leo.library.base.IMVPBasePresenter;

/**
 * Creator: Leoying
 * Date: 2018-11-08 11:05
 */
public class MainPresenter extends IMVPBasePresenter<MainView> {

    private MainView mainView;


    public MainPresenter(MainView mainView) {
        this.mainView = mainView;


    }
}
