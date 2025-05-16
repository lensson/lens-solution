package com.lens.platform.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Api(value = "Hello分类相关接口", tags = {"Hello分类相关接口"})
@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloController {


    @ApiOperation(value = "Hello", notes = "", response = String.class)
    @GetMapping("/hello")
    public String hello() {
        return "Hello at " + new Date();
    }

}
