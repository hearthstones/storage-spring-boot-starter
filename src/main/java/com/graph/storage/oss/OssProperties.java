package com.graph.storage.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云oss配置类
 *
 * @author luchao
 * @since 2022/9/26
 */
@Data
@ConfigurationProperties(prefix = "oss")
public class OssProperties {



}
