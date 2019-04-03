package com.wuchenyv1990.web.common;

import com.wuchenyv1990.web.util.SessionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@RestControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AccessDeniedException.class)
    public Result<?> accessDenied(AccessDeniedException e) {
        return Result.accessDeny(
            "User: " +
                Optional.ofNullable(SessionUtils.getCurrentUser().getUsername()).orElse(null)
                + " was denied. ",
            SessionUtils.getRequest().getServletPath()
        );
    }

}
