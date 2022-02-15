package com.leo.library.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Administrator on 2017-08-31.
 */

public class IMVPBasePresenter<View extends IMVPBaseView> {
    protected Reference<View> mReference = null;

    public void onAttach(View view) {
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

    protected View getView() {
        return isAttach() ? mReference.get() : null;
    }

    public interface OnDataCompleteListener {

        void onComplete(List... lists);

        void onError(int errorCode, String errorMsg);
    }

    public interface OnCompleteListener<T> {
        void onComplete(T t);
    }
}
