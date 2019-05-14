/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.dao
 * @className com.thunisoft.agent.dao.HostDao
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * HostDao
 * @description
 * @author tlz
 * @date 2019-05-10 18:02
 * @version 1.1.0
 */

@Mapper
@CacheConfig(cacheNames = "host")
public interface HostDao {

    @Select("select * from  db_mserver.t_host")
    @Cacheable(key = "#root.methodName")
    List<Map> getHostList();

}
