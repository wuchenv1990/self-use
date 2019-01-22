package com.wuchenyv1990.eureka.client.advice;

import com.wuchenyv1990.eureka.client.exception.AppException;
import com.wuchenyv1990.eureka.client.exception.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AppException.class)
    public StateResult handleAppException(AppException appException) {
        return new StateResult(appException.getErrorCode(), appException.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerException.class)
    public StateResult handleAppException(ServerException serverException) {
        return new StateResult(serverException.getErrorCode(), serverException.getMessage());
    }

    static class StateResult {
        Integer errorCode;
        String message;

        public StateResult(Integer errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }
    }
}
