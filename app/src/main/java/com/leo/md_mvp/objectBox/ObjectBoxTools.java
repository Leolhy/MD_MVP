package com.leo.md_mvp.objectBox;

import android.content.Context;


import com.leo.md_mvp.entities.MyObjectBox;

import io.objectbox.BoxStore;

/**
 * Project: WanAndroid_XW
 * Creator: Leoying
 * Date: 2020-09-28 17:10
 * Desc:
 */
public class ObjectBoxTools {

    private static BoxStore boxStore;

    public static void init(Context context) {
        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();
    }

    public static BoxStore get() {
        return boxStore;
    }

}
