/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.config
 * @className com.thunisoft.agent.config.RestTemplateConfig
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;




/**
 * RestTemplateConfig
 * @description 配置restTemplate
 * @author tlz
 * @date 2019年04月22日 13:54
 * @version 1.1.0
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }
}
