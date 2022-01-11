package com.leo.library.utils;

import android.app.Application;

import java.io.File;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 14:04
 * Desc:
 */
public class DataHelper {

    public static File getCacheFile(Application application) {
        return application.getCacheDir();
    }

}
