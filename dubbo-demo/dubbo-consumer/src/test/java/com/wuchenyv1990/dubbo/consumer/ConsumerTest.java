package com.wuchenyv1990.dubbo.consumer;

import com.wuchenyv1990.dubbo.consumer.service.ConsumerService;
import com.wuchenyv1990.dubbo.provider.DubboProviderMain;
import org.apache.curator.test.TestingServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {/*DubboProviderMain.class,*/ DubboConsumerMain.class})
public class ConsumerTest {

    @Autowired
    ConsumerService service;

    static TestingServer zookeeper;

    @BeforeClass
    public static void initProvider() {
        try {
            TestingServer zookeeper = new TestingServer(2181, true);
        } catch (Exception e) {
            System.out.println("2181 occupied, zk may running in env.");
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals("service api called.", service.getInfo());
    }

    @AfterClass
    public static void terminateServer() {
        try {
            zookeeper.stop();
        } catch (NullPointerException | IOException ignore) {
        }
    }

}
