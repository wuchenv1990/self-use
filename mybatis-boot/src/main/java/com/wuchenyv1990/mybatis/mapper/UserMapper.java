package com.wuchenyv1990.mybatis.mapper;

import com.wuchenyv1990.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.Set;

@Mapper
public interface UserMapper {

    User addUser(User user);

    void delUser(long uid);

    User chUserName(long uid, String name);

    User getUser(Map<String, Object> params);

}
