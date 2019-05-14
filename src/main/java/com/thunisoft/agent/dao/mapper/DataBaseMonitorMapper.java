/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.dao.mapper
 * @className com.thunisoft.agent.dao.mapper.DataBaseMonitorMapper
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.dao.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * DataBaseMonitorMapper
 * @description
 * @author tlz
 * @date 2019-05-13 13:59
 * @version 1.1.0
 */
@Component
public interface DataBaseMonitorMapper {
    List<Map> getDBmonitorList();
}
