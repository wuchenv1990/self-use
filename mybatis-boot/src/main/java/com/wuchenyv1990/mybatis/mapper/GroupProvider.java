package com.wuchenyv1990.mybatis.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class GroupProvider {

    public static String getGroups(Map<String, ?> params) {
        return new SQL(){{
            SELECT("*");
            FROM("`group`");
            if (params.get("gid") != null) {
                WHERE(condition("gid"));
            }
            if (params.get("name") != null) {
                WHERE(condition("name"));
            }
        }

        private String condition(String param) {
            return String.format("`%s` = #{%s}", param, param);
        }

        }.toString();
    }

}
