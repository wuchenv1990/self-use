package com.wuchenyv1990.mybatis.mapper;

import com.wuchenyv1990.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User addUser(User user);

    void delUser(long uid);

    User chUser(User user);

    User getUser(long uid);

}
