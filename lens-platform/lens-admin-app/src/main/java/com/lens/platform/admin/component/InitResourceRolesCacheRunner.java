package com.lens.platform.admin.component;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-22 2:17 PM
 */

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 容器启动完成加载资源权限数据到缓存
 */
@Component
@AllArgsConstructor
@Slf4j
public class InitResourceRolesCacheRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

    }
}
