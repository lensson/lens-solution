package com.lens.wx.gzhserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * :
 * Feign Service of Gateway
 *
 * @author Lens Chen
 * @create 2020-10-09 2:18 PM
 */
@FeignClient("sc-gateway-server")
public interface GatewayFeignService {

    @GetMapping("echo")
    String getGatewayEcho();

}
