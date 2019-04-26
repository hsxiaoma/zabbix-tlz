/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.entity
 * @className com.thunisoft.agent.entity.ParametersConst
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.entity;

/**
 * ParametersConst
 * @description 参数常量定义
 * @author tlz
 * @date 2019-04-25 11:01
 * @version 1.1.0
 */
public final class ParametersConst {

    /** 数值型 */
    public static final Integer NUMERIC = 0;

    /** 字符型 */
    public static final Integer CHARACTER = 1;

    /** 日志型 */
    public static final Integer LOG = 2;

    /** 无符号数值型 */
    public static final Integer NUMERIC_UNSIGNED = 3;

    /** 文本型 */
    public static final Integer TEXT = 4;

    /** 获取主机 */
    public static final String HOST_GET = "host.get";

    /** 获取监控项  */
    public static final String ITEM_GET = "item.get";

    /** 获取历史信息 */
    public static final String HISTORY_GET = "history.get";

}
