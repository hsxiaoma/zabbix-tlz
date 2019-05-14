/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.utils
 * @className com.thunisoft.agent.utils.ObjectToMapUtil
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.utils;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * ObjectToMapUtil
 * @description
 * @author tlz
 * @date 2019-04-25 11:41
 * @version 1.1.0
 */
public class ObjectToMapUtil {

    private static final Log log = LogFactory.get();

    public static Map<String, Object> objectToMap(Object requestParameters) {

        Map<String, Object> map = new HashMap<>(16);

        Field[] fields = requestParameters.getClass().getDeclaredFields();
        try {
            for (int i = 0, len = fields.length; i < len; i++) {
                String varName = fields[i].getName();
                boolean accessFlag = fields[i].isAccessible();
                fields[i].setAccessible(true);
                Object o = fields[i].get(requestParameters);
                if (o != null) {
                    map.put(varName, o);
                    fields[i].setAccessible(accessFlag);
                }
            }
        } catch (IllegalAccessException e) {
            log.error("实体请求参数转化Map异常，{}", e);
        }
        return map;
    }

}
