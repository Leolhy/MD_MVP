package com.leo.md_mvp.dagger.modules;

import android.view.LayoutInflater;

import com.leo.md_mvp.dagger.annotation.ActivityScope;
import com.leo.md_mvp.databinding.ActivityLoginBinding;
import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.objectBox.ObjectBoxTools;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/10 14:38
 * Desc:
 */
@Module
public class LoginModule {
    private final LayoutInflater inflater;

    public LoginModule(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @ActivityScope
    @Provides
    public ActivityLoginBinding provideActivityLoginBinding() {
        return ActivityLoginBinding.inflate(inflater);
    }


    @Provides
    public UserEntity provideLocalUserEntity(Box<UserEntity> box) {
        List<UserEntity> userEntities = box.query().build().find();
        if (!(userEntities.size() <= 0)) {
            return userEntities.get(0);
        }
        else {
            return null;
        }
    }

}
