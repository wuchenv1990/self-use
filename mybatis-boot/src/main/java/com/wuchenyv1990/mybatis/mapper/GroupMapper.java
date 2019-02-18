package com.wuchenyv1990.mybatis.mapper;

import com.wuchenyv1990.mybatis.entity.Group;
import jdk.internal.jline.internal.Nullable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMapper {


    Group addGroup(Group group);

    void delGroup(long gid);

    Group getGroup(long gid);

}
