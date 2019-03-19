package com.wuchenyv1990.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;

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
                    BasicAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new DigestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                    .antMatchers("/**")
                    .hasRole("RSCLIENT");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider);
        }
    }

    @Configuration
    protected static class FormLoginWebSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        AuthenticationProvider authenticationProvider;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/svc/**")
                .addFilterAt(
                    new UsernamePasswordAuthenticationFilter(),
                    UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new DigestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .hasRole("RSCLIENT");
            http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider);
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

}
