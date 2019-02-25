package com.wuchenyv1990.mybatis.manager;

import com.wuchenyv1990.mybatis.entity.Group;
import com.wuchenyv1990.mybatis.entity.User;
import com.wuchenyv1990.mybatis.manager.itf.UserMgr;
import com.wuchenyv1990.mybatis.mapper.UGMapper;
import com.wuchenyv1990.mybatis.mapper.UserMapper;
import com.wuchenyv1990.mybatis.util.Dict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMgrImpl implements UserMgr {

    @Resource
    UserMapper userMapper;

    @Resource
    UGMapper ugMapper;

    @Override
    @Transactional
    public User addUser(User user) {
        userMapper.addUser(user);
        user.getGids().forEach(gid -> ugMapper.addUG(user.getUid(), gid));
        return user;
    }

    @Override
    @Transactional
    public void addToGroups(User user, Set<Group> groups) {
        Set<Long> gids = groups.stream()
            .map(group -> group.getGid())
            .collect(Collectors.toSet());
        gids.removeAll(user.getGids());
        gids.forEach(gid -> ugMapper.addUG(user.getUid(), gid));
    }

    @Override
    @Transactional
    public void rmFromGroups(User user, Set<Group> groups) {
        Set<Long> gids = groups.stream()
            .map(group -> group.getGid())
            .collect(Collectors.toSet());
        gids.retainAll(user.getGids());
        gids.forEach(gid -> ugMapper.rmUG(user.getUid(), gid));
    }

    @Override
    @Transactional
    public void delUser(User user) {
        userMapper.delUser(Dict.set("uid", user.getUid()));
        user.getGids().forEach(gid -> ugMapper.rmUG(user.getUid(), gid));
    }

    @Override
    @Transactional
    public void delUserById(long uid) {
        User u = getUser(uid);
        delUser(u);
    }

    @Override
    @Transactional
    public void chUser(User user) {
        userMapper.chUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long uid) {
        return userMapper.getUsers(Dict.set("uid", uid)).get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(String name) {
        return userMapper.getUsers(Dict.set("name", name)).get(0);
    }

}
