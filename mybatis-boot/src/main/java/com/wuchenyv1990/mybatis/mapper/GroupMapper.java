package com.wuchenyv1990.mybatis.mapper;

import com.wuchenyv1990.mybatis.entity.Group;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface GroupMapper {

    void addGroup(Group group);

    void delGroup(long gid);

    Group modGroup(String name);

    Group getGroup(long gid);

}
