package com.wuchenyv1990.web.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 使用UserDetailsService获取UserDetails
 */
public class MockAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private UserDetailsService userDetailsService;

    public MockAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void additionalAuthenticationChecks(
        UserDetails userDetails,
        UsernamePasswordAuthenticationToken authentication
    ) throws AuthenticationException {
        //null
    }

    @Override
    protected UserDetails retrieveUser(
        String username,
        UsernamePasswordAuthenticationToken authentication
    ) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(username);
    }
}
