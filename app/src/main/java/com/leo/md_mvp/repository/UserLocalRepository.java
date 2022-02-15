package com.leo.md_mvp.repository;

import com.leo.md_mvp.entities.UserEntity;
import com.leo.md_mvp.entities.UserEntity_;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/21 11:38
 * Desc:
 */
public class UserLocalRepository {
    private final Box<UserEntity> box;

    @Inject
    public UserLocalRepository(Box<UserEntity> box) {
        this.box = box;
    }

    public UserEntity getLocalUser(String username) {
        List<UserEntity> userEntities = box.query().equal(UserEntity_.username, username, QueryBuilder.StringOrder.CASE_SENSITIVE).build().find();
        if (userEntities.size() > 0) {
            return userEntities.get(0);
        } else {
            return null;
        }
    }

    public void cacheUser(UserEntity userEntity) {
        box.put(userEntity);
    }

}
