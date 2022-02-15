package com.leo.md_mvp.dagger.modules;

import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.objectBox.ObjectBoxTools;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/11 15:44
 * Desc:
 */
@Module
public class BoxModule {

    @Singleton
    @Provides
    public Box<UserEntity> provideUserBox() {
        return ObjectBoxTools.get().boxFor(UserEntity.class);
    }

}
