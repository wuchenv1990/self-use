package com.wuchenyv1990.mybatis;

import com.wuchenyv1990.mybatis.entity.Group;
import com.wuchenyv1990.mybatis.mapper.GroupMapper;
import com.wuchenyv1990.mybatis.util.Dict;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisAppMain.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupMapperTest {

    @Resource
    private GroupMapper groupMapper;

    /* mapper test */
    @Test
    public void test01_get() {
        Group root = groupMapper.getGroups(Dict.set("gid", 1L)).get(0);
        Assert.assertEquals("root", root.getName());
    }

    @Test
    @Rollback(false)
    public void test02_add() {
        Group g = new Group();
        g.setName("admin");
        groupMapper.addGroup(g);
        g = groupMapper.getGroups(Dict.set("name", "admin")).get(0);
        Assert.assertEquals("admin", g.getName());
    }

    @Test
    @Rollback(false)
    public void test03_mod() {
        Group g = groupMapper.getGroups(Dict.set("name","admin")).get(0);
        g.setName("auditor");
        groupMapper.modGroup(g);
        Assert.assertEquals(
            "auditor",
            groupMapper.getGroups(Dict.set("gid", g.getGid())).get(0).getName()
        );
    }

    @Test
    @Rollback(false)
    public void test04_delete() {
        Group g = groupMapper.getGroups(Dict.set("name","auditor")).get(0);
        groupMapper.delGroup(g.getGid());
        Assert.assertEquals(0, groupMapper.getGroups(Dict.set("name","auditor")).size());
    }
}
