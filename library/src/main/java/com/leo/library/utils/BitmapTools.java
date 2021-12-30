package com.leo.library.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.io.File;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/29 17:40
 * Desc:
 */
public class BitmapTools {

    /**
     * 获取视频第一帧图片
     *
     * @param file 视频文件
     * @return bitmap
     */
    public static Bitmap getVideoFirstFrame(File file) {
        if (!file.exists()) {
            return null;
        }
        MediaMetadataRetriever media = new MediaMetadataRetriever();
        media.setDataSource(file.getAbsolutePath());
        return media.getFrameAtTime();
    }
}
