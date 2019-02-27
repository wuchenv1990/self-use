package com.wuchenyv1990.mybatis.manager;

import com.wuchenyv1990.mybatis.entity.Group;
import com.wuchenyv1990.mybatis.manager.itf.GroupMgr;
import com.wuchenyv1990.mybatis.manager.itf.UserMgr;
import com.wuchenyv1990.mybatis.mapper.GroupMapper;
import com.wuchenyv1990.mybatis.util.Dict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
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
        groupMapper.delGroup(gid);
    }

    @Override
    @Transactional
    public void modGroup(Group group) {
        groupMapper.modGroup(group);
    }

    @Override
    @Transactional(readOnly = true)
    public Group getGroup(long gid) {
        return Optional.ofNullable(groupMapper.getGroups(Dict.set("gid", gid)).get(0))
            .orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Group getGroup(String name) {
        return Optional.ofNullable(groupMapper.getGroups(Dict.set("name", name)).get(0))
            .orElse(null);
    }
}
