package com.wuchenyv1990.mybatis.mapper;

import com.wuchenyv1990.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    void addUser(User user);

    void delUser(Map<String, ?> params);

    void chUser(User user);

    List<User> getUsers(Map<String, ?> params);

}
