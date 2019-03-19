package com.wuchenyv1990.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/svc")
public class ServiceController {

    @GetMapping("/test")
    public Map<String, String> test() {
        return new HashMap<String, String>() {{
            put("value", "scv");
        }};
    }

}
