package com.graph.storage.obs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 华为云obs配置类
 *
 * @author luchao
 * @since 2022/9/15
 */
@Data
@ConfigurationProperties(prefix = "obs")
public class ObsProperties {

    /**
     * OBS为每个区域提供Endpoint，用于处理各自区域的访问请求
     */
    private String endpoint;

    /**
     * 访问密钥AK
     */
    private String accessKey;

    /**
     * 访问密钥SK
     */
    private String secretKey;

    /**
     * 桶名称
     */
    private String bucketName;

}
