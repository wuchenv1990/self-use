package com.wuchenyv1990.mybatis.mapper;

import com.wuchenyv1990.mybatis.entity.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface GroupMapper {

    @Insert("INSERT INTO TBL_GROUP(name) VALUES (#{name})")
    @Options(useGeneratedKeys=true, keyProperty="gid", keyColumn="gid")
    void addGroup(Group group);

    @Delete("DELETE FROM TBL_GROUP WHERE gid = #{gid}")
    void delGroup(long gid);

    @Update("UPDATE TBL_GROUP SET name = #{name} WHERE gid = #{gid}")
    void modGroup(Group group);

    @SelectProvider(type = GroupProvider.class, method = "getGroups")
    List<Group> getGroups(Map<String, ?> params);

}
