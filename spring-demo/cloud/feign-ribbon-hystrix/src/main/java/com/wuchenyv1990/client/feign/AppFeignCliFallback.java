package com.wuchenyv1990.client.feign;

import org.springframework.stereotype.Component;

//@Component
public class AppFeignCliFallback implements AppFeignCli {

    private final String FAIL_INFO = "Fallback info in AppFeignCliFallback.";

    @Override
    public String getInfo() {
        return FAIL_INFO;
    }

    @Override
    public String failCall() {
        return FAIL_INFO;
    }

    @Override
    public String error500() {
        return FAIL_INFO;
    }
}
