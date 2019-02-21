package com.wuchenyv1990.mybatis.entity;

import java.util.Set;

public class User {

    private long uid;

    private Set<Long> gids;

    private String name;

    private String passwd;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Set<Long> getGids() {
        return gids;
    }

    public void setGids(Set<Long> gids) {
        this.gids = gids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
