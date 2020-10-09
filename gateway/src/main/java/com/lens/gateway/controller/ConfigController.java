package com.lens.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * :
 * Config Rest Controller
 *
 * @author Lens Chen
 * @create 2020-10-09 1:22 PM
 */
@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigController {

    @Value("${config.string:0}")
    private String configString;

    @GetMapping("string")
    public String getConfigString(){
        return configString;
    }
}
