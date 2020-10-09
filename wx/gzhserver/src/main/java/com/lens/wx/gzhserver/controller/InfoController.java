package com.lens.wx.gzhserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * :
 * Controller of Info
 *
 * @author Lens Chen
 * @create 2020-10-09 11:30 AM
 */
@RestController
@RequestMapping("info")
public class InfoController {

    @GetMapping("list")
    public String getList(){
        return "info list";
    }
}
