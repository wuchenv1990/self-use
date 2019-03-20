package com.wuchenyv1990.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Configuration
    @Order(1)
    protected static class RestSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        AuthenticationProvider authenticationProvider;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/rest/**")
                .addFilterAt(
                    new BasicAuthenticationFilter(
                        new ProviderManager(Arrays.asList(authenticationProvider))),
                    BasicAuthenticationFilter.class
                )
                .exceptionHandling()
                .authenticationEntryPoint(new DigestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .hasRole("REST");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider);
        }
    }

    @Configuration
    protected static class FormLoginWebSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .addFilterAt(
                    usernamePasswordAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
                )
                .exceptionHandling()
                .authenticationEntryPoint(
                    new LoginUrlAuthenticationEntryPoint(SecurityConsts.LOGIN_URL))
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**")
                .authenticated();
        }

    }

    @Bean(BeanIds.USER_DETAILS_SERVICE)
    public UserDetailsService userDetailsService() {
        return new MockUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new MockAuthenticationProvider(userDetailsService());
    }

    @Bean
    public UsernamePasswordAuthenticationFilter UsernamePasswordAuthenticationFilter() {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
        //登录post校验地址
        filter.setRequiresAuthenticationRequestMatcher(
            new AntPathRequestMatcher(SecurityConsts.LOGIN_URL, HttpMethod.POST.toString())
        );
        filter.setUsernameParameter(SecurityConsts.USER_NAME);
        filter.setPasswordParameter(SecurityConsts.PWD);
        filter.setAuthenticationSuccessHandler(new LoginAuthenticationSuccessHandler());
        filter .setAuthenticationManager(
            new ProviderManager(Arrays.asList(authenticationProvider())));
        return filter;
    }

}
