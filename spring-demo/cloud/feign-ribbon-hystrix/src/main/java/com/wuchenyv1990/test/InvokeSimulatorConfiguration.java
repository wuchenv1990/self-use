package com.wuchenyv1990.test;

import com.wuchenyv1990.service.FeighAppService;
import com.wuchenyv1990.service.RibbonAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnProperty("rest.invoke-simulator")
public class InvokeSimulatorConfiguration {

    /**
     * 随机发请求，为dashboard提供数据
     */
    @Bean
    public InvokeSimulator invokeSimulator() {
        return new InvokeSimulator();
    }

    static class InvokeSimulator {

        @Autowired
        RibbonAppService ribbonAppService;

        @Autowired
        FeighAppService feighAppService;

        @EventListener(classes = ApplicationReadyEvent.class)
        public void startInvoke() {
            Runnable[] rs = new Runnable[]{
                    feighAppService::getInfo,
                    feighAppService::doFailCall,
                    feighAppService::error500,
                    ribbonAppService::getInfo,
                    ribbonAppService::doFailCall,
                    ribbonAppService::error500
            };
            Thread t = new Thread(() -> {
                Random r = new Random();
                while (true) {
                    try {
                        rs[r.nextInt(rs.length)].run();
                        TimeUnit.MILLISECONDS.sleep(r.nextInt(500));
                    } catch (InterruptedException e) {
                    }

                }
            }, "InvokeSimulatorThread");
            t.start();
        }

    }

}
