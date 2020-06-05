package com.wuchenyv1990.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * user—group 关系表，多对多
 */
@Mapper
public interface UGMapper {

    @Insert("INSERT `user_to_group`(uid, gid) VALUES (#{uid}, #{gid})")
    void addUG(long uid, long gid);

    @Delete("DELETE FROM `user_to_group` WHERE `uid` = #{uid} AND `gid` = #{gid}")
    void rmUG(long uid, long gid);

    /**
     * 删除所有uid=#{uid}记录
     *
     * @param uid uid
     */
    @Delete("DELETE FROM `user_to_group` WHERE `uid` = #{uid}")
    void rmUser(long uid);

    /**
     * 删除所有gid=#{gid}记录
     *
     * @param gid gid
     */
    @Delete("DELETE FROM `user_to_group` WHERE `gid` = #{gid}")
    void rmGroup(long gid);

    @Select("SELECT `gid` FROM `user_to_group` WHERE `uid` = #{uid}")
    Set<Long> getGids(long uid);

}
