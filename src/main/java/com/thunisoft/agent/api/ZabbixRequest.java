/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.api
 * @className com.thunisoft.agent.api.ZabbixParam
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.api;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.thunisoft.agent.entity.ParametersConst;
import com.thunisoft.agent.entity.RequestParameterBean;
import com.thunisoft.agent.utils.ObjectToMapUtil;
import io.github.hengyunabc.zabbix.api.DefaultZabbixApi;
import io.github.hengyunabc.zabbix.api.Request;
import io.github.hengyunabc.zabbix.api.RequestBuilder;
import io.github.hengyunabc.zabbix.api.ZabbixApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ZabbixRequest
 * @description
 * @author tlz
 * @date 2019年04月23日 10:58
 * @version 1.1.0
 */
@Component
@PropertySource(value = { "classpath:/zabbix-api.properties" })
public class ZabbixRequest {

    private static final Log log = LogFactory.get();

    public String hostId;

    public List itemId;

    @Value("${zabbix.url}")
    String url;

    @Value("${zabbix.login.user}")
    String user;

    @Value("${zabbix.login,password}")
    String password;

    ZabbixApi zabbixApi;

    /**
     * login
     * @description 登录zabbix
     * @param url
     * @param user
     * @param password
     * @return com.thunisoft.agent.api.ZabbixRequest
     * @author tlz
     * @date 2019/4/25 10:46
     * @version 1.1.0
     */
    public ZabbixRequest login(String url, String user, String password) {
        zabbixApi = new DefaultZabbixApi(url);
        zabbixApi.init();
        boolean login = zabbixApi.login(user, password);
        if (login) {
            log.info("登录Zabbix成功。");
        } else {
            log.info("登录Zabbix失败，请检查登录信息。");
        }
        return this;
    }

    /**
     * getHostId
     * @description 获取主机id
     * @param  requestParameterBean   请求实体
     * @return com.thunisoft.agent.api.ZabbixRequest
     * @author tlz
     * @date 2019/4/25 10:45
     * @version 1.1.0
     */
    public ZabbixRequest getHostId(RequestParameterBean requestParameterBean) {
        Request getRequest = RequestBuilder.newBuilder().method(ParametersConst.HOST_GET).build();
        getRequest.setParams(ObjectToMapUtil.objectToMap(requestParameterBean));
        JSONObject getResponse = zabbixApi.call(getRequest);
        this.hostId = getResponse.getJSONArray("result").getJSONObject(0).getString("hostid");
        return this;
    }

    /**
     * getItemId
     * @description 获取监控项
     * @param requestParameterBean   请求实体
     * @return com.thunisoft.agent.api.ZabbixRequest
     * @author tlz
     * @date 2019/4/25 10:44
     * @version 1.1.0
     */
    public ZabbixRequest getItemId(RequestParameterBean requestParameterBean) {
        Request request = RequestBuilder.newBuilder().method(ParametersConst.ITEM_GET).build();
        request.setParams(ObjectToMapUtil.objectToMap(requestParameterBean));
        List tempList = new ArrayList();
        JSONObject getResponse = zabbixApi.call(request);
        getResponse.getJSONArray("result").forEach(map -> tempList.add(((Map) map).get("itemid")));
        this.itemId = tempList;
        return this;
    }

    /**
     * getHistory
     * @description 获取指定监控项的历史数据
     * @param requestParameterBean   请求实体
     * @return com.thunisoft.agent.api.ZabbixRequest
     * @author tlz
     * @date 2019/4/25 10:49
     * @version 1.1.0
     */

    public List<Map> getHistory(RequestParameterBean requestParameterBean) {

        Request request = RequestBuilder.newBuilder().method(ParametersConst.HISTORY_GET).build();

        request.setParams(ObjectToMapUtil.objectToMap(requestParameterBean));

        JSONObject getResponse = zabbixApi.call(request);

        List listHistory = new ArrayList();

        getResponse.getJSONArray("result").forEach(map -> listHistory.add(map));

        return listHistory;

    }

    public static void main(String[] args) {
        //获取一台主机数据流程：   通过ip获取 hostid   ---》通过hostid获取 itemid   --》用过itemid 获取 history 结果数据
        /*——————————————————————获取主机id————————————————————————————————*/
        // 获取主机id
        JSONObject filter = new JSONObject();
        filter.put("ip","172.25.16.188");
        RequestParameterBean requestParameterBean = new RequestParameterBean();
        requestParameterBean.setOutput("hostid");
        requestParameterBean.setFilter(filter);
        ZabbixRequest zabbixRequest = new ZabbixRequest().login("http://172.25.16.186/api_jsonrpc.php", "Admin", "zabbix")
                .getHostId(requestParameterBean);

        /*——————————————————————获取监控项数据————————————————————————————————*/
        // 获取监控项

        RequestParameterBean requestParameterBean1 = new RequestParameterBean();
        requestParameterBean1.setOutput("itemids");
        requestParameterBean1.setHostids(zabbixRequest.hostId);

           ///  添加 item 过滤条件 如名称 主键等
             // JSONObject search = new JSONObject();
             // search.put("name", "pgsql-version-ud");
             // requestParameterBean1.setSearch(search);

        zabbixRequest.getItemId(requestParameterBean1);
        /*——————————————————————获取历史数据————————————————————————————————*/
        // 获取历史数据
        RequestParameterBean requestParameterBean2 = new RequestParameterBean();
        requestParameterBean2.setOutput("extend");
        // requestParameterBean2.setHistory(NUMERIC_UNSIGNED);
        requestParameterBean2.setItemids((String) zabbixRequest.itemId.get(1));

        requestParameterBean2.setSortfield("clock");
        requestParameterBean2.setSortorder("DESC");
        requestParameterBean2.setLimit(10);
        requestParameterBean2.setTime_from("1552536000");
        requestParameterBean2.setTime_till("1556164800");
        System.out.println(zabbixRequest.getHistory(requestParameterBean2).toString());

    }
}
