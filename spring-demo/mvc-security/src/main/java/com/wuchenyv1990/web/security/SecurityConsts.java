package com.wuchenyv1990.web.security;

public class SecurityConsts {

    public static final String LOGIN_URL = "/login";

    /* key: UsernamePasswordAuthenticationFilter默认就是 */
    public static final String USER_NAME = "username";

    public static final String PWD = "password";

    /* 方法级权限示例 */
    public static final String PREFIX = "ROLE_";

    public static final String PERM_REST = PREFIX + "REST";

    public static final String PERM_ADMIN = PREFIX + "ADMIN";

    public static final String PERM_R = PREFIX + "READ";

    public static final String PERM_W = PREFIX + "WRITE";
}
