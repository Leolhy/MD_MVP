package com.leo.md_mvp.entities;

import java.io.Serializable;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;

/**
 * Author: Leoying
 * Date: 2019-05-06
 * Desc:
 */
@Entity
public class UserEntity implements Serializable {

    /**
     * chapterTops : []
     * collectIds : []
     * email :
     * icon :
     * id : 7402
     * password :
     * token :
     * type : 0
     * username : HoyangLau
     */
    @Id(assignable = true)
    private long id;
    private String email;
    private String icon;
    private String password;
    private String token;
    private int type;
    private String username;
    @Transient
    private List<?> chapterTops;
    @Transient
    private List<?> collectIds;

    public UserEntity(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<?> getChapterTops() {
        return chapterTops;
    }

    public void setChapterTops(List<?> chapterTops) {
        this.chapterTops = chapterTops;
    }

    public List<?> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<?> collectIds) {
        this.collectIds = collectIds;
    }
}
