package com.lens.wx.gzh.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * :
 * Echo Rest Controller for test
 *
 * @author Lens Chen
 * @create 2020-10-09 12:42 PM
 */
@Data
@RestController
public class EchoController {


    @Value("${spring.application.name}")
    private String applicationName;



    @Value("${server.port}")
    private String serverPort;

    @GetMapping("echo")
    public String echo(){
        return applicationName + " run on " + serverPort;
    }


}
