package com.lens.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-20 5:00 PM
 */

@RestController
public class EchoController {
    @Value("${spring.application.name}")
    String applicationName;



    @Value("${server.port}")
    private String serverPort;

    @GetMapping("echo")
    public String echo(){
        return applicationName + " run on " + serverPort;
    }
}
