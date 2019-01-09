package com.wuchenyv1990.restApi;

import com.wuchenyv1990.exception.ServerException;
import com.wuchenyv1990.service.itf.ServiceItf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("app")
public class ServiceController {

    Logger logger = LoggerFactory.getLogger(ServiceController.class);

    Random r = new Random();

    @Autowired
    ServiceItf serviceItf;

    @GetMapping("info")
    public String info() {
        logger.info("info called");
        return serviceItf.getInfo();
    }

    @GetMapping("error500")
    public String throwException2() {
        if (r.nextInt(100) < 40) {
            throw new ServerException("throw exception in app.", 1);
        }
        return "partly return succeed";
    }

}
