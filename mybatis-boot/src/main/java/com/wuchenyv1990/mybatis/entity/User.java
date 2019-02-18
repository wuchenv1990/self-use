package com.wuchenyv1990.mybatis.entity;

import java.util.List;

public class User {

    private long uid;

    private List<Long> gids;

    private String name;

    private String passwd;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public List<Long> getGids() {
        return gids;
    }

    public void setGids(List<Long> gids) {
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
