/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.controller
 * @className com.thunisoft.agent.controller.ZabbixApiController
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thunisoft.agent.api.ZabbixRequest;
import com.thunisoft.agent.dao.HostDao;
import com.thunisoft.agent.dao.mapper.DataBaseMonitorMapper;
import com.thunisoft.agent.entity.CommonResponse;
import com.thunisoft.agent.utils.ResponseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ZabbixApiController
 * @description
 * @author tlz
 * @date 2019年04月22日 14:05
 * @version 1.1.0
 */
@RestController
@RequestMapping("/api")
public class ZabbixApiController {

    @Autowired
    ZabbixRequest zabbixRequest;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HostDao hostDao;

    @Autowired
    DataBaseMonitorMapper dataBaseMonitorMapper;

    @RequestMapping("/sessionId")
    public String login() {
        return "";
    }

    @RequestMapping("/hostId")
    public String getHostId(@RequestParam(required = false) String[] ip, @RequestParam(required = false) String auth) {
        return "";
    }

    @RequestMapping("/itemId")
    public String getHostId(@RequestParam(required = false) String hostId) {
        return "";
    }

    @RequestMapping("/history")
    public String getHistory(@RequestParam(required = false) String hostId) {
        return "";
    }

    @RequestMapping("/test")
    public CommonResponse getHistory(@RequestParam(required = false, defaultValue = "1") String pageNum,
            @RequestParam(required = false, defaultValue = "10") String pageSize) {

        PageHelper.startPage(1, 2);
        List list = hostDao.getHostList();
        PageInfo<List> pageInfo = new PageInfo<List>(list);
        return ResponseResultUtil.success(list);
    }


    @RequestMapping("/testXML")
    public CommonResponse getHistory() {
        List list = dataBaseMonitorMapper.getDBmonitorList();
        return ResponseResultUtil.success(list);
    }

}
