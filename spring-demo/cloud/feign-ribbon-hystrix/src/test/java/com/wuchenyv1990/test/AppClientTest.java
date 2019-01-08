package com.wuchenyv1990.test;

import com.wuchenyv1990.AppCliMain;
import com.wuchenyv1990.service.RibbonAppService;
import com.wuchenyv1990.service.itf.AppServiceItf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppCliMain.class)
public class AppClientTest {

    @Autowired
    @Qualifier("feighAppService")
    AppServiceItf feighAppService;

    @Autowired
    RibbonAppService ribbonAppService;

    @Test
    public void test1() {
        IntStream.range(0, 10)
                .forEach(it -> System.out.println("feign client return : " + feighAppService.getInfo()));
    }

    @Test
    public void test2() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("ribbon client return : " + ribbonAppService.getInfo()));
    }

    @Test
    public void test3() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("ribbon api return : " + ribbonAppService.getInfoByApi()));
    }
}

