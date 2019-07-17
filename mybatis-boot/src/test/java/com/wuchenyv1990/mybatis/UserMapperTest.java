package com.wuchenyv1990.mybatis;

import com.wuchenyv1990.mybatis.entity.User;
import com.wuchenyv1990.mybatis.manager.itf.UserMgr;
import com.wuchenyv1990.mybatis.mapper.UserMapper;
import com.wuchenyv1990.mybatis.util.Dict;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisAppMain.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Resource
    UserMgr userMgr;

    /* mapper test */
    @Test
    public void test01_get() {
        User root = userMapper.getUsers(Dict.set("uid", "1").and("name", "root")).get(0);
        Assert.assertEquals("root", root.getName());
        Assert.assertEquals("root", root.getPasswd());
    }

    @Test
    @Rollback(false)
    public void test02_add() {
        User u = new User();
        u.setName("admin");
        u.setPasswd("admin");
        userMapper.addUser(u);

        u = userMapper.getUsers(Dict.set("name", "admin")).get(0);
        Assert.assertEquals("admin", u.getName());
        Assert.assertEquals("admin", u.getPasswd());
    }

    @Test
    @Rollback(false)
    public void test03_mod() {
        User u = userMapper.getUsers(Dict.set("name", "admin")).get(0);
        u.setPasswd("passwd");
        userMapper.chUser(u);
        Assert.assertEquals(
                "passwd",
                userMapper.getUsers(Dict.set("name", "admin")).get(0).getPasswd()
        );
    }

    @Test
    @Rollback(false)
    public void test04_delete() {
        userMapper.delUser(Dict.set("name", "admin"));
        Assert.assertEquals(0, userMapper.getUsers(Dict.set("name", "admin")).size());
    }

    @Test
    @Rollback
    public void test05_addMulti() {
        User u1 = new User();
        u1.setName("1");
        u1.setPasswd("1");

        User u2 = new User();
        u2.setName("2");
        u2.setPasswd("2");

        List<User> l = new ArrayList<>(2);
        l.add(u1);
        l.add(u2);
        userMapper.addUsers(l);

        l.stream().map(User::getUid).forEach(Assert::assertNotNull);
    }
}
