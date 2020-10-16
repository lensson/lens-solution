package com.lens.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 *  白名单配置
 * @author Lens Chen
 * @created 2020-10-15 11:39 AM
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "whitelist")
public class WhiteListConfig {

    private List<String> urls = new ArrayList<String>();

}
