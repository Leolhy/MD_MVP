package com.leo.md_mvp.dagger.modules;

import android.view.LayoutInflater;

import com.leo.md_mvp.dagger.annotation.ActivityScope;
import com.leo.md_mvp.dagger.reponstory.UserRepository;
import com.leo.md_mvp.databinding.ActivityLoginBinding;
import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.objectBox.ObjectBoxTools;

import javax.inject.Inject;

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
    public Box<UserEntity> provideUserBox() {
        return ObjectBoxTools.get().boxFor(UserEntity.class);
    }

    @ActivityScope
    @Provides
    public ActivityLoginBinding provideActivityLoginBinding() {
        return ActivityLoginBinding.inflate(inflater);
    }

}
