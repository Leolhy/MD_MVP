package com.leo.library.utils;

import android.content.Context;
import androidx.annotation.StringRes;
import android.widget.Toast;

/**
 * Creator: Leoying
 * Date: 2018/9/7 15:36
 */
public class ToastUtils {

    public static void showToastShort(Context context, @StringRes int id) {
        showToastShort(context, context.getText(id));
    }

    public static void showToastShort(Context context, CharSequence s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context, @StringRes int id) {
        showToastLong(context, context.getText(id));
    }

    public static void showToastLong(Context context, CharSequence s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }


}
