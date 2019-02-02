package com.wuchenyv1990.dubbo.consumer;

import com.wuchenyv1990.dubbo.consumer.service.ConsumerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DubboConsumerMain.class)
public class ConsumerTest {

    @Autowired
    ConsumerService service;

    @Test
    public void test1() {
        Assert.assertEquals("service api called.", service.getInfo());
    }


}
