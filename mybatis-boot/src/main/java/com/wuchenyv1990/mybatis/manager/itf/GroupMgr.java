package com.wuchenyv1990.mybatis.manager.itf;

import com.wuchenyv1990.mybatis.entity.Group;

public interface GroupMgr {

    void addGroup(Group group);

    void delGroup(long gid);

    void modGroup(Group group);

    Group getGroup(long gid);

    Group getGroup(String name);

}
