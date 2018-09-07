package com.leo.library.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Creator: Leoying
 * Date: 2018/9/7 15:36
 */
public class ToastUtils {
    private static Toast toast;


    public static void showToast(Context context, @StringRes int id) {
        showToast(context, context.getText(id));
    }

    public static void showToast(Context context, CharSequence s) {
        if (toast == null) {
            toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.setText(s);
        toast.show();
    }


}
