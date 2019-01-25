package com.wuchenyv1990.eureka.client.common.model;

public class StateResult {

    private Integer errorCode;
    private String message;

    /**
     * for json serialize
     */
    public StateResult() {
    }

    public StateResult(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
