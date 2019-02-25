package com.wuchenyv1990.mybatis.manager.itf;

import com.wuchenyv1990.mybatis.entity.Group;
import com.wuchenyv1990.mybatis.entity.User;

import java.util.Set;

public interface UserMgr {

    User addUser(User user);

    void addToGroups(User user, Set<Group> groups);

    void rmFromGroups(User user, Set<Group> groups);

    void delUser(User user);

    void delUserById(long uid);

    void chUser(User user);

    User getUser(long uid);

    User getUser(String name);

}
