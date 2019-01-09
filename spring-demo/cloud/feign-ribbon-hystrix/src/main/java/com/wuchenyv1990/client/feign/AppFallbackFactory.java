package com.wuchenyv1990.client.feign;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppFallbackFactory implements FallbackFactory<AppFeignCli> {

    Logger logger = LoggerFactory.getLogger(AppFallbackFactory.class);

    @Override
    public AppFeignCli create(Throwable throwable) {

        return new AppFeignCli() {
            @Override
            public String getInfo() {
                logger.error("feign call failed : " + throwable.getMessage());
                return "Fallback info.";
            }

            @Override
            public String failCall() {
                logger.error("feign call failed : " + throwable.getMessage());
                return "Fallback info.";
            }

            @Override
            public String error500() {
                logger.error("feign call failed : " + throwable.getMessage());
                return "Info error 500";
            }
        };
    }
}
