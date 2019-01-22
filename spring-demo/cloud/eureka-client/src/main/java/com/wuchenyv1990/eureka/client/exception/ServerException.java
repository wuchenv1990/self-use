package com.wuchenyv1990.eureka.client.exception;

public class ServerException extends AppException {
    public ServerException(String message, Integer errorCode) {
        super(message, errorCode);
    }
}
