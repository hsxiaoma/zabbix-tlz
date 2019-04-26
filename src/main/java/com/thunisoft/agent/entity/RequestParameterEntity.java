/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.entity
 * @className com.thunisoft.agent.entity.RequestParameterEntity
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RequestParameterEntity
 * @description 封装请求参数
 * @author tlz
 * @date 2019-04-25 11:18
 * @version 1.1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestParameterEntity {

    /** 要返回的对象属性，默认值：extend */
    String output;

    /** 仅返回与给定过滤器完全匹配的结果。
     接受一个数组，其中键是属性名称，值是单个值或要匹配的值数组。 */
    JSONObject filter;

    /** 主机id */
    String hostids;

    /** 返回与给定通配符搜索匹配的结果（不区分大小写）。
     接受一个数组，其中键是属性名称，值是要搜索的字符串。如果没有给出其他选项，则会执行LIKE “%…%”搜索。
     仅适用于string和text字段 */
    JSONObject search;

    /** 监控项id */
    String itemids;

    /** 历史数据类型  Possible values:0 - numeric float;  1 - character;2 - log;3 - numeric unsigned;4 - text. Default: 3 */
    Integer history;

    /** 开始时间 Return only values that have been received after or at the given time. */
    String time_from;

    /** 结束时间 Return only values that have been received before or at the given time. */
    String time_till;



    /** Sort the result by the given properties. Possible values are: itemid and clock */
    String sortfield;

    /** according to the sortfield parameter order,Possible values are:ASC - ascending;  DESC - descending.*/
    String sortorder;

    /** Limit the number of records returned. */
    Integer limit;

}
