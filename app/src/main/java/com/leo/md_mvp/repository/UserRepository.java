package com.leo.md_mvp.repository;

import javax.inject.Inject;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2022/1/10 15:27
 * Desc:
 */
public class UserRepository {

    private final UserRemoteRepository remote;
    private final UserLocalRepository local;

    @Inject
    public UserRepository(UserRemoteRepository remoteRepository, UserLocalRepository localRepository) {
        this.remote = remoteRepository;
        this.local = localRepository;
    }

    public UserRemoteRepository getRemote() {
        return remote;
    }

    public UserLocalRepository getLocal() {
        return local;
    }

}
