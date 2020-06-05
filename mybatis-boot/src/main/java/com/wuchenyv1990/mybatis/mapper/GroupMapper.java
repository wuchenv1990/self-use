package com.wuchenyv1990.mybatis.mapper;

import com.wuchenyv1990.mybatis.entity.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface GroupMapper {

    @Insert("INSERT INTO `group`(`name`) VALUES (#{name})")
    @Options(useGeneratedKeys=true, keyProperty="gid", keyColumn="gid")
    void addGroup(Group group);

    @Delete("DELETE FROM `group` WHERE `gid` = #{gid}")
    void delGroup(long gid);

    @Update("UPDATE `group` SET `name` = #{name} WHERE gid = #{gid}")
    void modGroup(Group group);

    @SelectProvider(type = GroupProvider.class, method = "getGroups")
    List<Group> getGroups(Map<String, ?> params);

}
