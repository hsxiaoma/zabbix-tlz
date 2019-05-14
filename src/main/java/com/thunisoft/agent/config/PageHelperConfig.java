/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.config
 * @className com.thunisoft.agent.config.PageHelperConfig
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * PageHelperConfig
 * @description
 * @author tlz
 * @date 2019-05-13 10:22
 * @version 1.1.0
 */
@Configuration
public class PageHelperConfig {

    /**
     * @description 配置mybatis的分页插件pageHelper
     * @return  PageHelper
     * @date 2019/5/13 10:25
     * @version 3.0.0
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","postgresql");
        //配置postgresql数据库的方言支持Oracle,Mysql,MariaDB,SQLite,Hsqldb,PostgreSQL六种数据库
        pageHelper.setProperties(properties);
        return pageHelper;
    }


}
