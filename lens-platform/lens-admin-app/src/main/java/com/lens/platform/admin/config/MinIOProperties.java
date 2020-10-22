package com.lens.platform.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-22 2:19 PM
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinIOProperties {

    private String endpoint;

    private String accessKey;

    private String secretKey;

}
