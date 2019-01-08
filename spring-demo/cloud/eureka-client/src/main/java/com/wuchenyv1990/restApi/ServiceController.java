package com.wuchenyv1990.restApi;

import com.wuchenyv1990.exception.ServerException;
import com.wuchenyv1990.service.itf.ServiceItf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class ServiceController {

    Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    ServiceItf serviceItf;

    @GetMapping("info")
    public String info() {
        logger.info("info called");
        return serviceItf.getInfo();
    }

    @GetMapping("error500")
    public String throwException2() {
        throw new ServerException("throw exception in app.", 1);
    }

}
