# zabbix-tlz
zabbix监控API，简易的封装处理，实用的功能，针对获取数据。


我们可以很简单的请求Zabbix的一切监控数据，当然你也可以通过 request 请求Zabbix的数据端口，同时你也可以向zabbix的 10051（默认）端口发送数据。
下面让我们来简单的使用zabbixAPI


1. 通过构造请求参数 RequestParameterEntity 类中的属性就是Post请求中的 请求参数 （根据官方文档可增加，并没有将所有请求属性包含）
```Java
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
```
2. 通过封装请求方法 调用相关信息（如主机、监控项、监控数据）

```java
   /*——————————————————————获取主机id————————————————————————————————*/
        // 获取主机id
        JSONObject filter = new JSONObject();
        filter.put("ip", filterIpAddress);
        RequestParameterEntity requestParameterEntity = new RequestParameterEntity();
        requestParameterEntity.setOutput("hostid");
        requestParameterEntity.setFilter(filter);
        ZabbixRequest zabbixRequest = new ZabbixRequest().login("http://ip/api_jsonrpc.php", "user", "pwd")
                .getHostId(requestParameterEntity);
       /*——————————————————————获取历史数据————————————————————————————————*/
        // 获取历史数据
        RequestParameterEntity requestParameterEntity2 = new RequestParameterEntity();
        requestParameterEntity2.setOutput("extend");
        // requestParameterEntity2.setHistory(NUMERIC_UNSIGNED);
        requestParameterEntity2.setItemids((String) zabbixRequest.itemId.get(1));

        requestParameterEntity2.setSortfield("clock");
        requestParameterEntity2.setSortorder("DESC");
        requestParameterEntity2.setLimit(10);
        requestParameterEntity2.setTime_from("1552536000");
        requestParameterEntity2.setTime_till("1556164800");
        zabbixRequest.getHistory(requestParameterEntity2)         
                
 ```
 方法基于链式调用，可以很方便的调用方法，最后获取目标数据，这使得代码更为简洁。
 
 ##在ParametersConst  中封装了  请求方法，以及常量信息，目前主要是获取，根据需要定义即可。
 
 
