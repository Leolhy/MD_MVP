package com.leo.library.base;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Administrator on 2017-08-31.
 */

public class IMVPBasePresenter<V> {
    private Reference<V> mReference = null;

    public void onAttach(V view) {
        mReference = new WeakReference<>(view);
    }

    public boolean isAttach() {
        return null != mReference && null != mReference.get();
    }

    public void onDetach() {
        if (null != mReference) {
            mReference.clear();
            mReference = null;
        }
    }

    /**
     * 获取视频第一帧图片
     *
     * @param file 视频文件
     * @return bitmap
     */
    public Bitmap getVideoFirstFrame(File file) {
        if (!file.exists()) {
            return null;
        }
        MediaMetadataRetriever media = new MediaMetadataRetriever();
        media.setDataSource(file.getAbsolutePath());
        return media.getFrameAtTime();
    }

    public interface OnDataCompleteListener {

        void onComplete(List... lists);

        void onError(int errorCode, String errorMsg);
    }

    public interface OnCompleteListener<T> {
        void onComplete(T t);
    }
}
