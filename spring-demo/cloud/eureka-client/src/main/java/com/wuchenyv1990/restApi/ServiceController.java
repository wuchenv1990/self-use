package com.wuchenyv1990.restApi;

import com.wuchenyv1990.service.itf.ServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class ServiceController {

    @Autowired
    ServiceItf serviceItf;

    @GetMapping("info")
    public String info() {
        return serviceItf.getInfo();
    }

}
