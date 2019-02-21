package com.wuchenyv1990.mybatis.manager.itf;

import com.wuchenyv1990.mybatis.entity.Group;

public interface GroupMgr {

    Group addGroup(Group group);

    void delGroup(long gid);

    Group modGroup(String name);

    Group getGroup(long gid);

}
