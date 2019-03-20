package com.wuchenyv1990.web.controller;

import com.wuchenyv1990.web.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ApiController {

    @GetMapping("/test")
    public Result<String> test() {
        return new Result<String>("rest");
    }

}
