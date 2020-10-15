package com.lens.gateway;

import com.lens.gateway.route.DynamicRouteServiceImplByNacos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


//@Component
//public class ApplicationStartup implements ApplicationRunner {
//
//    @Value("gateway.routes.nacos.dataId")
//    private String dataId;
//
//    @Value("gateway.routes.nacos.group")
//    private String group;
//
//    @Autowired
//    private DynamicRouteServiceImplByNacos dynamicRouteServiceImplByNacos;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        dynamicRouteServiceImplByNacos.dynamicRouteByNacosListener(dataId, group);
//    }
//}
