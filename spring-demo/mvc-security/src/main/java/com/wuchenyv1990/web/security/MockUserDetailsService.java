package com.wuchenyv1990.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟从数据库加载userDetails
 */
public class MockUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User mockUser = null;
        List<GrantedAuthority> authorityList = new ArrayList<>();
        switch (username) {
            case "admin" :
                authorityList = new ArrayList<>();
                authorityList.add(new SimpleGrantedAuthority(SecurityConsts.PERM_ADMIN));
                authorityList.add(new SimpleGrantedAuthority(SecurityConsts.PERM_R));
                authorityList.add(new SimpleGrantedAuthority(SecurityConsts.PERM_W));
                mockUser = new User(
                    "admin",
                    "admin",
                    authorityList
                );
                break;
            case "rest":
                authorityList.add(new SimpleGrantedAuthority(SecurityConsts.PERM_REST));
                mockUser = new User(
                    "rest",
                    "admin",
                    authorityList
                );
                break;
            default:
                mockUser = new User(
                    username,
                    "optional",
                    authorityList
                );
        }
        return mockUser;
    }
}
