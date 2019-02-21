package com.wuchenyv1990.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * user—group 关系表，多对多
 */
@Mapper
public interface UGMapper {

    void addUG(long uid, long gid);

    void rmUG(long uid, long gid);

    /**
     * 删除所有uid=#{uid}记录
     *
     * @param uid uid
     */
    void rmUser(long uid);

    /**
     * 删除所有gid=#{gid}记录
     *
     * @param gid gid
     */
    void rmGroup(long gid);
}
