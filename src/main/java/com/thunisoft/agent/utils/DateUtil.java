/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.utils
 * @className com.thunisoft.agent.utils.DateUtil
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;

/**
 * DateUtil
 * @description
 * @author tlz
 * @date 2019-04-25 18:23
 * @version 1.1.0
 */
public class DateUtil {

    private DateUtil() {
    }

    public static Long strToTimestamp(String timeStr) {
        DateTime dateTime = new DateTime(timeStr, DatePattern.NORM_DATETIME_FORMAT);
        return dateTime.getTime() / 1000;
    }

}
