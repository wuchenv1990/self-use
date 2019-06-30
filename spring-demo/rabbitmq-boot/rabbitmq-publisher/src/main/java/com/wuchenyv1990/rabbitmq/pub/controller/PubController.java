package com.wuchenyv1990.rabbitmq.pub.controller;


import com.wuchenyv1990.rabbitmq.pub.service.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/pub")
public class PubController {

    @Autowired
    MsgSender msgSender;

    @PutMapping("/direct")
    public void direct(@RequestParam String route, @RequestParam
            String msg) {
        msgSender.send(route, msg);
    }

    @PutMapping("/broadcast")
    public void fanout(@RequestParam String msg) {
        msgSender.broadcast(msg);
    }

}
