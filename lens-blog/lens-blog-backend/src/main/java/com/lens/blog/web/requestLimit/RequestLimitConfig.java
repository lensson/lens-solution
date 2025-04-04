package com.lens.blog.web.requestLimit;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * RequestLimitConfig
 *
 * @author: Lens
 * @create: 2020-03-06-18:58
 */
@ConfigurationProperties(prefix = "request-limit")
@Component
@Data
public class RequestLimitConfig {

    /**
     * 允许访问的数量
     */
    public int amount;
    /**
     * 时间段
     */
    public long time;
}
