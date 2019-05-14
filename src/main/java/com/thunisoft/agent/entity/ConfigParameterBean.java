/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.entity
 * @className com.thunisoft.agent.entity.ConfigParameterBean
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.entity;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ConfigParameterBean
 * @description 配置参数实体，主要配置zabbix监控项的 请求参数
 * @author tlz
 * @date 2019-05-08 18:16
 * @version 1.1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigParameterBean {

    String host;

    JSONObject interfaces;

    JSONObject groups;

    JSONObject templates;

    JSONObject inventory;
}
