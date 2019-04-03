package com.wuchenyv1990.web.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

    public static User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal != null && principal instanceof User
            ? (User) principal
            : null;
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)
            RequestContextHolder.getRequestAttributes())
            .getRequest();
    }

}
