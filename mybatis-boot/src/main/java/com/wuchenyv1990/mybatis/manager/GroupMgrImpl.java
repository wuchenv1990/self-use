package com.wuchenyv1990.mybatis.manager;

import com.wuchenyv1990.mybatis.entity.Group;
import com.wuchenyv1990.mybatis.manager.itf.GroupMgr;
import com.wuchenyv1990.mybatis.manager.itf.UserMgr;
import com.wuchenyv1990.mybatis.mapper.GroupMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//@Service
public class GroupMgrImpl implements GroupMgr {

    @Resource
    GroupMapper groupMapper;

    @Resource
    UserMgr userMgr;

    @Override
    @Transactional
    public void addGroup(Group group) {
        groupMapper.addGroup(group);
    }

    @Override
    @Transactional
    public void delGroup(long gid) {

    }

    @Override
    @Transactional
    public Group modGroup(String name) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Group getGroup(long gid) {
        return null;
    }
}
