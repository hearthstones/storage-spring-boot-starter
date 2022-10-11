package com.graph.storage.oss;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 阿里云oss自动注入
 *
 * @author luchao
 * @since 2022/9/26
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties({OssProperties.class})
@Import({OssStrategy.class})
public class OssAutoConfiguration {



}
