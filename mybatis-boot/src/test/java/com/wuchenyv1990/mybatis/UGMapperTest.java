package com.wuchenyv1990.mybatis;

import com.wuchenyv1990.mybatis.mapper.UGMapper;
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

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisAppMain.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UGMapperTest {

    @Resource
    UGMapper ugMapper;

    @Test
    public void test01_get() {
        Assert.assertTrue(ugMapper.getGids(1L).contains(1L));
    }

    @Test
    @Rollback(false)
    public void test02_add() {
        ugMapper.addUG(1L, 2L);
        Assert.assertTrue(ugMapper.getGids(1L).contains(2L));
    }

    @Test
    @Rollback(false)
    public void test03_delete() {
        ugMapper.rmUG(1L, 2L);
        Assert.assertFalse(ugMapper.getGids(1L).contains(2L));
    }

}
