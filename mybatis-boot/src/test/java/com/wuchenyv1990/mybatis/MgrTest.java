package com.wuchenyv1990.mybatis;

import com.wuchenyv1990.mybatis.entity.Group;
import com.wuchenyv1990.mybatis.entity.User;
import com.wuchenyv1990.mybatis.manager.itf.GroupMgr;
import com.wuchenyv1990.mybatis.manager.itf.UserMgr;
import com.wuchenyv1990.mybatis.mapper.UGMapper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisAppMain.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MgrTest {

    @Resource
    UserMgr userMgr;

    @Resource
    GroupMgr groupMgr;

    @Resource
    UGMapper ugMapper;

    @Test
    public void t01_addUser() {
        User admin = new User();
        admin.setName("admin");
        admin.setPasswd("admin");
        Set<Long> gids = new HashSet<>();
        gids.add(1L);
        admin.setGids(gids);

        userMgr.addUser(admin);

        User user = userMgr.getUser("admin");
        Assert.assertEquals("admin", user.getName());
        Assert.assertEquals(gids, user.getGids());

    }

    @Test
    public void t02_addGroup() {
        Group group = new Group();
        group.setName("admin");
        groupMgr.addGroup(group);

        Set<Group> groups = new HashSet<>();
        groups.add(group);

        User user = userMgr.getUser("admin");
        userMgr.addToGroups(user, groups);

        user = userMgr.getUser("admin");
        Assert.assertTrue(user.getGids().contains(group.getGid()));
    }

    @Test
    public void t03_delGroup() {
        Group group = groupMgr.getGroup("admin");
        groupMgr.delGroup(group.getGid());

        User user = userMgr.getUser("admin");
        Assert.assertFalse(user.getGids().contains(group.getGid()));
    }

    @Test
    public void t04_delUser() {
        User user = userMgr.getUser("admin");
        userMgr.delUser(user);
        Assert.assertEquals(0, ugMapper.getGids(user.getUid()).size());
    }
}
