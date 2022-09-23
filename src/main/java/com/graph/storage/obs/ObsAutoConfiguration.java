package com.graph.storage.obs;

import com.obs.services.ObsClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

/**
 * 华为云obs自动注入
 *
 * @author luchao
 * @since 2022/9/15
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties({ObsProperties.class})
@Import({ObsProperties.class, ObsStrategy.class, ObsClient.class})
public class ObsAutoConfiguration {

    @Resource
    private ObsProperties obsProperties;

    @Bean
    @ConditionalOnMissingBean()
    public ObsClient obsClient() {
        return new ObsClient(obsProperties.getAccessKey(), obsProperties.getSecretKey(), obsProperties.getEndpoint());
    }

}
