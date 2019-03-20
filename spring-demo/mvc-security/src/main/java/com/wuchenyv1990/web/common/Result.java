package com.wuchenyv1990.web.common;

public class Result<T> {

    public static final int SUCCESS = 0;

    public static final int UNKNOWN = -1;

    public static final Result<Void> ERROR =
        new Result(UNKNOWN, null, "unknown");

    private int code = SUCCESS;

    private T data;

    private String message;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(
        int code,
        T data,
        String message
    ) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
