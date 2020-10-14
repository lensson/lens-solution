package com.lens.platform.security.controller;


import com.lens.platform.security.entity.User;
import com.lens.platform.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 平台用户 前端控制器
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/security/user")
public class UserController {

    @Autowired
    IUserService userService;


    public List<User> list(){
        return userService.list();
    }
}

