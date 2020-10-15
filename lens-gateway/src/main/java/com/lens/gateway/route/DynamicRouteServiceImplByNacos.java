package com.lens.gateway.route;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

@Slf4j
//@Component
public class DynamicRouteServiceImplByNacos {

    @Value("${spring.cloud.nacos.discovery.server-addr:127.0.0.1:8848}")
    private String nacosServer;

    @Value("${gateway.routes.nacos.namespace}")
    private String namespace;

    @Value("${gateway.routes.nacos.dataId}")
    private String dataId;

    @Value("${gateway.routes.nacos.group}")
    private String group;

    private DynamicRouteServiceImpl dynamicRouteService;

    @Autowired
    public DynamicRouteServiceImplByNacos(DynamicRouteServiceImpl dynamicRouteService) {
        this.dynamicRouteService = dynamicRouteService;
    }

    /**
     * 监听Nacos Server下发的动态路由配置
     */
//    @PostConstruct
    public void dynamicRouteByNacosListener (){
        try {
            Properties configServerProp = new Properties();
            configServerProp.put("serverAddr",nacosServer);
//            configServerProp.put("namespace",namespace);

            ConfigService configService=NacosFactory.createConfigService(configServerProp);
//            ConfigService configService=NacosFactory.createConfigService(nacosServer);
            String content = configService.getConfig(dataId, group, 5000);
            log.info("Loading routes: {}", content);
            addAndPublishBatchRoute(content);

            configService.addListener(dataId, group, new Listener()  {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    addAndPublishBatchRoute(configInfo);
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            //todo 提醒:异常自行处理此处省略
        }
    }

    private void addAndPublishBatchRoute(String configInfo) {
        try {
            dynamicRouteService.clearRoute();
            List<RouteDefinition> gatewayRouteDefinitions = JSON.parseArray(configInfo, RouteDefinition.class);
            for (RouteDefinition routeDefinition : gatewayRouteDefinitions) {
                dynamicRouteService.add(routeDefinition);
            }
            log.info("Dynamic config gateway route finished. {}", JSON.toJSONString(gatewayRouteDefinitions));
            dynamicRouteService.publish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    synchronized private void updataRoutes(String configInfo){
        List<RouteDefinition> definitions = JSON.parseArray(configInfo, RouteDefinition.class);
        log.info("Receiving routes ：{}", definitions);
        for(RouteDefinition definition: definitions) {
            dynamicRouteService.update(definition);
        }
    }
}
