package com.leo.library.base;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import com.leo.library.struct.FunctionsManager;

/**
 * Creator: Leoying
 * Date: 2019-01-25 15:52
 */
public abstract class BaseActivity extends AppCompatActivity {


    public void setFuncForFragment(String tag) {
        FragmentManager manager = getSupportFragmentManager();
        BaseFragment baseFragment = (BaseFragment) manager.findFragmentByTag(tag);
        baseFragment.setFunctionsManager(getFunctionManager());
    }

    protected abstract FunctionsManager getFunctionManager();

}
