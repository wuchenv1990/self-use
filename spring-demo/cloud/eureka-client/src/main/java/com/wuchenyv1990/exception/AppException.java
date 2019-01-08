package com.wuchenyv1990.exception;

/**
 * 统一返回异常
 */
public class AppException extends RuntimeException {

    private Integer errorCode = -1;

    public AppException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
