package com.leo.library.base;

import android.content.Context;
import androidx.fragment.app.Fragment;

import com.leo.library.struct.FunctionsManager;

/**
 * Creator: Leoying
 * Date: 2019-01-25 15:41
 */
public class BaseFragment extends Fragment {

    protected FunctionsManager functionsManager;
    protected BaseActivity baseActivity;

    public void setFunctionsManager(FunctionsManager functionsManager) {
        this.functionsManager = functionsManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            baseActivity = (BaseActivity) context;
            baseActivity.setFuncForFragment(getTag());
        }
    }
}
