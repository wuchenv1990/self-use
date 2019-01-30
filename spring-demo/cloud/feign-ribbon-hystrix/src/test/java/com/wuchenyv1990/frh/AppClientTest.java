package com.wuchenyv1990.frh;

import com.wuchenyv1990.frh.service.FeighAppService;
import com.wuchenyv1990.frh.service.RibbonAppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppCliMain.class)
public class AppClientTest {

    @Autowired
    FeighAppService feighAppService;

    @Autowired
    RibbonAppService ribbonAppService;

    /**
     * 由于懒加载默认超时时间可能引起熔断，可设置
     */
    @Test
    public void test1() {
        IntStream.range(0, 10)
                .forEach(it -> System.out.println("feign client return : " + feighAppService.getInfo()));
    }

    @Test
    public void test2() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("feign fail return : " + feighAppService.doFailCall()));
    }

    @Test
    public void test3() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("feign 500 return : " + feighAppService.error500()));
    }

    @Test
    public void test4() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("ribbon client return : " + ribbonAppService.getInfo()));
    }

    @Test
    public void test5() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("ribbon api return : " + ribbonAppService.getInfoByApi()));
    }

    @Test
    public void test6() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("ribbon failCall return : " + ribbonAppService.doFailCall()));
    }

    @Test
    public void test7() {
        IntStream.range(0, 4)
                .forEach(it -> System.out.println("ribbon failCall return : " + ribbonAppService.error500()));
    }

}

